package com.mton.web.controller.marathon;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.marathon.MrtonProcEnum;
import com.marathon.domain.MrtonProcCfg;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.qvo.MrtonProcCommonQVO;
import com.marathon.service.IMrtonProcCfgService;
import com.marathon.service.IMrtonProcInfoService;
import com.mton.common.base.AjaxResult;
import com.mton.framework.web.base.BaseController;
import com.mton.system.domain.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version MrtonSafeTyProcController, v0.1 2019/10/21 21:03
 * @description 安全防护Controller
 */
@Slf4j
@Controller
@RequestMapping("mrtonproc/safety")
@Api(tags = "安保任务")
public class MrtonSafeTyProcController extends BaseController {

    @Autowired
    private IMrtonProcCfgService mrtonProcCfgService;

    @Autowired
    private IMrtonProcInfoService mrtonProcInfoService;

    private String prefix = "marathon/procedure";

    @RequestMapping("/{marathonId}")
    public String safety(@PathVariable("marathonId") String marathonId, ModelMap modelMap) {
        modelMap.put("marathonId", marathonId);
        return prefix + "/safety/safetyprotection";
    }

    @GetMapping("/add/{marathonId}")
    @ApiOperation(value = "添加自定义任务")
    public String add(@PathVariable("marathonId") String marathonId, ModelMap modelMap) {
        MrtonProcInfo mrtonProcInfo = new MrtonProcInfo();
        mrtonProcInfo.setMarathonId(marathonId);

        MrtonProcCfg config = new MrtonProcCfg();
        config.setProcName(MrtonProcEnum.SAFTY_PROTECTION.getName());
//        List<MrtonProcCfg> lstSafetyProc = mrtonProcCfgService.selectMrtonProcCfgList(config);
        List<MrtonProcCfg> lstSafetyProc = null;
        Preconditions.checkArgument(lstSafetyProc.size() > 0, "没有安全防护任务的配置");
        mrtonProcInfo.setParentProcId(lstSafetyProc.get(0).getProcId());

        modelMap.put("mrtonProcInfo", mrtonProcInfo);
        return prefix + "/safety/add";
    }

    @GetMapping("/edit/{mrtonprocId}")
    @ApiOperation(value = "编辑任务")
    public String edit(@PathVariable("mrtonprocId") String mrtonprocId, ModelMap modelMap) {
        SysUser user = getSysUser();
        MrtonProcCommonQVO mrtonProcInfo = mrtonProcInfoService.queryMrtonInfoById(mrtonprocId, user.getUserId());

        modelMap.put("mrtonProcInfo", mrtonProcInfo);
        return prefix + "/safety/edit";
//        }
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(@RequestBody MrtonProcCommonQVO mrtonProcInfo) {

        Preconditions.checkArgument(!Strings.isNullOrEmpty(mrtonProcInfo.getProcName()), "安全防护-保存-任务名称不能为空");

        mrtonProcInfoService.addOrEditSave(mrtonProcInfo);

        return AjaxResult.success();
    }

    @RequestMapping("/remove/{mrtonprocId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("mrtonprocId") String mrtonProcId) {
        mrtonProcInfoService.deleteMrtonProcInfoByIds(mrtonProcId);
        return AjaxResult.success();
    }

}
