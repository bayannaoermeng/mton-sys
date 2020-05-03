package com.marathon.service.impl;

import java.util.List;

import cn.hutool.core.convert.Convert;
import com.marathon.domain.MrtonProcCfgExample;
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
     * 新增赛事分解过程(步骤)配置
     *
     * @param mrtonProcCfg 赛事分解过程(步骤)配置信息
     * @return 结果
     */
    @Override
    public int insertMrtonProcCfg(MrtonProcCfg mrtonProcCfg) {
        return mrtonProcCfgMapper.insert(mrtonProcCfg);
    }

    @Override
    public List<MrtonProcCfg> selectByExample(MrtonProcCfgExample cfg) {
        return mrtonProcCfgMapper.selectByExample(cfg);
    }
}
