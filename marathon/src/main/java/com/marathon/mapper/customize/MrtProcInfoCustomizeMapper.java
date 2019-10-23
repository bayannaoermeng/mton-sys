package com.marathon.mapper.customize;

import com.marathon.MrthonMenuEnum;
import com.marathon.domain.MarathonInfo;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.qvo.MrthonMenuBean;
import com.marathon.qvo.MrtonProcInfoVO;
import com.marathon.qvo.MyMrtonProcVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MrtProcInfoCustomizeMapper {

    /**
     * 根据mrthonId查询父任务实例列表
     * @param marathonId
     * @return
     */
    List<MrtonProcInfoVO> selectMrtProcs(String marathonId);

    List<MyMrtonProcVO> selectMyMrtonProc(@Param("userId") Long userId, @Param("procName") String name, @Param("marathonId") String marathonId);

    List<MarathonInfo> selectMyMrton(@Param("userId") Long userId, @Param("procName") String name);

    List<MrthonMenuBean> getMrtonMenu(Long userId);

    MrtonProcInfo queryMrtonInfoById(String mrtonprocId);
}

