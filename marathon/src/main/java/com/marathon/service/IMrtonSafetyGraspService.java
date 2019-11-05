package com.marathon.service;

import com.marathon.domain.MrtonSafetyGrasp;
import java.util.List;

/**
 * 安保-了解赛事，确定赛事规模 服务层
 *
 * @author cuigq
 * @date 2019-10-29
 */
public interface IMrtonSafetyGraspService {
    /**
     * 查询安保-了解赛事，确定赛事规模信息
     *
     * @param id 安保-了解赛事，确定赛事规模ID
     * @return 安保-了解赛事，确定赛事规模信息
     */
    public MrtonSafetyGrasp selectMrtonSafetyGraspById(Integer id);

    /**
     * 查询安保-了解赛事，确定赛事规模列表
     *
     * @param mrtonSafetyGrasp 安保-了解赛事，确定赛事规模信息
     * @return 安保-了解赛事，确定赛事规模集合
     */
    public List<MrtonSafetyGrasp> selectMrtonSafetyGraspList(MrtonSafetyGrasp mrtonSafetyGrasp);

    /**
     * 新增安保-了解赛事，确定赛事规模
     *
     * @param mrtonSafetyGrasp 安保-了解赛事，确定赛事规模信息
     * @return 结果
     */
    public int insertMrtonSafetyGrasp(MrtonSafetyGrasp mrtonSafetyGrasp);

    /**
     * 修改安保-了解赛事，确定赛事规模
     *
     * @param mrtonSafetyGrasp 安保-了解赛事，确定赛事规模信息
     * @return 结果
     */
    public int updateMrtonSafetyGrasp(MrtonSafetyGrasp mrtonSafetyGrasp);

    /**
     * 删除安保-了解赛事，确定赛事规模信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonSafetyGraspByIds(String ids);

    MrtonSafetyGrasp getGraspByProcId(String martonId,String mrtonprocId);
}
