package com.marathon.service;

import com.ruoyi.common.base.Ztree;
import com.marathon.domain.MarathonInfo;
import com.marathon.domain.MarathonUser;

import java.util.List;

/**
 * 赛事人员分配 服务层
 *
 * @author null
 * @date 2019-08-19
 */
public interface IMarathonUserService {
    /**
     * 查询赛事人员分配信息
     *
     * @param id 赛事人员分配ID
     * @return 赛事人员分配信息
     */
    public MarathonUser selectMarathon_userById(String id);

    /**
     * 查询赛事人员分配列表
     *
     * @param marathon_user 赛事人员分配信息
     * @return 赛事人员分配集合
     */
    public List<MarathonUser> selectMarathon_userList(MarathonUser marathon_user);

    /**
     * 新增赛事人员分配
     *
     * @param marathon_user 赛事人员分配信息
     * @return 结果
     */
    public int insertMarathon_user(MarathonUser marathon_user);

    /**
     * 修改赛事人员分配
     *
     * @param marathon_user 赛事人员分配信息
     * @return 结果
     */
    public int updateMarathon_user(MarathonUser marathon_user);

    /**
     * 删除赛事人员分配信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMarathon_userByIds(String ids);


    /**
     * 加载赛事相关人员树结构数据
     * @param marathonInfo
     * @param userId
     * @return
     */
    List<Ztree> marathonUserTreeData(MarathonInfo marathonInfo, Long userId);
}
