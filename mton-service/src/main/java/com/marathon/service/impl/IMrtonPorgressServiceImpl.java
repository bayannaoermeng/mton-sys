package com.marathon.service.impl;

import com.google.common.collect.Lists;
import com.marathon.MrtonProcStatusEnum;
import com.marathon.domain.beans.MrtonProgBean;
import com.marathon.domain.beans.MrtonProgRequest;
import com.marathon.mapper.customize.MrtonProgCustomizeMapper;
import com.marathon.qvo.MrtonProgDetailVO;
import com.marathon.service.IMrtonProgressService;
import com.mton.system.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cuiguangqiang
 * @version IMrtonPorgressServiceImpl, v0.1 2019/10/23 15:40
 * @description 类说明
 */

@Slf4j
@Service
public class IMrtonPorgressServiceImpl implements IMrtonProgressService {

    @Autowired
    private MrtonProgCustomizeMapper mrtonProgCustomizeMapper;

    @Override
    public List<MrtonProgDetailVO> getMyMrtonProgDetail(SysUser user) {

        List<MrtonProgDetailVO> result= Lists.newArrayList();

        MrtonProgRequest request=new MrtonProgRequest();
        request.setUserId(user.getUserId());
        List<MrtonProgBean> lstTotalBean=mrtonProgCustomizeMapper.getMyMrtonProgStatistic(request);

        request.setStatus(MrtonProcStatusEnum.FINISH.getKey());
        List<MrtonProgBean> lstFinishedBean=mrtonProgCustomizeMapper.getMyMrtonProgStatistic(request);

        Map<String,List<MrtonProgBean>> groupBy=lstTotalBean.stream().collect(Collectors.groupingBy(MrtonProgBean::getMrtonName));

        groupBy.forEach((k,v)->{

            MrtonProgDetailVO vo=new MrtonProgDetailVO();

            vo.setMrtonName(k);

            v.forEach(mrtonProgBean -> {
                MrtonProgDetailVO.TaskProgDetail taskProgDetail=vo.new TaskProgDetail();
                taskProgDetail.setTaskName(mrtonProgBean.getProcName());
                taskProgDetail.setTotal(mrtonProgBean.getNumber());

                for(MrtonProgBean finishedBean:lstFinishedBean){
                    if(mrtonProgBean.getMrtonId().equals(finishedBean.getMrtonId()) && mrtonProgBean.getProcId().equals(finishedBean.getProcId())){
                        taskProgDetail.setFinished(finishedBean.getNumber() == null?0:finishedBean.getNumber());
                    }
                }
                taskProgDetail.setCompletionRate(ADivideBPercent(new BigDecimal(String.valueOf(taskProgDetail.getFinished())),new BigDecimal(String.valueOf(taskProgDetail.getTotal()))));
                vo.getLstTaskProgDetail().add(taskProgDetail);
            });

            result.add(vo);
        });
        return result;
    }

    public static String ADivideBPercent(BigDecimal a, BigDecimal b){
        String percent =
                b == null ? "-" :
                        b.compareTo(new BigDecimal(0)) == 0 ? "-":
                                a == null ? "0.00%" :
                                        a.multiply(new BigDecimal(100)).divide(b,2,BigDecimal.ROUND_HALF_UP) + "%";
        return percent;
    }

}
