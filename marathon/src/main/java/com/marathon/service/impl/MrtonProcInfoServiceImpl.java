package com.marathon.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import cn.hutool.core.convert.Convert;
import com.google.common.base.Strings;
import com.marathon.MrthonMenuEnum;
import com.marathon.MrtonProcEnum;
import com.marathon.MrtonProcStatusEnum;
import com.marathon.domain.MarathonInfo;
import com.marathon.domain.MrtonProcCfgResource;
import com.marathon.domain.MrtonProcCfgResourceExample;
import com.marathon.mapper.MrtonProcCfgResourceMapper;
import com.marathon.mapper.customize.MrtProcInfoCustomizeMapper;
import com.marathon.qvo.MrthonMenuBean;
import com.marathon.qvo.MrtonProcCommonQVO;
import com.marathon.qvo.MrtonProcInfoVO;
import com.marathon.qvo.MyMrtonProcVO;
import com.marathon.service.IMrtonProcCfgService;
import com.mton.common.utils.DateUtil;
import com.mton.system.domain.SysMenu;
import com.mton.system.domain.SysUser;
import com.mton.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.mapper.MrtonProcInfoMapper;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.service.IMrtonProcInfoService;

/**
 * 赛事过程关系 服务层实现
 *
 * @author cuigq
 * @date 2019-10-08
 */
@Slf4j
@Service
public class MrtonProcInfoServiceImpl implements IMrtonProcInfoService {
    @Autowired
    private MrtonProcInfoMapper mrtonProcInfoMapper;

    @Autowired
    private MrtProcInfoCustomizeMapper mrtProcInfoCustomizeMapper;

    @Autowired
    private MrtonProcCfgResourceMapper mrtonProcCfgResourceMapper;

    /**
     * 查询赛事过程关系信息
     *
     * @param id 赛事过程关系ID
     * @return 赛事过程关系信息
     */
    @Override
    public MrtonProcInfo selectMrtonProcInfoById(String id) {
        return mrtonProcInfoMapper.selectMrtonProcInfoById(id);
    }

    /**
     * 查询赛事过程关系列表
     *
     * @param mrtonProcInfo 赛事过程关系信息
     * @return 赛事过程关系集合
     */
    @Override
    public List<MrtonProcInfo> selectMrtonProcInfoList(MrtonProcInfo mrtonProcInfo) {
        return mrtonProcInfoMapper.selectMrtonProcInfoList(mrtonProcInfo);
    }

    /**
     * 新增赛事过程关系
     *
     * @param mrtonProcInfo 赛事过程关系信息
     * @return 结果
     */
    @Override
    public int insertMrtonProcInfo(MrtonProcInfo mrtonProcInfo) {
        return mrtonProcInfoMapper.insertMrtonProcInfo(mrtonProcInfo);
    }

    /**
     * 修改赛事过程关系
     *
     * @param mrtonProcInfo 赛事过程关系信息
     * @return 结果
     */
    @Override
    public int updateMrtonProcInfo(MrtonProcInfo mrtonProcInfo) {
        return mrtonProcInfoMapper.updateMrtonProcInfo(mrtonProcInfo);
    }

