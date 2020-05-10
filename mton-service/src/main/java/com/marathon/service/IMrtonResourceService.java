package com.marathon.service;

import com.marathon.domain.MrtonResource;

import java.util.List;

/**
 * 任务关联资源（文件） 服务层
 *
 * @author cuigq
 * @date 2019-11-05
 */
public interface IMrtonResourceService {
    /**
     * 查询任务关联资源（文件）信息
     *
     * @param id 任务关联资源（文件）ID
     * @return 任务关联资源（文件）信息
     */
    public MrtonResource selectMrtonResourceById(Integer id);

    /**
     * 查询任务关联资源（文件）列表
     *
     * @param mrtonResource 任务关联资源（文件）信息
     * @return 任务关联资源（文件）集合
     */
    public List<MrtonResource> selectMrtonResourceList(MrtonResource mrtonResource);

    /**
     * 新增任务关联资源（文件）
     *
     * @param mrtonResource 任务关联资源（文件）信息
     * @return 结果
     */
    public int insertMrtonResource(MrtonResource mrtonResource);

    /**
     * 修改任务关联资源（文件）
     *
     * @param mrtonResource 任务关联资源（文件）信息
     * @return 结果
     */
    public int updateMrtonResource(MrtonResource mrtonResource);

    /**
     * 删除任务关联资源（文件）信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonResourceByIds(String ids);

}
