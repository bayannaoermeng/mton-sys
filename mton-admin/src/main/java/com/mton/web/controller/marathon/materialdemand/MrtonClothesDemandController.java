package com.mton.web.controller.marathon.materialdemand;

import com.marathon.domain.MrtonClothesDemand;
import com.marathon.service.materialdemand.IMrtonClothesDemandService;
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
 * 服装需求 信息操作处理
 *
 * @author cuigq
 * @date 2020-06-23
 */
@Controller
@RequestMapping("/mrtonClothesDemand")
public class MrtonClothesDemandController extends BaseController {
    private String prefix = "marathon/mrtonClothesDemand";

    @Autowired
    private IMrtonClothesDemandService mrtonClothesDemandService;

    @RequiresPermissions("marathon:mrtonClothesDemand:list")
    @GetMapping("/init/{mrtonprocid}")
    public String mrtonClothesDemand(@PathVariable String mrtonprocid, ModelMap modelMap) {
        modelMap.put("procid", mrtonprocid);
        return prefix + "/mrtonClothesDemand";
    }

    /**
     * 查询服装需求列表
     */
    @RequiresPermissions("marathon:mrtonClothesDemand:list")
    @PostMapping("/list/{mrtonprocid}")
    @ResponseBody
    public TableDataInfo list(@PathVariable String mrtonprocid) {
        startPage();
        MrtonClothesDemand mrtonClothesDemand = new MrtonClothesDemand();
        mrtonClothesDemand.setProcId(mrtonprocid);
        List<MrtonClothesDemand> list = mrtonClothesDemandService.selectMrtonClothesDemandList(mrtonClothesDemand);
        return getDataTable(list);
    }


    /**
     * 导出服装需求列表
     */
    @RequiresPermissions("marathon:mrtonClothesDemand:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MrtonClothesDemand mrtonClothesDemand) {
        List<MrtonClothesDemand> list = mrtonClothesDemandService.selectMrtonClothesDemandList(mrtonClothesDemand);
        ExcelUtil<MrtonClothesDemand> util = new ExcelUtil<MrtonClothesDemand>(MrtonClothesDemand.class);
        return util.exportExcel(list, "mrtonClothesDemand");
    }

    /**
     * 新增服装需求
     */
    @GetMapping("/add/{mrtonprocid}")
    public String add(@PathVariable String mrtonprocid, ModelMap modelMap) {
        modelMap.put("mrtonprocid", mrtonprocid);
        return prefix + "/add";
    }

    /**
     * 新增保存服装需求
     */
    @RequiresPermissions("marathon:mrtonClothesDemand:add")
    @Log(title = "服装需求", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MrtonClothesDemand mrtonClothesDemand) {
        return toAjax(mrtonClothesDemandService.insertMrtonClothesDemand(mrtonClothesDemand));
    }

    /**
     * 修改服装需求
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        MrtonClothesDemand mrtonClothesDemand = mrtonClothesDemandService.selectMrtonClothesDemandById(id);
        mmap.put("mrtonClothesDemand", mrtonClothesDemand);
        return prefix + "/edit";
    }

    /**
     * 修改保存服装需求
     */
    @RequiresPermissions("marathon:mrtonClothesDemand:edit")
    @Log(title = "服装需求", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MrtonClothesDemand mrtonClothesDemand) {
        return toAjax(mrtonClothesDemandService.updateMrtonClothesDemand(mrtonClothesDemand));
    }

    /**
     * 删除服装需求
     */
    @RequiresPermissions("marathon:mrtonClothesDemand:remove")
    @Log(title = "服装需求", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(mrtonClothesDemandService.deleteMrtonClothesDemandByIds(ids));
    }

}
