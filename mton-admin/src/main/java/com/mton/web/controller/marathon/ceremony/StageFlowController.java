package com.mton.web.controller.marathon.ceremony;

import com.marathon.domain.MrtonStageFlow;
import com.marathon.service.ceremony.IStageFlowService;
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
 * 主舞台流程 信息操作处理
 *
 * @author cuigq
 * @date 2020-05-24
 */
@Controller
@RequestMapping("/stageflow")
public class StageFlowController extends BaseController {
    private String prefix = "marathon/stageflow" ;

    @Autowired
    private IStageFlowService stageFlowService;


    @RequiresPermissions("marathon:mrtonStageFlow:list")
    @GetMapping("/init/{mrtonprocid}")
    public String init(@PathVariable String mrtonprocid, ModelMap modelMap) {
        modelMap.put("procid", mrtonprocid);
        return prefix + "/stageflow" ;
    }

    /**
     * 查询主舞台流程列表
     */
    @RequiresPermissions("marathon:mrtonStageFlow:list")
    @PostMapping("/list/{mrtonprocid}")
    @ResponseBody
    public TableDataInfo list(@PathVariable String mrtonprocid) {
        startPage();
        MrtonStageFlow mrtonStageFlow = new MrtonStageFlow();
        mrtonStageFlow.setProcId(mrtonprocid);
        List<MrtonStageFlow> list = stageFlowService.selectMrtonStageFlowList(mrtonStageFlow);
        return getDataTable(list);
    }


    /**
     * 导出主舞台流程列表
     */
    @RequiresPermissions("marathon:mrtonStageFlow:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MrtonStageFlow mrtonStageFlow) {
        List<MrtonStageFlow> list = stageFlowService.selectMrtonStageFlowList(mrtonStageFlow);
        ExcelUtil<MrtonStageFlow> util = new ExcelUtil<MrtonStageFlow>(MrtonStageFlow.class);
        return util.exportExcel(list, "mrtonStageFlow");
    }

    /**
     * 新增主舞台流程
     */
    @GetMapping("/add/{mrtonprocid}")
    public String add(@PathVariable String mrtonprocid, ModelMap modelMap) {
        modelMap.put("mrtonprocid",mrtonprocid);
        return prefix + "/add" ;
    }

    /**
     * 新增保存主舞台流程
     */
    @RequiresPermissions("marathon:mrtonStageFlow:add")
    @Log(title = "主舞台流程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MrtonStageFlow mrtonStageFlow) {
        return toAjax(stageFlowService.insertMrtonStageFlow(mrtonStageFlow));
    }

    /**
     * 修改主舞台流程
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        MrtonStageFlow mrtonStageFlow = stageFlowService.selectMrtonStageFlowById(id);
        mmap.put("mrtonStageFlow", mrtonStageFlow);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存主舞台流程
     */
    @RequiresPermissions("marathon:mrtonStageFlow:edit")
    @Log(title = "主舞台流程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MrtonStageFlow mrtonStageFlow) {
        return toAjax(stageFlowService.updateMrtonStageFlow(mrtonStageFlow));
    }

    /**
     * 删除主舞台流程
     */
    @RequiresPermissions("marathon:mrtonStageFlow:remove")
    @Log(title = "主舞台流程", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(stageFlowService.deleteMrtonStageFlowByIds(ids));
    }

}
