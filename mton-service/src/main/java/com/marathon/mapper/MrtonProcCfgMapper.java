package com.marathon.mapper;

import com.marathon.domain.MrtonProcCfg;
import com.marathon.domain.MrtonProcCfgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrtonProcCfgMapper {
    int countByExample(MrtonProcCfgExample example);

    int deleteByExample(MrtonProcCfgExample example);

    int deleteByPrimaryKey(String procId);

    int insert(MrtonProcCfg record);

    int insertSelective(MrtonProcCfg record);

    List<MrtonProcCfg> selectByExample(MrtonProcCfgExample example);

    MrtonProcCfg selectByPrimaryKey(String procId);

    int updateByExampleSelective(@Param("record") MrtonProcCfg record, @Param("example") MrtonProcCfgExample example);

    int updateByExample(@Param("record") MrtonProcCfg record, @Param("example") MrtonProcCfgExample example);

    int updateByPrimaryKeySelective(MrtonProcCfg record);

    int updateByPrimaryKey(MrtonProcCfg record);
}