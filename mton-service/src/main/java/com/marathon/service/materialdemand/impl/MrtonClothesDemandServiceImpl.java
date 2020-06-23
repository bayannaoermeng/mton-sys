package com.marathon.service.materialdemand.impl;

import java.util.List;

import com.marathon.service.materialdemand.IMrtonClothesDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.mapper.MrtonClothesDemandMapper;
import com.marathon.domain.MrtonClothesDemand;

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
        return null;
    }

    /**
     * 查询服装需求列表
     *
     * @param mrtonClothesDemand 服装需求信息
     * @return 服装需求集合
     */
    @Override
    public List<MrtonClothesDemand> selectMrtonClothesDemandList(MrtonClothesDemand mrtonClothesDemand) {
        return null;
    }

    /**
     * 新增服装需求
     *
     * @param mrtonClothesDemand 服装需求信息
     * @return 结果
     */
    @Override
    public int insertMrtonClothesDemand(MrtonClothesDemand mrtonClothesDemand) {
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
        return 1;
    }

    /**
     * 删除服装需求对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonClothesDemandByIds(String ids) {
        return 1;
    }

}
