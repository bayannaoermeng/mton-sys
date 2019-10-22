package com.marathon.service;

import com.marathon.MrtonProcEnum;
import com.marathon.domain.MarathonInfo;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.qvo.MrtonProcInfoVO;
import com.marathon.qvo.MyMrtonProcVO;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysUser;

import java.util.List;

/**
 * 赛事过程关系 服务层
 *
 * @author cuigq
 * @date 2019-10-08
 */
public interface IMrtonProcInfoService {
    /**
     * 查询赛事过程关系信息
     *
     * @param id 赛事过程关系ID
     * @return 赛事过程关系信息
     */
    public MrtonProcInfo selectMrtonProcInfoById(String id);

    /**
     * 查询赛事过程关系列表
     *
     * @param mrtonProcInfo 赛事过程关系信息
     * @return 赛事过程关系集合
     */
    public List<MrtonProcInfo> selectMrtonProcInfoList(MrtonProcInfo mrtonProcInfo);

    /**
     * 新增赛事过程关系
     *
     * @param mrtonProcInfo 赛事过程关系信息
     * @return 结果
     */
    public int insertMrtonProcInfo(MrtonProcInfo mrtonProcInfo);

    /**
     * 修改赛事过程关系
     *
     * @param mrtonProcInfo 赛事过程关系信息
     * @return 结果
     */
    public int updateMrtonProcInfo(MrtonProcInfo mrtonProcInfo);

    /**
     * 删除赛事过程关系信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrtonProcInfoByIds(String ids);

    /**
     * 查询赛事过程信息
     * @param marathonId
     * @return
     */
    List<MrtonProcInfoVO> selectMrtonProcs(String marathonId);

    /**
     * 根据赛事过程序号查询我的赛事列表
     * @param user 当前用户
     * @param mrtonProcEnum 赛事过程
     * @return
     */
    List<MarathonInfo> selectMyMrton(SysUser user, MrtonProcEnum mrtonProcEnum);


    /**
     * 根据赛事过程序号查询我的赛事列表
     * @param user 当前用户
     * @param mrtonProcEnum 赛事过程
     * @param marathonId
     * @return
     */
    List<MyMrtonProcVO> selectMyMrtonProc(SysUser user, MrtonProcEnum mrtonProcEnum, String marathonId);


    void buildMrtonMenu(SysUser sysUser, List<SysMenu> menus);

    /**
     * 保存自定义赛事任务
     * @param mrtonProcInfo
     */
    void addOrEditSave(MrtonProcInfo mrtonProcInfo);

    /**
     * 查询赛事任务
     * @param mrtonprocId
     * @return
     */
    MrtonProcInfo queryMrtonInfoById(String mrtonprocId);
}
