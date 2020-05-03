package com.marathon.service;

import com.marathon.domain.MrtonProcCfg;
import com.marathon.domain.MrtonProcCfgExample;

import java.util.List;

/**
 * 赛事分解过程(步骤)配置 服务层
 *
 * @author cuigq
 * @date 2019-10-08
 */
public interface IMrtonProcCfgService {
    /**
     * 新增赛事分解过程(步骤)配置
     *
     * @param mrtonProcCfg 赛事分解过程(步骤)配置信息
     * @return 结果
     */
    public int insertMrtonProcCfg(MrtonProcCfg mrtonProcCfg);

    List<MrtonProcCfg> selectByExample(MrtonProcCfgExample cfg);
}
