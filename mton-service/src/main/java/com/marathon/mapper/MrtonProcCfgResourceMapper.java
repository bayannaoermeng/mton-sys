package com.marathon.mapper;

import com.marathon.domain.MrtonProcCfgResource;
import com.marathon.domain.MrtonProcCfgResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrtonProcCfgResourceMapper {
    int countByExample(MrtonProcCfgResourceExample example);

    int deleteByExample(MrtonProcCfgResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MrtonProcCfgResource record);

    int insertSelective(MrtonProcCfgResource record);

    List<MrtonProcCfgResource> selectByExample(MrtonProcCfgResourceExample example);

    MrtonProcCfgResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MrtonProcCfgResource record, @Param("example") MrtonProcCfgResourceExample example);

    int updateByExample(@Param("record") MrtonProcCfgResource record, @Param("example") MrtonProcCfgResourceExample example);

    int updateByPrimaryKeySelective(MrtonProcCfgResource record);

    int updateByPrimaryKey(MrtonProcCfgResource record);
}