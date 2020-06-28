package com.marathon.service.materialdemand.impl;

import cn.hutool.core.convert.Convert;
import com.marathon.domain.MrtonFoodDemand;
import com.marathon.domain.MrtonFoodDemandExample;
import com.marathon.mapper.MrtonFoodDemandMapper;
import com.marathon.service.materialdemand.IMrtonFoodDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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
        MrtonFoodDemand foodDemand = mrtonFoodDemandMapper.selectByPrimaryKey(id);
        if (foodDemand.getServiceTime() != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            foodDemand.getParams().put("serviceTime", dtf.format(foodDemand.getServiceTime()));
        }
        return foodDemand;
    }

    /**
     * 查询餐饮需求列表
     *
     * @param mrtonFoodDemand 餐饮需求信息
     * @return 餐饮需求集合
     */
    @Override
    public List<MrtonFoodDemand> selectMrtonFoodDemandList(MrtonFoodDemand mrtonFoodDemand) {
        MrtonFoodDemandExample example = new MrtonFoodDemandExample();
        example.or().andProcIdEqualTo(mrtonFoodDemand.getProcId());
        return mrtonFoodDemandMapper.selectByExample(example);
    }

    /**
     * 新增餐饮需求
     *
     * @param mrtonFoodDemand 餐饮需求信息
     * @return 结果
     */
    @Override
    public int insertMrtonFoodDemand(MrtonFoodDemand mrtonFoodDemand) {
        return mrtonFoodDemandMapper.insertSelective(mrtonFoodDemand);
    }

    /**
     * 修改餐饮需求
     *
     * @param mrtonFoodDemand 餐饮需求信息
     * @return 结果
     */
    @Override
    public int updateMrtonFoodDemand(MrtonFoodDemand mrtonFoodDemand) {
        MrtonFoodDemandExample example = new MrtonFoodDemandExample();
        example.or().andIdEqualTo(mrtonFoodDemand.getId());
        return mrtonFoodDemandMapper.updateByExampleSelective(mrtonFoodDemand, example);
    }

    /**
     * 删除餐饮需求对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonFoodDemandByIds(String ids) {
        Integer[] arrayId = Convert.toIntArray(ids);
        MrtonFoodDemandExample example = new MrtonFoodDemandExample();
        example.or().andIdIn(Arrays.asList(arrayId));
        return mrtonFoodDemandMapper.deleteByExample(example);
    }

}
