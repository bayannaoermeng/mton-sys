package com.marathon.mapper;

import com.marathon.domain.MarathonInfo;
import java.util.List;

/**
 * 赛事 数据层
 *
 * @author null
 * @date 2019-08-17
 */
public interface MarathonInfoMapper {
    /**
     * 查询赛事信息
     *
     * @param marathon_uuid 赛事ID
     * @return 赛事信息
     */
    public MarathonInfo selectMarathon_infoById(String marathon_uuid);

    /**
     * 查询赛事列表
     *
     * @param marathon_info 赛事信息
     * @return 赛事集合
     */
    public List<MarathonInfo> selectMarathon_infoList(MarathonInfo marathon_info);

    /**
     * 新增赛事
     *
     * @param marathon_info 赛事信息
     * @return 结果
     */
    public int insertMarathon_info(MarathonInfo marathon_info);

    /**
     * 修改赛事
     *
     * @param marathon_info 赛事信息
     * @return 结果
     */
    public int updateMarathon_info(MarathonInfo marathon_info);

    /**
     * 删除赛事
     *
     * @param marathon_uuid 赛事ID
     * @return 结果
     */
    public int deleteMarathon_infoById(String marathon_uuid);

    /**
     * 批量删除赛事
     *
     * @param marathon_uuids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMarathon_infoByIds(String[] marathon_uuids);

}