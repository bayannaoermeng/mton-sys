package com.marathon.mapper.customize;

import com.marathon.domain.beans.MrtonProgBean;
import com.marathon.domain.beans.MrtonProgRequest;

import java.util.List;

public interface MrtonProgCustomizeMapper {


    /**
     * 统计进度完成率
     * @param request
     * @return
     */
    List<MrtonProgBean> getMyMrtonProgStatistic(MrtonProgRequest request);

}
