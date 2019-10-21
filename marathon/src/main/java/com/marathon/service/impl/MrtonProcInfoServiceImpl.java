package com.marathon.service.impl;

import java.util.Iterator;
import java.util.List;

import cn.hutool.core.convert.Convert;
import com.google.common.collect.Lists;
import com.marathon.MrthonMenuEnum;
import com.marathon.MrtonConstants;
import com.marathon.MrtonProcEnum;
import com.marathon.MrtonProcStatusEnum;
import com.marathon.domain.MarathonInfo;
import com.marathon.domain.MrtonProcCfg;
import com.marathon.mapper.customize.MrtProcInfoCustomizeMapper;
import com.marathon.qvo.MrthonMenuBean;
import com.marathon.qvo.MrtonProcInfoVO;
import com.marathon.qvo.MyMrtonProcVO;
import com.marathon.service.IMrtonProcCfgService;
import com.ruoyi.common.utils.DateUtil;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
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
@Service
public class MrtonProcInfoServiceImpl implements IMrtonProcInfoService {
    @Autowired
    private MrtonProcInfoMapper mrtonProcInfoMapper;

    @Autowired
    private MrtProcInfoCustomizeMapper mrtProcInfoCustomizeMapper;

    @Autowired
    private IMrtonProcCfgService mrtonProcCfgService;

    @Autowired
    private ISysUserService userService;

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
        MrtonProcCfg cfg = new MrtonProcCfg();
        cfg.setParentProcId(MrtonConstants.DEFAULT_PROC_TOP);
        List<MrtonProcCfg> lstParent = mrtonProcCfgService.selectMrtonProcCfgList(cfg);

        List<MrtonProcInfoVO> result = Lists.newArrayList();
        for (MrtonProcCfg parentCfg : lstParent) {
            MrtonProcInfoVO parent = new MrtonProcInfoVO();
            parent.setMrtonProcId(parentCfg.getProcId());
            parent.setProcId(parentCfg.getProcId());
            parent.setProcSeq(parentCfg.getProcSeq());
            parent.setProcName(parentCfg.getProcName());

            result.add(parent);

//            List<MrtonProcInfoVO> lstChild = mrtProcInfoCustomizeMapper.selectMrtProcs(parentCfg.getProcId(), marathonId);
//
//            lstChild.forEach(child -> {
//                child.getParams().put("planStarttimeStr", DateUtil.formatDateTime(child.getPlanStarttime()));
//               child.getParams().put("planEndtimeStr",DateUtil.formatDateTime(child.getPlanEndtime()));
//            });
//            result.addAll(lstChild);
        }
        return result;
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
                        }
                    }
                }
            }
        }
    }

    /**
     * 删除空的目录
     * @param menu
     * @param child
     */
    private void delEmptyMenu(SysMenu menu, SysMenu child) {
        Iterator<SysMenu> iterator=menu.getChildren().iterator();
        while (iterator.hasNext()){
            SysMenu sysMenu=iterator.next();
            if(sysMenu.equals(child)){
                iterator.remove();
            }
        }
    }
}
