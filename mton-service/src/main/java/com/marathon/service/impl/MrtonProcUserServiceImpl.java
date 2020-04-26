package com.marathon.service.impl;

import java.util.List;

import cn.hutool.core.convert.Convert;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.marathon.qvo.SaveProcPrincipalQO;
import com.mton.common.base.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marathon.mapper.MrtonProcUserMapper;
import com.marathon.domain.MrtonProcUser;
import com.marathon.service.IMrtonProcUserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 赛事任务人员关系 服务层实现
 *
 * @author cuigq
 * @date 2019-10-14
 */
@Service
public class MrtonProcUserServiceImpl implements IMrtonProcUserService {
    @Autowired
    private MrtonProcUserMapper mrtonProcUserMapper;

    /**
     * 查询赛事任务人员关系信息
     *
     * @param id 赛事任务人员关系ID
     * @return 赛事任务人员关系信息
     */
    @Override
    public MrtonProcUser selectMrtonProcUserById(Integer id) {
        return mrtonProcUserMapper.selectMrtonProcUserById(id);
    }

    /**
     * 查询赛事任务人员关系列表
     *
     * @param mrtonProcUser 赛事任务人员关系信息
     * @return 赛事任务人员关系集合
     */
    @Override
    public List<MrtonProcUser> selectMrtonProcUserList(MrtonProcUser mrtonProcUser) {
        return mrtonProcUserMapper.selectMrtonProcUserList(mrtonProcUser);
    }

    /**
     * 新增赛事任务人员关系
     *
     * @param mrtonProcUser 赛事任务人员关系信息
     * @return 结果
     */
    @Override
    public int insertMrtonProcUser(MrtonProcUser mrtonProcUser) {
        return mrtonProcUserMapper.insertMrtonProcUser(mrtonProcUser);
    }

    /**
     * 修改赛事任务人员关系
     *
     * @param mrtonProcUser 赛事任务人员关系信息
     * @return 结果
     */
    @Override
    public int updateMrtonProcUser(MrtonProcUser mrtonProcUser) {
        return mrtonProcUserMapper.updateMrtonProcUser(mrtonProcUser);
    }

    /**
     * 删除赛事任务人员关系对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMrtonProcUserByIds(String ids) {
        return mrtonProcUserMapper.deleteMrtonProcUserByIds(Convert.toStrArray(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult saveProcPrincipals(SaveProcPrincipalQO qo) {
        //TODO
        MrtonProcUser user=new MrtonProcUser();
        user.setParentProcId(qo.getParentProcId());
        user.setMrtonId(qo.getMrtonId());
        List<MrtonProcUser> lstUser=mrtonProcUserMapper.selectMrtonProcUserList(user);

        if(!CollectionUtils.isEmpty(lstUser)){
            List<String> toDeletedIds= Lists.transform(lstUser, new Function<MrtonProcUser, String>() {
                @Override
                public String apply(MrtonProcUser mrtonProcUser) {
                    return String.valueOf(mrtonProcUser.getId());
                }
            });
            String[] arrayToDeletedIds = new String[toDeletedIds.size()];
            arrayToDeletedIds = toDeletedIds.toArray(arrayToDeletedIds);
            mrtonProcUserMapper.deleteMrtonProcUserByIds(arrayToDeletedIds);
        }

        if(!Strings.isNullOrEmpty(qo.getParentProcId()) && !Strings.isNullOrEmpty(qo.getPrincipals())){
            List<String> lstUserId= Splitter.on(",").splitToList(qo.getPrincipals());
            lstUserId.forEach(userId->{
                MrtonProcUser procUser=new MrtonProcUser();
                procUser.setMrtonId(qo.getMrtonId());
                procUser.setParentProcId(qo.getParentProcId());
                procUser.setUserId(Integer.valueOf(userId));
                mrtonProcUserMapper.insertMrtonProcUser(procUser);
            });
        }
        return AjaxResult.success();
    }
}
