package com.marathon.service.materialdemand.impl;

import java.util.List;

import com.marathon.service.materialdemand.IMrtonFoodDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.mapper.MrtonFoodDemandMapper;
import com.marathon.domain.MrtonFoodDemand;

/**
 * 餐饮需求 服务层实现
 *
 * @author cuigq
 * @date 2020-06-23
 */
@Service
public class MrtonFoodDemandServiceImpl implements IMrtonFoodDemandService {
    @Autowired
    private MrtonFoodDemandMapper mrtonFoodDemandMapper;

    /**
     * 查询餐饮需求信息
     *
     * @param id 餐饮需求ID
     * @return 餐饮需求信息
     */
    @Override
    public MrtonFoodDemand selectMrtonFoodDemandById(Integer id) {
        return null;
    }

    /**
     * 查询餐饮需求列表
     *
     * @param mrtonFoodDemand 餐饮需求信息
     * @return 餐饮需求集合
     */
    @Override
    public List<MrtonFoodDemand> selectMrtonFoodDemandList(MrtonFoodDemand mrtonFoodDemand) {
        return null;
    }

    /**
     * 新增餐饮需求
     *
     * @param mrtonFoodDemand 餐饮需求信息
     * @return 结果
     */
    @Override
    public int insertMrtonFoodDemand(MrtonFoodDemand mrtonFoodDemand) {
        return 0;
    }

    /**
     * 修改餐饮需求
     *
     * @param mrtonFoodDemand 餐饮需求信息
     * @return 结果
     */
    @Override
    public int updateMrtonFoodDemand(MrtonFoodDemand mrtonFoodDemand) {
        return 1;
    }

    /**
     * 删除餐饮需求对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonFoodDemandByIds(String ids) {
        return 1;
    }

}
