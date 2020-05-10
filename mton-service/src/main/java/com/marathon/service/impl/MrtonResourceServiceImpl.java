package com.marathon.service.impl;

import java.util.List;

import cn.hutool.core.convert.Convert;
import com.marathon.domain.MrtonResource;
import com.marathon.mapper.MrtonResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.service.IMrtonResourceService;

/**
 * 任务关联资源（文件） 服务层实现
 *
 * @author cuigq
 * @date 2019-11-05
 */
@Service
public class MrtonResourceServiceImpl implements IMrtonResourceService {
    @Autowired
    private MrtonResourceMapper mrtonResourceMapper;

    /**
     * 查询任务关联资源（文件）信息
     *
     * @param id 任务关联资源（文件）ID
     * @return 任务关联资源（文件）信息
     */
    @Override
    public MrtonResource selectMrtonResourceById(Integer id) {
        return mrtonResourceMapper.selectMrtonResourceById(id);
    }

    /**
     * 查询任务关联资源（文件）列表
     *
     * @param mrtonResource 任务关联资源（文件）信息
     * @return 任务关联资源（文件）集合
     */
    @Override
    public List<MrtonResource> selectMrtonResourceList(MrtonResource mrtonResource) {
        return mrtonResourceMapper.selectMrtonResourceList(mrtonResource);
    }

    /**
     * 新增任务关联资源（文件）
     *
     * @param mrtonResource 任务关联资源（文件）信息
     * @return 结果
     */
    @Override
    public int insertMrtonResource(MrtonResource mrtonResource) {
        return mrtonResourceMapper.insertSelective(mrtonResource);
    }

    /**
     * 修改任务关联资源（文件）
     *
     * @param mrtonResource 任务关联资源（文件）信息
     * @return 结果
     */
    @Override
    public int updateMrtonResource(MrtonResource mrtonResource) {
        return mrtonResourceMapper.updateMrtonResource(mrtonResource);
    }

    /**
     * 删除任务关联资源（文件）对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonResourceByIds(String ids) {
        return mrtonResourceMapper.deleteMrtonResourceByIds(Convert.toStrArray(ids));
    }

}
