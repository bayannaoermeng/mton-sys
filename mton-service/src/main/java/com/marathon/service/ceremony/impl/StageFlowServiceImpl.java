package com.marathon.service.ceremony.impl;

import cn.hutool.core.convert.Convert;
import com.marathon.domain.MrtonStageFlow;
import com.marathon.domain.MrtonStageFlowExample;
import com.marathon.mapper.MrtonStageFlowMapper;
import com.marathon.service.ceremony.IStageFlowService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;

/**
 * 主舞台流程 服务层实现
 *
 * @author cuigq
 * @date 2020-05-24
 */
@Service
@Slf4j
public class StageFlowServiceImpl implements IStageFlowService {
    @Autowired
    private MrtonStageFlowMapper mrtonStageFlowMapper;

    /**
     * 查询主舞台流程信息
     *
     * @param id 主舞台流程ID
     * @return 主舞台流程信息
     */
    @Override
    public MrtonStageFlow selectMrtonStageFlowById(Integer id) {
        return mrtonStageFlowMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询主舞台流程列表
     *
     * @param mrtonStageFlow 主舞台流程信息
     * @return 主舞台流程集合
     */
    @Override
    public List<MrtonStageFlow> selectMrtonStageFlowList(MrtonStageFlow mrtonStageFlow) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        MrtonStageFlowExample example = new MrtonStageFlowExample();
        example.or().andProcIdEqualTo(mrtonStageFlow.getProcId()).andDelFlagEqualTo(0);
        List<MrtonStageFlow> lstStageFlow = mrtonStageFlowMapper.selectByExample(example);
        try {
            for (MrtonStageFlow stageFlow : lstStageFlow) {
                if (stageFlow.getStartTime() != null && stageFlow.getEndTime() != null) {
                    LocalTime startTime = LocalTime.parse(sdf.format(sdf.parse(stageFlow.getStartTime())));
                    LocalTime endTime = LocalTime.parse(sdf.format(sdf.parse(stageFlow.getEndTime())));
                    Duration duration = Duration.between(startTime, endTime);
                    stageFlow.setDuration(DurationFormatUtils.formatDuration(duration.toMillis(),"H:mm:ss",true));
                }
            }
        } catch (ParseException e) {
            log.error("时间格式转换出错，"+e.getMessage(),e);
        }
        return lstStageFlow;
    }

    /**
     * 新增主舞台流程
     *
     * @param mrtonStageFlow 主舞台流程信息
     * @return 结果
     */
    @Override
    public int insertMrtonStageFlow(MrtonStageFlow mrtonStageFlow) {
        return mrtonStageFlowMapper.insertSelective(mrtonStageFlow);
    }

    /**
     * 修改主舞台流程
     *
     * @param mrtonStageFlow 主舞台流程信息
     * @return 结果
     */
    @Override
    public int updateMrtonStageFlow(MrtonStageFlow mrtonStageFlow) {
        return mrtonStageFlowMapper.updateByPrimaryKeySelective(mrtonStageFlow);
    }

    /**
     * 删除主舞台流程对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonStageFlowByIds(String ids) {
        Integer[] arrayId = Convert.toIntArray(ids);
        MrtonStageFlowExample example = new MrtonStageFlowExample();
        example.or().andIdIn(Arrays.asList(arrayId));
        return mrtonStageFlowMapper.deleteByExample(example);
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String start = "3:4:5";
        String end = "4:5:6";

        LocalTime startTime = LocalTime.parse(sdf.format(sdf.parse(start)));
        LocalTime endTime = LocalTime.parse(sdf.format(sdf.parse(end)));

        System.out.println(DurationFormatUtils.formatDuration(Duration.between(startTime,endTime).toMillis(),"HH:mm:ss",true));
    }
}
