package com.marathon.service.ceremony.impl;

import java.util.Arrays;
import java.util.List;

import cn.hutool.core.convert.Convert;
import com.marathon.domain.MrtonStageFlowExample;
import com.marathon.service.ceremony.IStageFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.mapper.MrtonStageFlowMapper;
import com.marathon.domain.MrtonStageFlow;

/**
 * 主舞台流程 服务层实现
 *
 * @author cuigq
 * @date 2020-05-24
 */
@Service
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
        MrtonStageFlowExample example = new MrtonStageFlowExample();
        example.or().andProcIdEqualTo(mrtonStageFlow.getProcId()).andDelFlagEqualTo(0);
        return mrtonStageFlowMapper.selectByExample(example);
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
        return mrtonStageFlowMapper.updateByPrimaryKey(mrtonStageFlow);
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

}
