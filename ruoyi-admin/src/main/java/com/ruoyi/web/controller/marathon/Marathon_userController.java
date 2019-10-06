package com.ruoyi.web.controller.marathon;

import java.util.List;

import com.ruoyi.common.base.Ztree;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.marathon.domain.Marathon_info;
import com.ruoyi.marathon.domain.Marathon_user;
import com.ruoyi.marathon.service.IMarathon_userService;
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

/**
 * 赛事人员分配 信息操作处理
 *
 * @author marathon
 * @date 2019-08-19
 */
@Controller
@RequestMapping("/marathon/marathon_user")
public class Marathon_userController extends BaseController {
    private String prefix = "marathon/marathon_user" ;

    @Autowired
    private IMarathon_userService marathon_userService;

    @RequiresPermissions("marathon:marathon_user:view")
    @GetMapping()
    public String marathon_user() {
        return prefix + "/marathon_user" ;
    }

    /**
     * 查询赛事人员分配列表
     */
    @RequiresPermissions("marathon:marathon_user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Marathon_user marathon_user) {
        startPage();
        List<Marathon_user> list = marathon_userService.selectMarathon_userList(marathon_user);
        return getDataTable(list);
    }


    /**
     * 导出赛事人员分配列表
     */
    @RequiresPermissions("marathon:marathon_user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Marathon_user marathon_user) {
        List<Marathon_user> list = marathon_userService.selectMarathon_userList(marathon_user);
        ExcelUtil<Marathon_user> util = new ExcelUtil<Marathon_user>(Marathon_user. class);
        return util.exportExcel(list, "marathon_user");
    }

    /**
     * 新增赛事人员分配
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存赛事人员分配
     */
    @RequiresPermissions("marathon:marathon_user:add")
    @Log(title = "赛事人员分配" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Marathon_user marathon_user) {
        return toAjax(marathon_userService.insertMarathon_user(marathon_user));
    }

    /**
     * 修改赛事人员分配
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Marathon_user marathon_user =marathon_userService.selectMarathon_userById(id);
        mmap.put("marathon_user" , marathon_user);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存赛事人员分配
     */
    @RequiresPermissions("marathon:marathon_user:edit")
    @Log(title = "赛事人员分配" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Marathon_user marathon_user) {
        return toAjax(marathon_userService.updateMarathon_user(marathon_user));
    }

    /**
     * 删除赛事人员分配
     */
    @RequiresPermissions("marathon:marathon_user:remove")
    @Log(title = "赛事人员分配" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(marathon_userService.deleteMarathon_userByIds(ids));
    }

    /**
     * 加载部门人员列表树
     */
    @GetMapping("/marathonUserTreeData")
    @ResponseBody
    public List<Ztree> marathonUserTreeData(Marathon_info marathonInfo) {
        Long userId = ShiroUtils.getUserId();
        return marathon_userService.marathonUserTreeData(marathonInfo, userId);
    }


}
