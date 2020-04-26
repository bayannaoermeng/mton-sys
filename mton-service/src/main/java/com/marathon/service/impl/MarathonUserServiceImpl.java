package com.marathon.service.impl;

import java.util.List;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mton.common.base.Ztree;
import com.mton.common.constant.UserConstants;
import com.marathon.domain.MarathonInfo;
import com.marathon.domain.MarathonUser;
import com.marathon.mapper.MarathonUserMapper;
import com.marathon.service.IMarathonUserService;
import com.mton.system.domain.SysDept;
import com.mton.system.domain.SysUser;
import com.mton.system.service.ISysDeptService;
import com.mton.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 赛事人员分配 服务层实现
 *
 * @author null
 * @date 2019-08-19
 */
@Service
public class MarathonUserServiceImpl implements IMarathonUserService {
    @Autowired
    private MarathonUserMapper marathonUserMapper;

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
    public MarathonUser selectMarathon_userById(String id) {
        return marathonUserMapper.selectMarathon_userById(id);
    }

    /**
     * 查询赛事人员分配列表
     *
     * @param marathon_user 赛事人员分配信息
     * @return 赛事人员分配集合
     */
    @Override
    public List<MarathonUser> selectMarathon_userList(MarathonUser marathon_user) {
        return marathonUserMapper.selectMarathon_userList(marathon_user);
    }

    /**
     * 新增赛事人员分配
     *
     * @param marathon_user 赛事人员分配信息
     * @return 结果
     */
    @Override
    public int insertMarathon_user(MarathonUser marathon_user) {
        return marathonUserMapper.insertMarathon_user(marathon_user);
    }

    /**
     * 修改赛事人员分配
     *
     * @param marathon_user 赛事人员分配信息
     * @return 结果
     */
    @Override
    public int updateMarathon_user(MarathonUser marathon_user) {
        return marathonUserMapper.updateMarathon_user(marathon_user);
    }

    /**
     * 删除赛事人员分配对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMarathon_userByIds(String ids) {
        return marathonUserMapper.deleteMarathon_userByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<Ztree> marathonUserTreeData(MarathonInfo marathonInfo, Long userId) {
        //TODO　userId使用？
        List<SysDept> lstDept = sysDeptService.selectDeptList(new SysDept());

        List<SysUser> lstUser = sysUserService.selectUserList(new SysUser());

        List<String> lstMarathonUserId = Lists.newArrayList();

        if (marathonInfo != null) {
            String uuid = marathonInfo.getMarathon_uuid();
            if (!Strings.isNullOrEmpty(uuid)) {
                MarathonUser user = new MarathonUser();
                user.setMarathon_id(uuid);
                lstMarathonUserId.addAll(Lists.transform(marathonUserMapper.selectMarathon_userList(user), new Function<MarathonUser, String>() {
                    @Override
                    public String apply(MarathonUser input) {
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
