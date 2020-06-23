package com.marathon.service.materialdemand;

import com.marathon.domain.MrtonCarDemand;
import java.util.List;

/**
 * 车辆需求 服务层
 *
 * @author cuigq
 * @date 2020-06-23
 */
public interface IMrtonCarDemandService {
    /**
     * 查询车辆需求信息
     *
     * @param id 车辆需求ID
     * @return 车辆需求信息
     */
    public MrtonCarDemand selectMrtonCarDemandById(Integer id);

    /**
     * 查询车辆需求列表
     *
     * @param mrtonCarDemand 车辆需求信息
     * @return 车辆需求集合
     */
    public List<MrtonCarDemand> selectMrtonCarDemandList(MrtonCarDemand mrtonCarDemand);

    /**
     * 新增车辆需求
     *
     * @param mrtonCarDemand 车辆需求信息
     * @return 结果
     */
    public int insertMrtonCarDemand(MrtonCarDemand mrtonCarDemand);

    /**
     * 修改车辆需求
     *
     * @param mrtonCarDemand 车辆需求信息
     * @return 结果
     */
    public int updateMrtonCarDemand(MrtonCarDemand mrtonCarDemand);

    /**
     * 删除车辆需求信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonCarDemandByIds(String ids);

}
