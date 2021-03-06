package com.marathon.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import cn.hutool.core.convert.Convert;
import com.google.common.base.Strings;
import com.marathon.MrtonConstants;
import com.marathon.MrtonProcEnum;
import com.marathon.domain.*;
import com.marathon.mapper.MarathonInfoMapper;
import com.marathon.mapper.MarathonUserMapper;
import com.marathon.mapper.MrtonProcCfgMapper;
import com.marathon.qvo.OrgChartDataVO;
import com.marathon.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 赛事 服务层实现
 *
 * @author null
 * @date 2019-08-17
 */
@Service
public class MarathonInfoServiceImpl implements IMarathonInfoService {
    @Autowired
    private MarathonInfoMapper marathonInfoMapper;

    @Autowired
    private MarathonUserMapper marathonUserMapper;

    @Autowired
    private IMrtonProcCfgService mrtonProcCfgService;

    @Autowired
    private IMrtonProcInfoService mrtonProcInfoService;

    @Autowired
    private MrtonProcCfgMapper mrtonProcCfgMapper;

    /**
     * 查询赛事信息
     *
     * @param marathon_uuid 赛事ID
     * @return 赛事信息
     */
    @Override
    public MarathonInfo selectMarathon_infoById(String marathon_uuid) {
        MarathonInfo marathonInfo = marathonInfoMapper.selectMarathon_infoById(marathon_uuid);
        if (marathonInfo.getMarathon_starttime() != null) {
            marathonInfo.getParams().put("startTime", new SimpleDateFormat("yyyy-MM-dd").format(marathonInfo.getMarathon_starttime()));
        }
        if (marathonInfo.getMarathon_endtime() != null) {
            marathonInfo.getParams().put("endTime", new SimpleDateFormat("yyyy-MM-dd").format(marathonInfo.getMarathon_endtime()));
        }
        return marathonInfo;
    }

    /**
     * 查询赛事列表
     *
     * @param marathon_info 赛事信息
     * @return 赛事集合
     */
    @Override
    public List<MarathonInfo> selectMarathon_infoList(MarathonInfo marathon_info) {
        return marathonInfoMapper.selectMarathon_infoList(marathon_info);
    }

