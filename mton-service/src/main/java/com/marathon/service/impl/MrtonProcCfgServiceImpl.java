package com.marathon.service.impl;

import java.util.List;

import cn.hutool.core.convert.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.mapper.MrtonProcCfgMapper;
import com.marathon.domain.MrtonProcCfg;
import com.marathon.service.IMrtonProcCfgService;

/**
 * 赛事分解过程(步骤)配置 服务层实现
 *
 * @author cuigq
 * @date 2019-10-08
 */
@Service
public class MrtonProcCfgServiceImpl implements IMrtonProcCfgService {
    @Autowired
    private MrtonProcCfgMapper mrtonProcCfgMapper;

    /**
     * 查询赛事分解过程(步骤)配置信息
     *
     * @param procId 赛事分解过程(步骤)配置ID
     * @return 赛事分解过程(步骤)配置信息
     */
    @Override
    public MrtonProcCfg selectMrtonProcCfgById(String procId) {
        return mrtonProcCfgMapper.selectMrtonProcCfgById(procId);
    }

    /**
     * 查询赛事分解过程(步骤)配置列表
     *
     * @param mrtonProcCfg 赛事分解过程(步骤)配置信息
     * @return 赛事分解过程(步骤)配置集合
     */
    @Override
    public List<MrtonProcCfg> selectMrtonProcCfgList(MrtonProcCfg mrtonProcCfg) {
        return mrtonProcCfgMapper.selectMrtonProcCfgList(mrtonProcCfg);
    }

    /**
     * 新增赛事分解过程(步骤)配置
     *
     * @param mrtonProcCfg 赛事分解过程(步骤)配置信息
     * @return 结果
     */
    @Override
    public int insertMrtonProcCfg(MrtonProcCfg mrtonProcCfg) {
        return mrtonProcCfgMapper.insertMrtonProcCfg(mrtonProcCfg);
    }

    /**
     * 修改赛事分解过程(步骤)配置
     *
     * @param mrtonProcCfg 赛事分解过程(步骤)配置信息
     * @return 结果
     */
    @Override
    public int updateMrtonProcCfg(MrtonProcCfg mrtonProcCfg) {
        return mrtonProcCfgMapper.updateMrtonProcCfg(mrtonProcCfg);
    }

    /**
     * 删除赛事分解过程(步骤)配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonProcCfgByIds(String ids) {
        return mrtonProcCfgMapper.deleteMrtonProcCfgByIds(Convert.toStrArray(ids));
    }

}
