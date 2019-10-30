package com.mton.system.mapper.customize;

import com.mton.system.domain.SysUser;

import java.util.List;

public interface SysUserCustomizeMapper {

    List<SysUser> selectUserListByIds(List<Integer> lstMrthonUserId);

}
