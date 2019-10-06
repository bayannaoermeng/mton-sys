package com.ruoyi.marathon.service;

import com.ruoyi.marathon.domain.Marathon_info;
import java.util.List;

/**
 * 赛事 服务层
 *
 * @author null
 * @date 2019-08-17
 */
public interface IMarathon_infoService {
    /**
     * 查询赛事信息
     *
     * @param marathon_uuid 赛事ID
     * @return 赛事信息
     */
    public Marathon_info selectMarathon_infoById(String marathon_uuid);

    /**
     * 查询赛事列表
     *
     * @param marathon_info 赛事信息
     * @return 赛事集合
     */
    public List<Marathon_info> selectMarathon_infoList(Marathon_info marathon_info);

    /**
     * 新增赛事
     *
     * @param marathon_info 赛事信息
     * @return 结果
     */
    public int insertMarathon_info(Marathon_info marathon_info);

    /**
     * 修改赛事
     *
     * @param marathon_info 赛事信息
     * @return 结果
     */
    public int updateMarathon_info(Marathon_info marathon_info);

    /**
     * 删除赛事信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMarathon_infoByIds(String ids);

}
