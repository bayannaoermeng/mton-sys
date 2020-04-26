package com.marathon.mapper;

import com.marathon.domain.MrtonProcUser;

import java.util.List;

/**
 * 赛事任务人员关系 数据层
 *
 * @author null
 * @date 2019-10-17
 */
public interface MrtonProcUserMapper {
    /**
     * 查询赛事任务人员关系信息
     *
     * @param id 赛事任务人员关系ID
     * @return 赛事任务人员关系信息
     */
    public MrtonProcUser selectMrtonProcUserById(Integer id);

    /**
     * 查询赛事任务人员关系列表
     *
     * @param mrtonProcUser 赛事任务人员关系信息
     * @return 赛事任务人员关系集合
     */
    public List<MrtonProcUser> selectMrtonProcUserList(MrtonProcUser mrtonProcUser);

    /**
     * 新增赛事任务人员关系
     *
     * @param mrtonProcUser 赛事任务人员关系信息
     * @return 结果
     */
    public int insertMrtonProcUser(MrtonProcUser mrtonProcUser);

    /**
     * 修改赛事任务人员关系
     *
     * @param mrtonProcUser 赛事任务人员关系信息
     * @return 结果
     */
    public int updateMrtonProcUser(MrtonProcUser mrtonProcUser);

    /**
     * 删除赛事任务人员关系
     *
     * @param id 赛事任务人员关系ID
     * @return 结果
     */
    public int deleteMrtonProcUserById(Integer id);

    /**
     * 批量删除赛事任务人员关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonProcUserByIds(String[] ids);

}