    /**
     * 删除赛事过程关系对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonProcInfoByIds(String ids) {
        return mrtonProcInfoMapper.deleteMrtonProcInfoByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<MrtonProcInfoVO> selectMrtonProcs(String marathonId) {
        return mrtProcInfoCustomizeMapper.selectMrtProcs(marathonId);
    }

    @Override
    public List<MarathonInfo> selectMyMrton(SysUser user, MrtonProcEnum mrtonProcEnum) {
        return mrtProcInfoCustomizeMapper.selectMyMrton(user.getUserId(),mrtonProcEnum.getName());
    }

    @Override
    public List<MyMrtonProcVO> selectMyMrtonProc(SysUser user, MrtonProcEnum mrtonProcEnum, String marathonId) {
        //TODO 根据用户职位数据过滤？
        List<MyMrtonProcVO> lstResult= mrtProcInfoCustomizeMapper.selectMyMrtonProc(user.getUserId(),mrtonProcEnum.getName(),marathonId) ;

        lstResult.forEach(myMrtonProcVO -> {
            if(myMrtonProcVO.getStatus()!=null){
                myMrtonProcVO.setStatusStr(MrtonProcStatusEnum.getObject(myMrtonProcVO.getStatus()).getValue());
            }
            //是否延期判断
            if(myMrtonProcVO.getStatus().equals(MrtonProcStatusEnum.STATUS_NEW.getKey())){
                if(!Strings.isNullOrEmpty(myMrtonProcVO.getPlanStarttime())){
                    LocalDate planStartime=LocalDate.parse(myMrtonProcVO.getPlanStarttime(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    myMrtonProcVO.getParams().put("isDelay", LocalDate.now().isAfter(planStartime));
                }
            }else if(myMrtonProcVO.getStatus().equals(MrtonProcStatusEnum.STATUS_RUNNING.getKey())){
                if(!Strings.isNullOrEmpty(myMrtonProcVO.getPlanEndtime())){
                    LocalDate planEndtime=LocalDate.parse(myMrtonProcVO.getPlanEndtime(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    myMrtonProcVO.getParams().put("isDelay",LocalDate.now().isAfter(planEndtime));
                }
            }
        });

        return lstResult;
    }

    /**
     * 将赛事-过程 菜单加上
     * @param sysUser
     * @param menus
     */
    @Override
    public void buildMrtonMenu(SysUser sysUser, List<SysMenu> menus) {

        List<MrthonMenuBean> lstMrtonMenu=mrtProcInfoCustomizeMapper.getMrtonMenu(sysUser.getUserId());

        for(SysMenu menu:menus){
            if(menu.getChildren().size()>0){
                Iterator<SysMenu> iterator=menu.getChildren().iterator();
                while (iterator.hasNext()){
                    SysMenu child=iterator.next();
                    String menuName=child.getMenuName();
                    MrthonMenuEnum mrthonMenu=MrthonMenuEnum.getValue(menuName);
                    if(mrthonMenu!=null){
                        if(lstMrtonMenu.size()<=0){
                            iterator.remove();
                        }else{
                            for(MrthonMenuBean mrthonMenuBean:lstMrtonMenu){
                                if(mrthonMenuBean.getProcName().equals(menuName)){
                                    SysMenu sysMenu=new SysMenu();
                                    sysMenu.setParentId(child.getMenuId());
                                    sysMenu.setUrl(String.format(mrthonMenu.getUrl(),mrthonMenuBean.getMarathonId()));
                                    sysMenu.setMenuName(mrthonMenuBean.getMrtonName());
                                    sysMenu.setMenuType("C");
                                    sysMenu.setTarget("menuItem");
                                    child.getChildren().add(sysMenu);
                                }
                            }

                            if(child.getChildren().size() == 0){
                                iterator.remove();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void addOrEditSave(MrtonProcInfo mrtonProcInfo) {
        String startTime = (String) mrtonProcInfo.getParams().get("planStarttime");
        try {
            if (!Strings.isNullOrEmpty(startTime)) {
                mrtonProcInfo.setPlanStarttime(new SimpleDateFormat("yyyy-MM-dd").parse(startTime));
            }

            String endTime = (String) mrtonProcInfo.getParams().get("planEndtime");
            if (!Strings.isNullOrEmpty(endTime)) {
                mrtonProcInfo.setPlanEndtime(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
            }
        } catch (ParseException e) {
            log.error("时间格式转换失败！",e);
        }

        if(Strings.isNullOrEmpty(mrtonProcInfo.getId())){
            mrtonProcInfo.setId(UUID.randomUUID().toString());
            mrtonProcInfo.setCustomize(1);
            mrtonProcInfo.setStatus(MrtonProcStatusEnum.STATUS_NEW.getKey());
            this.insertMrtonProcInfo(mrtonProcInfo);
        }else{
            this.updateMrtonProcInfo(mrtonProcInfo);
        }
    }

    @Override
    public MrtonProcCommonQVO queryMrtonInfoById(String mrtonprocId) {
        MrtonProcCommonQVO mrtonProcInfo= mrtProcInfoCustomizeMapper.queryMrtonInfoById(mrtonprocId);
        if(mrtonProcInfo!=null){
            if (mrtonProcInfo.getPlanStarttime() != null) {
                mrtonProcInfo.getParams().put("planStarttime", new SimpleDateFormat("yyyy-MM-dd").format(mrtonProcInfo.getPlanStarttime()));
            }
            if (mrtonProcInfo.getPlanEndtime() != null) {
                mrtonProcInfo.getParams().put("planEndtime", new SimpleDateFormat("yyyy-MM-dd").format(mrtonProcInfo.getPlanEndtime()));
            }
            if(mrtonProcInfo.getCustomize()!=1){
                MrtonProcCfgResourceExample example = new MrtonProcCfgResourceExample();
                example.or().andCfgProcIdEqualTo(mrtonProcInfo.getProcCfgId());
                List<MrtonProcCfgResource> lstResource = mrtonProcCfgResourceMapper.selectByExample(example);
                mrtonProcInfo.setLstResource(lstResource);
            }
        }
        return mrtonProcInfo;
    }
}
