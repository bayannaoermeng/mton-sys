package com.marathon.mapper;

import com.marathon.domain.MrtonProcInfo;

import java.util.List;

/**
 * 赛事过程关系 数据层
 *
 * @author null
 * @date 2019-10-17
 */
public interface MrtonProcInfoMapper {
    /**
     * 查询赛事过程关系信息
     *
     * @param id 赛事过程关系ID
     * @return 赛事过程关系信息
     */
    public MrtonProcInfo selectMrtonProcInfoById(String id);

    /**
     * 查询赛事过程关系列表
     *
     * @param mrtonProcInfo 赛事过程关系信息
     * @return 赛事过程关系集合
     */
    public List<MrtonProcInfo> selectMrtonProcInfoList(MrtonProcInfo mrtonProcInfo);

    /**
     * 新增赛事过程关系
     *
     * @param mrtonProcInfo 赛事过程关系信息
     * @return 结果
     */
    public int insertMrtonProcInfo(MrtonProcInfo mrtonProcInfo);

    /**
     * 修改赛事过程关系
     *
     * @param mrtonProcInfo 赛事过程关系信息
     * @return 结果
     */
    public int updateMrtonProcInfo(MrtonProcInfo mrtonProcInfo);

    /**
     * 删除赛事过程关系
     *
     * @param id 赛事过程关系ID
     * @return 结果
     */
    public int deleteMrtonProcInfoById(String id);

    /**
     * 批量删除赛事过程关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonProcInfoByIds(String[] ids);

}