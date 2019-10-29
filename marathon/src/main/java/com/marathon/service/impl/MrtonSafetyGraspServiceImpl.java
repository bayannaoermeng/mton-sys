package com.marathon.service.impl;

import java.util.List;

import cn.hutool.core.convert.Convert;
import com.marathon.mapper.customize.MrtonSafetyGraspCustomizeMapper;
import com.marathon.qvo.MrtonSafeGraspVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.mapper.MrtonSafetyGraspMapper;
import com.marathon.domain.MrtonSafetyGrasp;
import com.marathon.service.IMrtonSafetyGraspService;

/**
 * 安保-了解赛事，确定赛事规模 服务层实现
 *
 * @author cuigq
 * @date 2019-10-29
 */
@Service
public class MrtonSafetyGraspServiceImpl implements IMrtonSafetyGraspService {
    @Autowired
    private MrtonSafetyGraspMapper mrtonSafetyGraspMapper;

    @Autowired
    private MrtonSafetyGraspCustomizeMapper mrtonSafetyGraspCustomizeMapper;


    /**
     * 查询安保-了解赛事，确定赛事规模信息
     *
     * @param id 安保-了解赛事，确定赛事规模ID
     * @return 安保-了解赛事，确定赛事规模信息
     */
    @Override
    public MrtonSafetyGrasp selectMrtonSafetyGraspById(Integer id) {
        return mrtonSafetyGraspMapper.selectMrtonSafetyGraspById(id);
    }

    /**
     * 查询安保-了解赛事，确定赛事规模列表
     *
     * @param mrtonSafetyGrasp 安保-了解赛事，确定赛事规模信息
     * @return 安保-了解赛事，确定赛事规模集合
     */
    @Override
    public List<MrtonSafetyGrasp> selectMrtonSafetyGraspList(MrtonSafetyGrasp mrtonSafetyGrasp) {
        return mrtonSafetyGraspMapper.selectMrtonSafetyGraspList(mrtonSafetyGrasp);
    }

    /**
     * 新增安保-了解赛事，确定赛事规模
     *
     * @param mrtonSafetyGrasp 安保-了解赛事，确定赛事规模信息
     * @return 结果
     */
    @Override
    public int insertMrtonSafetyGrasp(MrtonSafetyGrasp mrtonSafetyGrasp) {
        return mrtonSafetyGraspMapper.insertMrtonSafetyGrasp(mrtonSafetyGrasp);
    }

    /**
     * 修改安保-了解赛事，确定赛事规模
     *
     * @param mrtonSafetyGrasp 安保-了解赛事，确定赛事规模信息
     * @return 结果
     */
    @Override
    public int updateMrtonSafetyGrasp(MrtonSafetyGrasp mrtonSafetyGrasp) {
        return mrtonSafetyGraspMapper.updateMrtonSafetyGrasp(mrtonSafetyGrasp);
    }

    /**
     * 删除安保-了解赛事，确定赛事规模对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonSafetyGraspByIds(String ids) {
        return mrtonSafetyGraspMapper.deleteMrtonSafetyGraspByIds(Convert.toStrArray(ids));
    }

    @Override
    public MrtonSafeGraspVO getGraspByProcId(String mrtonprocId) {
        return mrtonSafetyGraspCustomizeMapper.getGraspByProcId(mrtonprocId);
    }
}