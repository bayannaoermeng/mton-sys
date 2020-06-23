package com.marathon.service.materialdemand;

import com.marathon.domain.MrtonClothesDemand;
import java.util.List;

/**
 * 服装需求 服务层
 *
 * @author cuigq
 * @date 2020-06-23
 */
public interface IMrtonClothesDemandService {
    /**
     * 查询服装需求信息
     *
     * @param id 服装需求ID
     * @return 服装需求信息
     */
    public MrtonClothesDemand selectMrtonClothesDemandById(Integer id);

    /**
     * 查询服装需求列表
     *
     * @param mrtonClothesDemand 服装需求信息
     * @return 服装需求集合
     */
    public List<MrtonClothesDemand> selectMrtonClothesDemandList(MrtonClothesDemand mrtonClothesDemand);

    /**
     * 新增服装需求
     *
     * @param mrtonClothesDemand 服装需求信息
     * @return 结果
     */
    public int insertMrtonClothesDemand(MrtonClothesDemand mrtonClothesDemand);

    /**
     * 修改服装需求
     *
     * @param mrtonClothesDemand 服装需求信息
     * @return 结果
     */
    public int updateMrtonClothesDemand(MrtonClothesDemand mrtonClothesDemand);

    /**
     * 删除服装需求信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonClothesDemandByIds(String ids);

}
