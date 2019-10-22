package com.ruoyi.web.controller.marathon;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.marathon.MrtonProcEnum;
import com.marathon.domain.MrtonProcCfg;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.service.IMrtonProcCfgService;
import com.marathon.service.IMrtonProcInfoService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.framework.web.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version MrtonSafeTyProcController, v0.1 2019/10/21 21:03
 * @description 安全防护Controller
 */
@Slf4j
@Controller
@RequestMapping("mrtonproc/safety")
public class MrtonSafeTyProcController extends BaseController {

    @Autowired
    private IMrtonProcCfgService mrtonProcCfgService;

    @Autowired
    private IMrtonProcInfoService mrtonProcInfoService;

    private String prefix = "marathon/procedure" ;

    @RequestMapping("/{marathonId}")
    public String safety(@PathVariable("marathonId") String marathonId, ModelMap modelMap){
        modelMap.put("marathonId",marathonId);
        return prefix + "/safety/safetyprotection";
    }

    @RequestMapping("/add/{marathonId}")
    public String add(@PathVariable("marathonId") String marathonId, ModelMap modelMap){
        MrtonProcInfo mrtonProcInfo=new MrtonProcInfo();
        mrtonProcInfo.setMarathonId(marathonId);

        MrtonProcCfg config=new MrtonProcCfg();
        config.setProcName(MrtonProcEnum.SAFTY_PROTECTION.getName());
        List<MrtonProcCfg> lstSafetyProc=mrtonProcCfgService.selectMrtonProcCfgList(config);
        Preconditions.checkArgument(lstSafetyProc.size()>0,"没有安全防护任务的配置");
        mrtonProcInfo.setParentProcId(lstSafetyProc.get(0).getProcId());

        modelMap.put("mrtonProcInfo",mrtonProcInfo);
        return prefix + "/safety/add";
    }

    @RequestMapping("/edit/{mrtonprocId}")
    public String edit(@PathVariable("mrtonprocId") String mrtonprocId,ModelMap modelMap){
        MrtonProcInfo mrtonProcInfo=mrtonProcInfoService.queryMrtonInfoById(mrtonprocId);
        modelMap.put("mrtonProcInfo",mrtonProcInfo);
        return prefix + "/safety/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(MrtonProcInfo mrtonProcInfo){

        if(Strings.isNullOrEmpty(mrtonProcInfo.getId())){
            Preconditions.checkArgument(!Strings.isNullOrEmpty(mrtonProcInfo.getMarathonId()),"安全防护-保存-赛事ID不能为空");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(mrtonProcInfo.getParentProcId()),"安全防护-保存-父任务ID不能为空");
        }

        Preconditions.checkArgument(!Strings.isNullOrEmpty(mrtonProcInfo.getProcName()),"安全防护-保存-任务名称不能为空");

        mrtonProcInfoService.addOrEditSave(mrtonProcInfo);
        return AjaxResult.success();
    }

    @RequestMapping("/remove/{mrtonprocId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("mrtonprocId") String mrtonProcId){
        mrtonProcInfoService.deleteMrtonProcInfoByIds(mrtonProcId);
        return AjaxResult.success();
    }

}
