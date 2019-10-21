package com.marathon.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.hutool.core.convert.Convert;
import com.google.common.base.Strings;
import com.marathon.MrtonConstants;
import com.marathon.domain.MrtonProcCfg;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.mapper.MarathonInfoMapper;
import com.marathon.domain.MarathonInfo;
import com.marathon.domain.MarathonUser;
import com.marathon.mapper.MarathonUserMapper;
import com.marathon.service.IMarathonInfoService;
import com.marathon.service.IMrtonProcCfgService;
import com.marathon.service.IMrtonProcInfoService;
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

        MrtonProcCfg cfg = new MrtonProcCfg();
        cfg.setParentProcId(MrtonConstants.DEFAULT_PROC_TOP);
        List<MrtonProcCfg> lstParent = mrtonProcCfgService.selectMrtonProcCfgList(cfg);

        lstParent.forEach(config -> {

            String uuid = config.getProcId();

            MrtonProcCfg cfgExmple = new MrtonProcCfg();
            cfgExmple.setParentProcId(uuid);
            List<MrtonProcCfg> lstChildren = mrtonProcCfgService.selectMrtonProcCfgList(cfgExmple);

            for (MrtonProcCfg mrtonProcCfg : lstChildren) {
                MrtonProcInfo info = new MrtonProcInfo();
                info.setMarathonId(marathon_info.getMarathon_uuid());
                info.setParentProcId(config.getProcId());
                info.setProcId(mrtonProcCfg.getProcId());
                info.setId(UUID.randomUUID().toString());

                calcPlanTime(mrtonProcCfg, info, marathon_info.getMarathon_starttime());

                mrtonProcInfoService.insertMrtonProcInfo(info);
            }

        });
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
