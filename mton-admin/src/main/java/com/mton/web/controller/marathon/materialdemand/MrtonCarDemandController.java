package com.mton.web.controller.marathon.materialdemand;

import com.marathon.domain.MrtonCarDemand;
import com.marathon.service.materialdemand.IMrtonCarDemandService;
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
 * 车辆需求 信息操作处理
 *
 * @author cuigq
 * @date 2020-06-23
 */
@Controller
@RequestMapping("/marathon/mrtonCarDemand")
public class MrtonCarDemandController extends BaseController {
    private String prefix = "marathon/mrtonCarDemand" ;

    @Autowired
    private IMrtonCarDemandService mrtonCarDemandService;

    @RequiresPermissions("marathon:mrtonCarDemand:view")
    @GetMapping()
    public String mrtonCarDemand() {
        return prefix + "/mrtonCarDemand" ;
    }

    /**
     * 查询车辆需求列表
     */
    @RequiresPermissions("marathon:mrtonCarDemand:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MrtonCarDemand mrtonCarDemand) {
        startPage();
        List<MrtonCarDemand> list = mrtonCarDemandService.selectMrtonCarDemandList(mrtonCarDemand);
        return getDataTable(list);
    }


    /**
     * 导出车辆需求列表
     */
    @RequiresPermissions("marathon:mrtonCarDemand:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MrtonCarDemand mrtonCarDemand) {
        List<MrtonCarDemand> list = mrtonCarDemandService.selectMrtonCarDemandList(mrtonCarDemand);
        ExcelUtil<MrtonCarDemand> util = new ExcelUtil<MrtonCarDemand>(MrtonCarDemand. class);
        return util.exportExcel(list, "mrtonCarDemand");
    }

    /**
     * 新增车辆需求
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存车辆需求
     */
    @RequiresPermissions("marathon:mrtonCarDemand:add")
    @Log(title = "车辆需求" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MrtonCarDemand mrtonCarDemand) {
        return toAjax(mrtonCarDemandService.insertMrtonCarDemand(mrtonCarDemand));
    }

    /**
     * 修改车辆需求
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        MrtonCarDemand mrtonCarDemand =mrtonCarDemandService.selectMrtonCarDemandById(id);
        mmap.put("mrtonCarDemand" , mrtonCarDemand);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存车辆需求
     */
    @RequiresPermissions("marathon:mrtonCarDemand:edit")
    @Log(title = "车辆需求" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MrtonCarDemand mrtonCarDemand) {
        return toAjax(mrtonCarDemandService.updateMrtonCarDemand(mrtonCarDemand));
    }

    /**
     * 删除车辆需求
     */
    @RequiresPermissions("marathon:mrtonCarDemand:remove")
    @Log(title = "车辆需求" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(mrtonCarDemandService.deleteMrtonCarDemandByIds(ids));
    }

}
