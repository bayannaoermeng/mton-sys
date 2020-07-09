package com.mton.web.controller.marathon.ceremony;

import com.google.common.collect.Lists;
import com.marathon.domain.Mrton3PartyStaff;
import com.marathon.domain.Mrton3PartyStaffExample;
import com.marathon.qvo.ceremony.Mrton3PartyStaffApproveInfoVO;
import com.marathon.qvo.ceremony.Mrton3PartyStaffVO;
import com.marathon.service.thirdpartystaff.IMrton3PartyStaffService;
import com.mton.common.annotation.Log;
import com.mton.common.base.AjaxResult;
import com.mton.common.enums.BusinessType;
import com.mton.common.page.TableDataInfo;
import com.mton.common.utils.ExcelUtil;
import com.mton.framework.web.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version AnchorDemandController, v0.1 2020/5/15 16:02
 * @description 主持人需求
 */
@Controller
@RequestMapping("ceremony/anchor")
public class AnchorDemandController extends BaseController {

    private String prefix = "marathon/anchor";

    @Autowired
    private IMrton3PartyStaffService staffService;


    @RequiresPermissions("marathon:mrton3PartyStaff:view")
    @GetMapping("/init/{mrtonprocid}")
    public String mrton3PartyStaff(@PathVariable String mrtonprocid, ModelMap modelMap) {
        try {
            staffService.checkApproved(mrtonprocid);
            modelMap.put("procid", mrtonprocid);
            return prefix + "/anchor";
        } catch (Exception e) {
            Mrton3PartyStaffApproveInfoVO vo = staffService.selectApproveInfo(mrtonprocid);
            modelMap.put("staffApproveInfo",vo);
            return prefix + "/approveinfo";

        }
    }

    /**
     * 查询仪式主持人需求列表
     */
    @RequiresPermissions("marathon:mrton3PartyStaff:view")
    @RequestMapping("/list/{procid}")
    @ResponseBody
    public TableDataInfo list(@PathVariable() String procid) {
        startPage();
        List<Mrton3PartyStaffVO> list = staffService.selectByProcId(procid);
        return getDataTable(list);
    }


    /**
     * 导出仪式主持人需求列表
     */
    @RequiresPermissions("marathon:mrton3PartyStaff:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Mrton3PartyStaff mrton3PartyStaff) {
        List<Mrton3PartyStaff> list = Lists.newArrayList();
        ExcelUtil<Mrton3PartyStaff> util = new ExcelUtil<Mrton3PartyStaff>(Mrton3PartyStaff.class);
        return util.exportExcel(list, "mrton3PartyStaff");
    }

    /**
     * 新增仪式主持人需求
     */
    @GetMapping("/add/{mrtonprocid}")
    public String add(@PathVariable String mrtonprocid, ModelMap modelMap) {
        modelMap.put("mrtonprocid", mrtonprocid);
        return prefix + "/add";
    }

    /**
     * 新增保存仪式主持人需求
     */
    @RequiresPermissions("marathon:mrton3PartyStaff:add")
    @Log(title = "仪式主持人需求", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Mrton3PartyStaff mrton3PartyStaff) {
        return toAjax(staffService.insertMrton3PartyStaff(mrton3PartyStaff));
    }

    /**
     * 修改仪式主持人需求
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Mrton3PartyStaffVO mrton3PartyStaff = staffService.selectMrton3PartyStaffById(id);
        mmap.put("mrton3PartyStaff", mrton3PartyStaff);
        return prefix + "/edit";
    }

    /**
     * 修改保存仪式主持人需求
     */
    @RequiresPermissions("marathon:mrton3PartyStaff:edit")
    @Log(title = "仪式主持人需求", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Mrton3PartyStaff mrton3PartyStaff) {
        return toAjax(staffService.updateMrton3PartyStaff(mrton3PartyStaff));
    }

    /**
     * 删除仪式主持人需求
     */
    @RequiresPermissions("marathon:mrton3PartyStaff:remove")
    @Log(title = "仪式主持人需求", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(staffService.deleteMrton3PartyStaffByIds(ids));
    }


    @RequiresPermissions("marathon:mrton3PartyStaff:view")
    @GetMapping("/staffDetail/{id}")
    public String staffDetail(@PathVariable String id, ModelMap modelMap) {
        Mrton3PartyStaff staff = staffService.selectMrton3PartyStaffById(Integer.parseInt(id));
        if (staff != null) {
            modelMap.put("staffDetail", staff.getStaffDetail());
        }
        return prefix + "/staffDetail";
    }

    /**
     * 置为供应商
     *
     * @param id
     * @return
     */
    @RequestMapping("/master/{id}")
    @ResponseBody
    public AjaxResult master(@PathVariable String id) {
        staffService.setMaster(id);
        return AjaxResult.success("成功");
    }

    /**
     * 提交申批
     *
     * @param procId 任务ID
     * @return
     */
    @RequestMapping("/apply/{procId}")
    @ResponseBody
    public AjaxResult apply(@PathVariable String procId) {

        Long userId = getUserId();

        staffService.apply(procId,userId);

        return AjaxResult.success();

    }


}
