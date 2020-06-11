package com.marathon.qvo.ceremony;

import com.marathon.domain.Mrton3PartyStaff;
import com.marathon.domain.MrtonResource;
import lombok.Data;

/**
 * @author cuiguangqiang
 * @version Mrton3PartyStaffVO, v0.1 2020/6/5 10:11
 * @description 类说明
 */

@Data
public class Mrton3PartyStaffVO extends Mrton3PartyStaff {

    // 简历文件
    private MrtonResource resumeResource;


}
