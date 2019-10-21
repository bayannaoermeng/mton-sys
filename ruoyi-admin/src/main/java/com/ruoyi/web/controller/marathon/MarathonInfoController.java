package com.ruoyi.web.controller.marathon;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.marathon.domain.MarathonUser;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.domain.MrtonProcUser;
import com.marathon.qvo.MrtonProcInfoVO;
import com.marathon.qvo.PrincipalBean;
import com.marathon.service.IMarathonUserService;
import com.marathon.service.IMrtonProcInfoService;
import com.marathon.service.IMrtonProcUserService;
import com.ruoyi.framework.util.ShiroUtils;
import com.marathon.domain.MarathonInfo;
import com.marathon.service.IMarathonInfoService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo ;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

import javax.websocket.server.PathParam;

/**
 * 赛事 信息操作处理
 *
 * @author marathon
 * @date 2019-08-17
 */
@Controller
@RequestMapping("/marathon/marathon_info")
public class MarathonInfoController extends BaseController {
    private String prefix = "marathon/info" ;

    @Autowired
    private IMarathonInfoService marathonInfoService;


    @RequiresPermissions("marathon:marathon_info:view")
    @GetMapping()
    public String marathon_info() {
        return prefix + "/marathon_info" ;
    }

    /**
     * 查询赛事列表
     */
    @RequiresPermissions("marathon:marathon_info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MarathonInfo marathon_info) {
        startPage();
        List<MarathonInfo> list = marathonInfoService.selectMarathon_infoList(marathon_info);
        return getDataTable(list);
    }


    /**
     * 导出赛事列表
     */
    @RequiresPermissions("marathon:marathon_info:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MarathonInfo marathon_info) {
        List<MarathonInfo> list = marathonInfoService.selectMarathon_infoList(marathon_info);
        ExcelUtil<MarathonInfo> util = new ExcelUtil<MarathonInfo>(MarathonInfo. class);
        return util.exportExcel(list, "marathon_info");
    }

    /**
     * 新增赛事
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存赛事
     */
    @RequiresPermissions("marathon:marathon_info:add")
    @Log(title = "赛事" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MarathonInfo marathon_info) {
        marathon_info.setMarathon_creater(String.valueOf(ShiroUtils.getUserId()));
        marathon_info.setMarathon_updater(String.valueOf(ShiroUtils.getUserId()));
        return toAjax(marathonInfoService.insertMarathon_info(marathon_info));
    }

    /**
     * 修改赛事
     */
    @GetMapping("/edit/{marathon_uuid}")
    public String edit(@PathVariable("marathon_uuid") String marathon_uuid, ModelMap mmap) {
        MarathonInfo marathon_info = marathonInfoService.selectMarathon_infoById(marathon_uuid);
        mmap.put("marathon_info" , marathon_info);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存赛事
     */
    @RequiresPermissions("marathon:marathon_info:edit")
    @Log(title = "赛事" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MarathonInfo marathon_info) {
        marathon_info.setMarathon_updater(String.valueOf(ShiroUtils.getUserId()));
        return toAjax(marathonInfoService.updateMarathon_info(marathon_info));
    }

    /**
     * 删除赛事
     */
    @RequiresPermissions("marathon:marathon_info:remove")
    @Log(title = "赛事" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(marathonInfoService.deleteMarathon_infoByIds(ids));
    }
}
