package com.mton.web.controller.marathon;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.marathon.domain.MarathonUser;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.domain.MrtonProcUser;
import com.marathon.qvo.MrtonProcInfoVO;
import com.marathon.qvo.PrincipalBean;
import com.marathon.qvo.SaveProcPrincipalQO;
import com.marathon.service.IMarathonUserService;
import com.marathon.service.IMrtonProcInfoService;
import com.marathon.service.IMrtonProcUserService;
import com.mton.common.base.AjaxResult;
import com.mton.framework.web.base.BaseController;
import com.mton.system.domain.SysUser;
import com.mton.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author cuiguangqiang
 * @version MrtonProcUserController, v0.1 2019/10/14 17:57
 * @description 过程人员关系
 */
@Controller
@RequestMapping("/marathon/procuser")
public class MrtonProcUserController extends BaseController {

    private String prefix = "marathon/procuser" ;

    @Autowired
    private IMrtonProcInfoService mrtonProcInfoService;

    @Autowired
    private IMarathonUserService marathonUserService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IMrtonProcUserService mrtonProcUserService;


    /**
     * 任务分配人员
     * @param marathonId
     * @param mmap
     * @return
     */
    @GetMapping("/assign/{marathon_uuid}")
    public String assign(@PathVariable("marathon_uuid") String marathonId, ModelMap mmap){
        mmap.put("marathonId",marathonId);
        return prefix+"/assign";
    }


    //    @RequiresPermissions("marathon:marathon_info:proclist")
    @GetMapping("/proclist/{marathon_uuid}")
    @ResponseBody
    public List<MrtonProcInfoVO> procList(@PathVariable("marathon_uuid") String marathonId) {
        return mrtonProcInfoService.selectMrtonProcs(marathonId);
    }

    @GetMapping("/selectPrincipals")
    public String selectPrincipals(HttpServletRequest request, ModelMap mmap){
        String mrtonId=request.getParameter("mrtonId");
        String parentProcId=request.getParameter("procId");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(mrtonId) && !Strings.isNullOrEmpty(parentProcId),"参数不正确！");

        MrtonProcUser mrtonProcUser=new MrtonProcUser();
        mrtonProcUser.setMrtonId(mrtonId);
        mrtonProcUser.setParentProcId(parentProcId);
        List<MrtonProcUser> lstProcUser=mrtonProcUserService.selectMrtonProcUserList(mrtonProcUser);
        final List<String> lstPrincipals= Lists.transform(lstProcUser, new Function<MrtonProcUser, String>() {
            @Override
            public String apply(MrtonProcUser mrtonProcUser) {
                return String.valueOf(mrtonProcUser.getUserId());
            }
        });

        MarathonUser marathonUser=new MarathonUser();
        marathonUser.setMarathon_id(mrtonId);
        List<MarathonUser> lstMrthonUser=marathonUserService.selectMarathon_userList(marathonUser);
        List<Integer> lstMrthonUserId= Lists.transform(lstMrthonUser, new Function<MarathonUser, Integer>() {
            @Override
            public Integer apply(MarathonUser marathonUser) {
                return marathonUser.getUser_id();
            }
        });

        List<SysUser> lstUser=sysUserService.selectUserListByIds(lstMrthonUserId);

        List<PrincipalBean> result=Lists.transform(lstUser, new Function<SysUser, PrincipalBean>() {
            @Override
            public PrincipalBean apply(SysUser sysUser) {
                PrincipalBean bean=new PrincipalBean();
                bean.setUserId(sysUser.getUserId());
                bean.setUserName(sysUser.getUserName());
                bean.setChecked(lstPrincipals.contains(String.valueOf(sysUser.getUserId())));
                return bean;
            }
        });
        mmap.put("principals",result);
        mmap.put("procId",parentProcId);
        mmap.put("mrtonId",mrtonId);

        return prefix+"/selectPrincipals";
    }

    @RequestMapping("savaPrincipals")
    @ResponseBody
    public AjaxResult saveParincipals(SaveProcPrincipalQO qo){
        return mrtonProcUserService.saveProcPrincipals(qo);
    }

}
