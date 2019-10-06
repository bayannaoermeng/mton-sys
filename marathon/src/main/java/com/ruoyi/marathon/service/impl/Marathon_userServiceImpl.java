package com.ruoyi.marathon.service.impl;

import java.util.List;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.ruoyi.common.base.Ztree;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.marathon.domain.Marathon_info;
import com.ruoyi.marathon.domain.Marathon_user;
import com.ruoyi.marathon.mapper.Marathon_userMapper;
import com.ruoyi.marathon.service.IMarathon_userService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 赛事人员分配 服务层实现
 *
 * @author null
 * @date 2019-08-19
 */
@Service
public class Marathon_userServiceImpl implements IMarathon_userService {
    @Autowired
    private Marathon_userMapper marathon_userMapper;

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询赛事人员分配信息
     *
     * @param id 赛事人员分配ID
     * @return 赛事人员分配信息
     */
    @Override
    public Marathon_user selectMarathon_userById(String id) {
        return marathon_userMapper.selectMarathon_userById(id);
    }

    /**
     * 查询赛事人员分配列表
     *
     * @param marathon_user 赛事人员分配信息
     * @return 赛事人员分配集合
     */
    @Override
    public List<Marathon_user> selectMarathon_userList(Marathon_user marathon_user) {
        return marathon_userMapper.selectMarathon_userList(marathon_user);
    }

    /**
     * 新增赛事人员分配
     *
     * @param marathon_user 赛事人员分配信息
     * @return 结果
     */
    @Override
    public int insertMarathon_user(Marathon_user marathon_user) {
        return marathon_userMapper.insertMarathon_user(marathon_user);
    }

    /**
     * 修改赛事人员分配
     *
     * @param marathon_user 赛事人员分配信息
     * @return 结果
     */
    @Override
    public int updateMarathon_user(Marathon_user marathon_user) {
        return marathon_userMapper.updateMarathon_user(marathon_user);
    }

    /**
     * 删除赛事人员分配对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMarathon_userByIds(String ids) {
        return marathon_userMapper.deleteMarathon_userByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<Ztree> marathonUserTreeData(Marathon_info marathonInfo, Long userId) {
        //TODO　userId使用？
        List<SysDept> lstDept = sysDeptService.selectDeptList(new SysDept());

        List<SysUser> lstUser = sysUserService.selectUserList(new SysUser());

        List<String> lstMarathonUserId = Lists.newArrayList();

        if (marathonInfo != null) {
            String uuid = marathonInfo.getMarathon_uuid();
            if (!Strings.isNullOrEmpty(uuid)) {
                Marathon_user user = new Marathon_user();
                user.setMarathon_id(uuid);
                lstMarathonUserId.addAll(Lists.transform(marathon_userMapper.selectMarathon_userList(user), new Function<Marathon_user, String>() {
                    @Override
                    public String apply(Marathon_user input) {
                        return String.valueOf(input.getUser_id());
                    }
                }));
            }
        }
        return initTree(lstDept, lstUser, lstMarathonUserId);
    }

    private List<Ztree> initTree(List<SysDept> lstDept, List<SysUser> lstUser, List<String> lstMarathonUserId) {
        List<Ztree> ztrees = Lists.newArrayList();
        lstDept.stream().filter(sysDept -> UserConstants.DEPT_NORMAL.equals(sysDept.getStatus())).forEach(sysDept -> {
            Ztree ztree = new Ztree();
            ztree.setId(sysDept.getDeptId());
            ztree.setpId(sysDept.getParentId());
            ztree.setName(sysDept.getDeptName());
            ztree.setTitle(sysDept.getDeptName());
            ztree.setNocheck(true);
            ztrees.add(ztree);
        });

        lstUser.stream().forEach(sysUser -> {
            Ztree ztree = new Ztree();
            ztree.setId(sysUser.getUserId());
            ztree.setpId(sysUser.getDeptId());
            ztree.setName(sysUser.getUserName());
            ztree.setTitle(sysUser.getUserName());
            ztrees.add(ztree);
        });

        if(CollectionUtil.isNotEmpty(lstMarathonUserId)){
            ztrees.forEach(ztree -> {
                if (lstMarathonUserId.contains(String.valueOf(ztree.getId()))) {
                    ztree.setChecked(true);
                }
            });
        }

        return ztrees;
    }
}
