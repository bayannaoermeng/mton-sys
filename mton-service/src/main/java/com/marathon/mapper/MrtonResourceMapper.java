package com.marathon.mapper;

import com.marathon.domain.MrtonResource;
import com.marathon.domain.MrtonResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrtonResourceMapper {
    int countByExample(MrtonResourceExample example);

    int deleteByExample(MrtonResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MrtonResource record);

    int insertSelective(MrtonResource record);

    List<MrtonResource> selectByExample(MrtonResourceExample example);

    MrtonResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MrtonResource record, @Param("example") MrtonResourceExample example);

    int updateByExample(@Param("record") MrtonResource record, @Param("example") MrtonResourceExample example);

    int updateByPrimaryKeySelective(MrtonResource record);

    int updateByPrimaryKey(MrtonResource record);
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
     * 删除任务关联资源（文件）
     *
     * @param id 任务关联资源（文件）ID
     * @return 结果
     */
    public int deleteMrtonResourceById(Integer id);

    /**
     * 批量删除任务关联资源（文件）
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonResourceByIds(String[] ids);
}