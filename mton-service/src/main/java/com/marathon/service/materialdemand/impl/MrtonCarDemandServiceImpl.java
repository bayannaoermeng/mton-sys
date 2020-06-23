package com.marathon.service.materialdemand.impl;

import java.util.List;

import com.marathon.service.materialdemand.IMrtonCarDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.mapper.MrtonCarDemandMapper;
import com.marathon.domain.MrtonCarDemand;

/**
 * 车辆需求 服务层实现
 *
 * @author cuigq
 * @date 2020-06-23
 */
@Service
public class MrtonCarDemandServiceImpl implements IMrtonCarDemandService {
    @Autowired
    private MrtonCarDemandMapper mrtonCarDemandMapper;

    /**
     * 查询车辆需求信息
     *
     * @param id 车辆需求ID
     * @return 车辆需求信息
     */
    @Override
    public MrtonCarDemand selectMrtonCarDemandById(Integer id) {
        return null;
    }

    /**
     * 查询车辆需求列表
     *
     * @param mrtonCarDemand 车辆需求信息
     * @return 车辆需求集合
     */
    @Override
    public List<MrtonCarDemand> selectMrtonCarDemandList(MrtonCarDemand mrtonCarDemand) {
        return null;
    }

    /**
     * 新增车辆需求
     *
     * @param mrtonCarDemand 车辆需求信息
     * @return 结果
     */
    @Override
    public int insertMrtonCarDemand(MrtonCarDemand mrtonCarDemand) {
        return 1;
    }

    /**
     * 修改车辆需求
     *
     * @param mrtonCarDemand 车辆需求信息
     * @return 结果
     */
    @Override
    public int updateMrtonCarDemand(MrtonCarDemand mrtonCarDemand) {
        return 1;
    }

    /**
     * 删除车辆需求对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonCarDemandByIds(String ids) {
        return 1;
    }

}
