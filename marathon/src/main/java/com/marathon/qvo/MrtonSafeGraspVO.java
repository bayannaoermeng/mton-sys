package com.marathon.qvo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marathon.domain.MrtonSafetyGrasp;
import lombok.Data;

import java.util.Date;

/**
 * @author cuiguangqiang
 * @version MrtonSafeGraspVO, v0.1 2019/10/29 18:45
 * @description 类说明
 */
@Data
public class MrtonSafeGraspVO extends MrtonSafetyGrasp {

    private String mrtonStarttime;

    private String mrtonAddress;
}
