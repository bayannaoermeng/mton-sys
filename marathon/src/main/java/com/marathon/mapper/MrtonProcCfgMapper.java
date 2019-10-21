package com.marathon.mapper;

import com.marathon.domain.MrtonProcCfg;
import java.util.List;

/**
 * 赛事分解过程(步骤)配置 数据层
 *
 * @author cuigq
 * @date 2019-10-08
 */
public interface MrtonProcCfgMapper {
    /**
     * 查询赛事分解过程(步骤)配置信息
     *
     * @param procId 赛事分解过程(步骤)配置ID
     * @return 赛事分解过程(步骤)配置信息
     */
    public MrtonProcCfg selectMrtonProcCfgById(String procId);

    /**
     * 查询赛事分解过程(步骤)配置列表
     *
     * @param mrtonProcCfg 赛事分解过程(步骤)配置信息
     * @return 赛事分解过程(步骤)配置集合
     */
    public List<MrtonProcCfg> selectMrtonProcCfgList(MrtonProcCfg mrtonProcCfg);

    /**
     * 新增赛事分解过程(步骤)配置
     *
     * @param mrtonProcCfg 赛事分解过程(步骤)配置信息
     * @return 结果
     */
    public int insertMrtonProcCfg(MrtonProcCfg mrtonProcCfg);

    /**
     * 修改赛事分解过程(步骤)配置
     *
     * @param mrtonProcCfg 赛事分解过程(步骤)配置信息
     * @return 结果
     */
    public int updateMrtonProcCfg(MrtonProcCfg mrtonProcCfg);

    /**
     * 删除赛事分解过程(步骤)配置
     *
     * @param procId 赛事分解过程(步骤)配置ID
     * @return 结果
     */
    public int deleteMrtonProcCfgById(String procId);

    /**
     * 批量删除赛事分解过程(步骤)配置
     *
     * @param procIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonProcCfgByIds(String[] procIds);

}