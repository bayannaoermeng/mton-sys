package com.marathon.service.ceremony;

import com.marathon.domain.MrtonStageFlow;
import java.util.List;

/**
 * 主舞台流程 服务层
 *
 * @author cuigq
 * @date 2020-05-24
 */
public interface IStageFlowService {
    /**
     * 查询主舞台流程信息
     *
     * @param id 主舞台流程ID
     * @return 主舞台流程信息
     */
    public MrtonStageFlow selectMrtonStageFlowById(Integer id);

    /**
     * 查询主舞台流程列表
     *
     * @param mrtonStageFlow 主舞台流程信息
     * @return 主舞台流程集合
     */
    public List<MrtonStageFlow> selectMrtonStageFlowList(MrtonStageFlow mrtonStageFlow);

    /**
     * 新增主舞台流程
     *
     * @param mrtonStageFlow 主舞台流程信息
     * @return 结果
     */
    public int insertMrtonStageFlow(MrtonStageFlow mrtonStageFlow);

    /**
     * 修改主舞台流程
     *
     * @param mrtonStageFlow 主舞台流程信息
     * @return 结果
     */
    public int updateMrtonStageFlow(MrtonStageFlow mrtonStageFlow);

    /**
     * 删除主舞台流程信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonStageFlowByIds(String ids);

}
