package com.marathon.service.materialdemand.impl;

import cn.hutool.core.convert.Convert;
import com.marathon.domain.MrtonClothesDemand;
import com.marathon.domain.MrtonClothesDemandExample;
import com.marathon.mapper.MrtonClothesDemandMapper;
import com.marathon.service.materialdemand.IMrtonClothesDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 服装需求 服务层实现
 *
 * @author cuigq
 * @date 2020-06-23
 */
@Service
public class MrtonClothesDemandServiceImpl implements IMrtonClothesDemandService {
    @Autowired
    private MrtonClothesDemandMapper mrtonClothesDemandMapper;

    /**
     * 查询服装需求信息
     *
     * @param id 服装需求ID
     * @return 服装需求信息
     */
    @Override
    public MrtonClothesDemand selectMrtonClothesDemandById(Integer id) {
        return mrtonClothesDemandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询服装需求列表
     *
     * @param mrtonClothesDemand 服装需求信息
     * @return 服装需求集合
     */
    @Override
    public List<MrtonClothesDemand> selectMrtonClothesDemandList(MrtonClothesDemand mrtonClothesDemand) {
        MrtonClothesDemandExample example = new MrtonClothesDemandExample();
        example.or().andProcIdEqualTo(mrtonClothesDemand.getProcId());
        return mrtonClothesDemandMapper.selectByExample(example);
    }

    /**
     * 新增服装需求
     *
     * @param mrtonClothesDemand 服装需求信息
     * @return 结果
     */
    @Override
    public int insertMrtonClothesDemand(MrtonClothesDemand mrtonClothesDemand) {
        mrtonClothesDemandMapper.insertSelective(mrtonClothesDemand);
        return 1;
    }

    /**
     * 修改服装需求
     *
     * @param mrtonClothesDemand 服装需求信息
     * @return 结果
     */
    @Override
    public int updateMrtonClothesDemand(MrtonClothesDemand mrtonClothesDemand) {

        return mrtonClothesDemandMapper.updateByPrimaryKeySelective(mrtonClothesDemand);
    }

    /**
     * 删除服装需求对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonClothesDemandByIds(String ids) {
        Integer[] arrayId = Convert.toIntArray(ids);
        MrtonClothesDemandExample example = new MrtonClothesDemandExample();
        example.or().andIdIn(Arrays.asList(arrayId));
        return mrtonClothesDemandMapper.deleteByExample(example);
    }

}
