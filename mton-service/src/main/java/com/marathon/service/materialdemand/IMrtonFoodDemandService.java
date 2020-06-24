package com.marathon.service.materialdemand;

import com.marathon.domain.MrtonFoodDemand;

import java.util.List;

/**
 * 餐饮需求 服务层
 *
 * @author cuigq
 * @date 2020-06-23
 */
public interface IMrtonFoodDemandService {
    /**
     * 查询餐饮需求信息
     *
     * @param id 餐饮需求ID
     * @return 餐饮需求信息
     */
    public MrtonFoodDemand selectMrtonFoodDemandById(Integer id);

    /**
     * 查询餐饮需求列表
     *
     * @param mrtonFoodDemand 餐饮需求信息
     * @return 餐饮需求集合
     */
    public List<MrtonFoodDemand> selectMrtonFoodDemandList(MrtonFoodDemand mrtonFoodDemand);

    /**
     * 新增餐饮需求
     *
     * @param mrtonFoodDemand 餐饮需求信息
     * @return 结果
     */
    public int insertMrtonFoodDemand(MrtonFoodDemand mrtonFoodDemand);

    /**
     * 修改餐饮需求
     *
     * @param mrtonFoodDemand 餐饮需求信息
     * @return 结果
     */
    public int updateMrtonFoodDemand(MrtonFoodDemand mrtonFoodDemand);

    /**
     * 删除餐饮需求信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonFoodDemandByIds(String ids);

}
