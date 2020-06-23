package com.mton.web.controller.marathon.materialdemand;

import com.marathon.domain.MrtonFoodDemand;
import com.marathon.service.materialdemand.IMrtonFoodDemandService;
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
 * 餐饮需求 信息操作处理
 *
 * @author cuigq
 * @date 2020-06-23
 */
@Controller
@RequestMapping("/mrtonFoodDemand")
public class MrtonFoodDemandController extends BaseController {
    private String prefix = "marathon/mrtonFoodDemand" ;

    @Autowired
    private IMrtonFoodDemandService mrtonFoodDemandService;

    @RequiresPermissions("marathon:mrtonFoodDemand:view")
    @GetMapping("/init/{mrtonprocid}")
    public String mrtonFoodDemand(@PathVariable String mrtonprocid, ModelMap modelMap) {
        modelMap.put("procid", mrtonprocid);
        return prefix + "/mrtonFoodDemand" ;
    }

    /**
     * 查询餐饮需求列表
     */
    @RequiresPermissions("marathon:mrtonFoodDemand:list")
    @PostMapping("/list/{mrtonprocid}")
    @ResponseBody
    public TableDataInfo list(@PathVariable String mrtonprocid) {
        startPage();
        MrtonFoodDemand mrtonFoodDemand = new MrtonFoodDemand();
        mrtonFoodDemand.setProcId(mrtonprocid);
        List<MrtonFoodDemand> list = mrtonFoodDemandService.selectMrtonFoodDemandList(mrtonFoodDemand);
        return getDataTable(list);
    }


    /**
     * 导出餐饮需求列表
     */
    @RequiresPermissions("marathon:mrtonFoodDemand:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MrtonFoodDemand mrtonFoodDemand) {
        List<MrtonFoodDemand> list = mrtonFoodDemandService.selectMrtonFoodDemandList(mrtonFoodDemand);
        ExcelUtil<MrtonFoodDemand> util = new ExcelUtil<MrtonFoodDemand>(MrtonFoodDemand. class);
        return util.exportExcel(list, "mrtonFoodDemand");
    }

    /**
     * 新增餐饮需求
     */
    @GetMapping("/add/{mrtonprocid}")
    public String add(@PathVariable String mrtonprocid, ModelMap modelMap) {
        modelMap.put("mrtonprocid",mrtonprocid);
        return prefix + "/add" ;
    }

    /**
     * 新增保存餐饮需求
     */
    @RequiresPermissions("marathon:mrtonFoodDemand:add")
    @Log(title = "餐饮需求" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MrtonFoodDemand mrtonFoodDemand) {
        return toAjax(mrtonFoodDemandService.insertMrtonFoodDemand(mrtonFoodDemand));
    }

    /**
     * 修改餐饮需求
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        MrtonFoodDemand mrtonFoodDemand =mrtonFoodDemandService.selectMrtonFoodDemandById(id);
        mmap.put("mrtonFoodDemand" , mrtonFoodDemand);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存餐饮需求
     */
    @RequiresPermissions("marathon:mrtonFoodDemand:edit")
    @Log(title = "餐饮需求" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MrtonFoodDemand mrtonFoodDemand) {
        return toAjax(mrtonFoodDemandService.updateMrtonFoodDemand(mrtonFoodDemand));
    }

    /**
     * 删除餐饮需求
     */
    @RequiresPermissions("marathon:mrtonFoodDemand:remove")
    @Log(title = "餐饮需求" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(mrtonFoodDemandService.deleteMrtonFoodDemandByIds(ids));
    }

}
