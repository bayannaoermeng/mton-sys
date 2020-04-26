package com.marathon.service;

import com.marathon.domain.MrtonProcUser;
import com.marathon.qvo.SaveProcPrincipalQO;
import com.mton.common.base.AjaxResult;

import java.util.List;

/**
 * 赛事任务人员关系 服务层
 *
 * @author cuigq
 * @date 2019-10-14
 */
public interface IMrtonProcUserService {
    /**
     * 查询赛事任务人员关系信息
     *
     * @param id 赛事任务人员关系ID
     * @return 赛事任务人员关系信息
     */
    public MrtonProcUser selectMrtonProcUserById(Integer id);

    /**
     * 查询赛事任务人员关系列表
     *
     * @param mrtonProcUser 赛事任务人员关系信息
     * @return 赛事任务人员关系集合
     */
    public List<MrtonProcUser> selectMrtonProcUserList(MrtonProcUser mrtonProcUser);

    /**
     * 新增赛事任务人员关系
     *
     * @param mrtonProcUser 赛事任务人员关系信息
     * @return 结果
     */
    public int insertMrtonProcUser(MrtonProcUser mrtonProcUser);

    /**
     * 修改赛事任务人员关系
     *
     * @param mrtonProcUser 赛事任务人员关系信息
     * @return 结果
     */
    public int updateMrtonProcUser(MrtonProcUser mrtonProcUser);

    /**
     * 删除赛事任务人员关系信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonProcUserByIds(String ids);

    /**
     * 保存分配责任人
     * @param qo
     * @return
     */
    AjaxResult saveProcPrincipals(SaveProcPrincipalQO qo);
}
