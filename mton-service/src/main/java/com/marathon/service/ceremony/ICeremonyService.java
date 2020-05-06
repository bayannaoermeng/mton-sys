package com.marathon.service.ceremony;

import com.marathon.MrtonProcEnum;
import com.marathon.qvo.OrgChartDataVO;

public interface ICeremonyService {

    OrgChartDataVO getData(String mrtonId,MrtonProcEnum mrtonProcEnum);

}
