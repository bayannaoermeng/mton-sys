package com.marathon.mapper;

import com.marathon.domain.MrtonWordItem;
import com.marathon.domain.MrtonWordItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MrtonWordItemMapper {
    int countByExample(MrtonWordItemExample example);

    int deleteByExample(MrtonWordItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MrtonWordItem record);

    int insertSelective(MrtonWordItem record);

    List<MrtonWordItem> selectByExample(MrtonWordItemExample example);

    MrtonWordItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MrtonWordItem record, @Param("example") MrtonWordItemExample example);

    int updateByExample(@Param("record") MrtonWordItem record, @Param("example") MrtonWordItemExample example);

    int updateByPrimaryKeySelective(MrtonWordItem record);

    int updateByPrimaryKey(MrtonWordItem record);
}