    /**
     * 新增赛事
     *
     * @param marathon_info 赛事信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertMarathon_info(MarathonInfo marathon_info) {
        if (Strings.isNullOrEmpty(marathon_info.getMarathon_uuid())) {
            marathon_info.setMarathon_uuid(UUID.randomUUID().toString());
        }

        rebuildTimeProperty(marathon_info);
        //插入赛事信息表
        marathonInfoMapper.insertMarathon_info(marathon_info);

        //初始化mrton_proc_info表
        initMaratonProcInfo(marathon_info);

        //赛事人员分配
        addMarathonUsers(marathon_info);

        return 1;
    }

    private void initMaratonProcInfo(MarathonInfo marathon_info) {

        MrtonProcCfgExample cfg = new MrtonProcCfgExample();
        cfg.or().andParentProcIdIsNull();
        List<MrtonProcCfg> lstParent = mrtonProcCfgService.selectByExample(cfg);

        lstParent.forEach(config -> {

            String uuid = config.getProcId();

            recursiveTree(marathon_info.getMarathon_uuid(),uuid);

        });
    }

    public void recursiveTree(String mrtonId,String procId) {
        MrtonProcInfo procInfo = new MrtonProcInfo();
        MrtonProcCfg cfg = mrtonProcCfgMapper.selectByPrimaryKey(procId);
        procInfo.setId(UUID.randomUUID().toString());
        procInfo.setMarathonId(mrtonId);
        procInfo.setParentProcId(cfg.getParentProcId());
        procInfo.setProcId(procId);
        mrtonProcInfoService.insertMrtonProcInfo(procInfo);

        MrtonProcCfgExample example = new MrtonProcCfgExample();
        example.or().andParentProcIdEqualTo(procId);
        List<MrtonProcCfg> lstCfg = mrtonProcCfgMapper.selectByExample(example);
        for (MrtonProcCfg child : lstCfg) {
             recursiveTree(mrtonId,child.getProcId()); //递归
        }

    }

    //生成默认起终时间
    private void calcPlanTime(MrtonProcCfg mrtonProcCfg, MrtonProcInfo info, Date marathon_starttime) {

        if (marathon_starttime == null) {
            return;
        }

        if (mrtonProcCfg.getStarttimeOffset() == null || mrtonProcCfg.getEndtimeOffset() == null) {
            return;
        }
        if (mrtonProcCfg.getComparativelyToMrton() == MrtonConstants.COMPARATIVELY_TO_MRTON_BEFORE) {

            LocalDateTime ldt = LocalDateTime.ofInstant(marathon_starttime.toInstant(), ZoneId.systemDefault());
            LocalDateTime startTime=ldt.plusDays(-mrtonProcCfg.getStarttimeOffset());
            info.setPlanStarttime(Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant()));

            LocalDateTime ldtEnd = LocalDateTime.ofInstant(marathon_starttime.toInstant(), ZoneId.systemDefault());
            LocalDateTime endTime=ldtEnd.plusDays(-mrtonProcCfg.getEndtimeOffset());
            info.setPlanEndtime(Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant()));

        } else {

            LocalDateTime ldt = LocalDateTime.ofInstant(marathon_starttime.toInstant(), ZoneId.systemDefault());
            LocalDateTime startTime=ldt.plusDays(mrtonProcCfg.getStarttimeOffset());
            info.setPlanStarttime(Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant()));

            LocalDateTime ldtEnd = LocalDateTime.ofInstant(marathon_starttime.toInstant(), ZoneId.systemDefault());
            LocalDateTime endTime=ldtEnd.plusDays(mrtonProcCfg.getEndtimeOffset());
            info.setPlanStarttime(Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant()));

        }

    }

    private void addMarathonUsers(MarathonInfo marathon_info) {
        String strUserIds = (String) marathon_info.getParams().get("userIds");
        String[] arrayUserIds = Convert.toStrArray(strUserIds);
        if (arrayUserIds != null && arrayUserIds.length > 0) {
            List<String> lstUserId = Arrays.asList(arrayUserIds);
            lstUserId.forEach(userId -> {
                MarathonUser marathonUser = new MarathonUser();
                marathonUser.setId(UUID.randomUUID().toString());
                marathonUser.setMarathon_id(marathon_info.getMarathon_uuid());
                marathonUser.setUser_id(Integer.valueOf(userId));
                marathonUserMapper.insertMarathon_user(marathonUser);
            });
        }
    }

    private void rebuildTimeProperty(MarathonInfo marathon_info) {
        try {
            String startTime = (String) marathon_info.getParams().get("startTime");
            if (!Strings.isNullOrEmpty(startTime)) {
                marathon_info.setMarathon_starttime(new SimpleDateFormat("yyyy-MM-dd").parse(startTime));
            }

            String endTime = (String) marathon_info.getParams().get("endTime");
            if (!Strings.isNullOrEmpty(endTime)) {
                marathon_info.setMarathon_endtime(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 修改赛事
     *
     * @param marathon_info 赛事信息
     * @return 结果
     */
    @Override
    public int updateMarathon_info(MarathonInfo marathon_info) {
        rebuildTimeProperty(marathon_info);
        marathonInfoMapper.updateMarathon_info(marathon_info);

        marathonUserMapper.deleteByMarathonId(marathon_info.getMarathon_uuid());
        addMarathonUsers(marathon_info);
        return Integer.MAX_VALUE;
    }

    /**
     * 删除赛事对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMarathon_infoByIds(String ids) {
        marathonInfoMapper.deleteMarathon_infoByIds(Convert.toStrArray(ids));
        //删除相关人员
        marathonUserMapper.deleteByMarathonIds(Convert.toStrArray(ids));
        return Integer.MAX_VALUE;
    }

}
