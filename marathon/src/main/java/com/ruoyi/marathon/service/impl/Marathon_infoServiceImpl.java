package com.ruoyi.marathon.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import cn.hutool.core.convert.Convert;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.ruoyi.marathon.domain.Marathon_info;
import com.ruoyi.marathon.domain.Marathon_user;
import com.ruoyi.marathon.mapper.Marathon_infoMapper;
import com.ruoyi.marathon.mapper.Marathon_userMapper;
import com.ruoyi.marathon.service.IMarathon_infoService;
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
public class Marathon_infoServiceImpl implements IMarathon_infoService {
    @Autowired
    private Marathon_infoMapper marathon_infoMapper;

    @Autowired
    private Marathon_userMapper marathon_userMapper;

    /**
     * 查询赛事信息
     *
     * @param marathon_uuid 赛事ID
     * @return 赛事信息
     */
    @Override
    public Marathon_info selectMarathon_infoById(String marathon_uuid) {
        Marathon_info marathonInfo = marathon_infoMapper.selectMarathon_infoById(marathon_uuid);
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
    public List<Marathon_info> selectMarathon_infoList(Marathon_info marathon_info) {
        return marathon_infoMapper.selectMarathon_infoList(marathon_info);
    }

    /**
     * 新增赛事
     *
     * @param marathon_info 赛事信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertMarathon_info(Marathon_info marathon_info) {
        if (Strings.isNullOrEmpty(marathon_info.getMarathon_uuid())) {
            marathon_info.setMarathon_uuid(UUID.randomUUID().toString());
        }

        rebuildTimeProperty(marathon_info);
        //插入赛事信息表
        marathon_infoMapper.insertMarathon_info(marathon_info);

        //赛事人员分配
        addMarathonUsers(marathon_info);

        return 1;
    }

    private void addMarathonUsers(Marathon_info marathon_info) {
        String strUserIds = (String) marathon_info.getParams().get("userIds");
        String[] arrayUserIds = Convert.toStrArray(strUserIds);
        if (arrayUserIds != null && arrayUserIds.length > 0) {
            List<String> lstUserId = Arrays.asList(arrayUserIds);
            lstUserId.forEach(userId -> {
                Marathon_user marathonUser = new Marathon_user();
                marathonUser.setId(UUID.randomUUID().toString());
                marathonUser.setMarathon_id(marathon_info.getMarathon_uuid());
                marathonUser.setUser_id(Integer.valueOf(userId));
                marathon_userMapper.insertMarathon_user(marathonUser);
            });
        }
    }

    private void rebuildTimeProperty(Marathon_info marathon_info) {
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
    public int updateMarathon_info(Marathon_info marathon_info) {
        rebuildTimeProperty(marathon_info);
        marathon_infoMapper.updateMarathon_info(marathon_info);

        marathon_userMapper.deleteByMarathonId(marathon_info.getMarathon_uuid());
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
        marathon_infoMapper.deleteMarathon_infoByIds(Convert.toStrArray(ids));
        //删除相关人员
        marathon_userMapper.deleteByMarathonIds(Convert.toStrArray(ids));
        return Integer.MAX_VALUE;
    }

}
