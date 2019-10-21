package com.ruoyi.system.mapper.customize;

import com.ruoyi.system.domain.SysUser;

import java.util.List;

public interface SysUserCustomizeMapper {

    List<SysUser> selectUserListByIds(List<Integer> lstMrthonUserId);

}
