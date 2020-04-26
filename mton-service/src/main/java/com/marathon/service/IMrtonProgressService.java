package com.marathon.service;

import com.marathon.qvo.MrtonProgDetailVO;
import com.mton.system.domain.SysUser;

import java.util.List;

public interface IMrtonProgressService {

    List<MrtonProgDetailVO> getMyMrtonProgDetail(SysUser user);

}
