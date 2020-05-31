package com.marathon.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.core.convert.Convert;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.marathon.MrthonMenuEnum;
import com.marathon.MrtonConstants;
import com.marathon.MrtonProcEnum;
import com.marathon.MrtonProcStatusEnum;
import com.marathon.domain.*;
import com.marathon.mapper.MrtonProcCfgResourceMapper;
import com.marathon.mapper.MrtonResourceMapper;
import com.marathon.mapper.customize.MrtProcInfoCustomizeMapper;
import com.marathon.qvo.MrthonMenuBean;
import com.marathon.qvo.MrtonProcCommonQVO;
import com.marathon.qvo.MrtonProcInfoVO;
import com.marathon.qvo.MyMrtonProcVO;
import com.marathon.service.IOfficeToolService;
import com.marathon.service.IReferOfficeService;
import com.mton.system.domain.SysMenu;
import com.mton.system.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.mapper.MrtonProcInfoMapper;
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

    @Autowired
    private MrtonResourceMapper mrtonResourceMapper;

    @Autowired
    private IOfficeToolService officeToolService;

    @Autowired
    private IReferOfficeService referOfficeService;

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
        return mrtProcInfoCustomizeMapper.selectMyMrton(user.getUserId(), mrtonProcEnum.getName());
    }

    @Override
    public List<MyMrtonProcVO> selectMyMrtonProc(SysUser user, MrtonProcEnum mrtonProcEnum, String marathonId) {
        //TODO 根据用户职位数据过滤？
        List<MyMrtonProcVO> lstResult = mrtProcInfoCustomizeMapper.selectMyMrtonProc(user.getUserId(), mrtonProcEnum.getName(), marathonId);

        lstResult.forEach(myMrtonProcVO -> {
            if (myMrtonProcVO.getStatus() != null) {
                myMrtonProcVO.setStatusStr(MrtonProcStatusEnum.getObject(myMrtonProcVO.getStatus()).getValue());
            }
            //是否延期判断
            if (myMrtonProcVO.getStatus().equals(MrtonProcStatusEnum.STATUS_NEW.getKey())) {
                if (!Strings.isNullOrEmpty(myMrtonProcVO.getPlanStarttime())) {
                    LocalDate planStartime = LocalDate.parse(myMrtonProcVO.getPlanStarttime(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    myMrtonProcVO.getParams().put("isDelay", LocalDate.now().isAfter(planStartime));
                }
            } else if (myMrtonProcVO.getStatus().equals(MrtonProcStatusEnum.STATUS_RUNNING.getKey())) {
                if (!Strings.isNullOrEmpty(myMrtonProcVO.getPlanEndtime())) {
                    LocalDate planEndtime = LocalDate.parse(myMrtonProcVO.getPlanEndtime(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    myMrtonProcVO.getParams().put("isDelay", LocalDate.now().isAfter(planEndtime));
                }
            }
        });

        return lstResult;
    }

    /**
     * 赛事执行角色菜单规则
     * 年份
     *  赛事名称
     *      模块名称
     * @param sysUser
     * @param menus
     */
    @Override
    public void buildMrtonMenu(SysUser sysUser, List<SysMenu> menus) {
        Iterator<SysMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            SysMenu menu = iterator.next();
            if ("竞赛".equals(menu.getMenuName())) {
                iterator.remove();
            }
        }

        List<MrthonMenuBean> lstMrtonMenu = mrtProcInfoCustomizeMapper.getMrtonMenu(sysUser.getUserId());

        //按年份分组
        Map<Long, List<MrthonMenuBean>> mapGroupbyYear = lstMrtonMenu.stream().collect(Collectors.groupingBy(MrthonMenuBean::getStarttime));

        mapGroupbyYear.forEach((key, value) -> {
            SysMenu yearMenu = new SysMenu();
            yearMenu.setMenuName(key.toString());
            yearMenu.setMenuType("M");

            //按赛事分组
            Map<String, List<MrthonMenuBean>> mapGroupbyMrtonName = value.stream().collect(Collectors.groupingBy(MrthonMenuBean::getMrtonName));
            mapGroupbyMrtonName.forEach((mrtonName, lstValue) -> {
                SysMenu mrtonMenu = new SysMenu();
                mrtonMenu.setMenuType("M");
                mrtonMenu.setMenuName(mrtonName);

                for (MrthonMenuBean bean : lstValue) {
                    SysMenu procMenu = new SysMenu();
                    procMenu.setMenuName(bean.getProcName());
                    procMenu.setMenuType("C");
                    procMenu.setTarget("menuItem");
                    MrthonMenuEnum mrthonMenu = MrthonMenuEnum.getValue(bean.getProcName());
                    procMenu.setUrl(String.format(mrthonMenu.getUrl(), bean.getMarathonId()));
                    mrtonMenu.getChildren().add(procMenu);
                }
                yearMenu.getChildren().add(mrtonMenu);
            });
            menus.add(yearMenu);
        });

//        for(SysMenu menu:menus){
//            if(menu.getChildren().size()>0){
//                Iterator<SysMenu> iterator=menu.getChildren().iterator();
//                while (iterator.hasNext()){
//                    SysMenu child=iterator.next();
//                    String menuName=child.getMenuName();
//                    MrthonMenuEnum mrthonMenu=MrthonMenuEnum.getValue(menuName);
//                    if(mrthonMenu!=null){
//                        if(lstMrtonMenu.size()<=0){
//                            iterator.remove();
//                        }else{
//                            for(MrthonMenuBean mrthonMenuBean:lstMrtonMenu){
//                                if(mrthonMenuBean.getProcName().equals(menuName)){
//                                    SysMenu sysMenu=new SysMenu();
//                                    sysMenu.setParentId(child.getMenuId());
//                                    sysMenu.setUrl(String.format(mrthonMenu.getUrl(),mrthonMenuBean.getMarathonId()));
//                                    sysMenu.setMenuName(mrthonMenuBean.getMrtonName());
//                                    sysMenu.setMenuType("C");
//                                    sysMenu.setTarget("menuItem");
//                                    child.getChildren().add(sysMenu);
//                                }
//                            }
//
//                            if(child.getChildren().size() == 0){
//                                iterator.remove();
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }

    @Override
    public void addOrEditSave(MrtonProcCommonQVO mrtonProcInfo) {
        String startTime = mrtonProcInfo.getPlanStarttimeStr();
        try {
            if (!Strings.isNullOrEmpty(startTime)) {
                mrtonProcInfo.setPlanStarttime(new SimpleDateFormat("yyyy-MM-dd").parse(startTime));
            }

            String endTime = mrtonProcInfo.getPlanEndtimeStr();
            if (!Strings.isNullOrEmpty(endTime)) {
                mrtonProcInfo.setPlanEndtime(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
            }
        } catch (ParseException e) {
            log.error("时间格式转换失败！", e);
        }

        if (Strings.isNullOrEmpty(mrtonProcInfo.getId())) {
            mrtonProcInfo.setId(UUID.randomUUID().toString());
            mrtonProcInfo.setCustomize(1);
            //TODO　新加自定义任务
        } else {
            MrtonProcInfo mrtonProcInfo1 = new MrtonProcInfo();
            BeanUtils.copyProperties(mrtonProcInfo, mrtonProcInfo1);
            this.updateMrtonProcInfo(mrtonProcInfo1);

            if (mrtonProcInfo.getLstResource() != null && mrtonProcInfo.getLstResource().size() > 0) {
                for (MrtonProcCfgResource resource : mrtonProcInfo.getLstResource()) {

                    MrtonResource mrtonResource = new MrtonResource();
                    mrtonResource.setId(resource.getId());
                    mrtonResource.setProcId(mrtonProcInfo.getId());

                    mrtonResourceMapper.updateMrtonResource(mrtonResource);

                }
            }
        }
    }

    @Override
    public MrtonProcCommonQVO queryMrtonInfoById(String mrtonprocId, Long userId) {
        MrtonProcCommonQVO mrtonProcInfo = mrtProcInfoCustomizeMapper.queryMrtonInfoById(mrtonprocId);
        if (mrtonProcInfo != null) {
            if (mrtonProcInfo.getPlanStarttime() != null) {
                mrtonProcInfo.getParams().put("planStarttime", new SimpleDateFormat("yyyy-MM-dd").format(mrtonProcInfo.getPlanStarttime()));
            }
            if (mrtonProcInfo.getPlanEndtime() != null) {
                mrtonProcInfo.getParams().put("planEndtime", new SimpleDateFormat("yyyy-MM-dd").format(mrtonProcInfo.getPlanEndtime()));
            }
            if (mrtonProcInfo.getCustomize() != 1) {
                MrtonProcCfgResourceExample example = new MrtonProcCfgResourceExample();
                example.or().andCfgProcIdEqualTo(mrtonProcInfo.getProcCfgId());
                List<MrtonProcCfgResource> lstResource = mrtonProcCfgResourceMapper.selectByExample(example);
                mrtonProcInfo.setLstResource(lstResource);
            }

            if (mrtonProcInfo.getCustomize() != 1) {
                //获取参考文件url列表
                MrtonProcCfgResourceExample example = new MrtonProcCfgResourceExample();
                example.or().andCfgProcIdEqualTo(mrtonProcInfo.getProcCfgId());
                List<MrtonProcCfgResource> lstResource = mrtonProcCfgResourceMapper.selectByExample(example);

                List<String> lstUrl = Lists.newArrayList();
                for (MrtonProcCfgResource resource : lstResource) {
                    lstUrl.add(referOfficeService.getLink(String.valueOf(resource.getId()), userId.intValue(), MrtonConstants.OFFICE_PREVIEW_KEY));
                }

                mrtonProcInfo.setLstReferOfficeUrl(lstUrl);
            }

            //获取待完善的office文件url列表
            MrtonResource mrtonResource = new MrtonResource();
            mrtonResource.setProcId(mrtonprocId);
            List<MrtonResource> lstMrtonResouce = mrtonResourceMapper.selectMrtonResourceList(mrtonResource);
            List<String> lstUrl = Lists.newArrayList();
            for (MrtonResource resource : lstMrtonResouce) {

                lstUrl.add(officeToolService.getLink(String.valueOf(resource.getId()), userId.intValue(), MrtonConstants.OFFICE_EDIT_KEY));

            }
            mrtonProcInfo.setLstOfficeUrl(lstUrl);
        }
        return mrtonProcInfo;
    }
}
