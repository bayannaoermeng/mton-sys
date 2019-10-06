package com.ruoyi.marathon.mapper;

import com.ruoyi.marathon.domain.Marathon_user;

import java.util.List;

/**
 * 赛事人员分配 数据层
 *
 * @author null
 * @date 2019-08-19
 */
public interface Marathon_userMapper {
    /**
     * 查询赛事人员分配信息
     *
     * @param id 赛事人员分配ID
     * @return 赛事人员分配信息
     */
    public Marathon_user selectMarathon_userById(String id);

    /**
     * 查询赛事人员分配列表
     *
     * @param marathon_user 赛事人员分配信息
     * @return 赛事人员分配集合
     */
    public List<Marathon_user> selectMarathon_userList(Marathon_user marathon_user);

    /**
     * 新增赛事人员分配
     *
     * @param marathon_user 赛事人员分配信息
     * @return 结果
     */
    public int insertMarathon_user(Marathon_user marathon_user);

    /**
     * 修改赛事人员分配
     *
     * @param marathon_user 赛事人员分配信息
     * @return 结果
     */
    public int updateMarathon_user(Marathon_user marathon_user);

    /**
     * 删除赛事人员分配
     *
     * @param id 赛事人员分配ID
     * @return 结果
     */
    public int deleteMarathon_userById(String id);

    /**
     * 批量删除赛事人员分配
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMarathon_userByIds(String[] ids);

    /**
     * 删除赛事人员关联记录
     * @param marathon_uuid
     */
    void deleteByMarathonId(String marathon_uuid);

    void deleteByMarathonIds(String[] arrayMarathonuuids);
}