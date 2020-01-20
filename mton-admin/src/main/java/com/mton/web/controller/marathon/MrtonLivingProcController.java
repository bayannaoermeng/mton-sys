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
 * @version MrtonLivingProcController, v0.1 2019/10/21 21:03
 * @description 直播Controller
 */
@Slf4j
@Controller
@RequestMapping("mrtonproc/living")
public class MrtonLivingProcController extends BaseController {

    @Autowired
    private IMrtonProcCfgService mrtonProcCfgService;

    @Autowired
    private IMrtonProcInfoService mrtonProcInfoService;

    private String prefix = "marathon/procedure" ;

    @RequestMapping("/{marathonId}")
    public String safety(@PathVariable("marathonId") String marathonId, ModelMap modelMap){
        modelMap.put("marathonId",marathonId);
        return prefix + "/living/living";
    }

    @RequestMapping("/add/{marathonId}")
    public String add(@PathVariable("marathonId") String marathonId, ModelMap modelMap){
        MrtonProcInfo mrtonProcInfo=new MrtonProcInfo();
        mrtonProcInfo.setMarathonId(marathonId);

        MrtonProcCfg config=new MrtonProcCfg();
        config.setProcName(MrtonProcEnum.LIVING_PRO.getName());
        List<MrtonProcCfg> lstSafetyProc=mrtonProcCfgService.selectMrtonProcCfgList(config);
        Preconditions.checkArgument(lstSafetyProc.size()>0,"没有直播任务的配置");
        mrtonProcInfo.setParentProcId(lstSafetyProc.get(0).getProcId());

        modelMap.put("mrtonProcInfo",mrtonProcInfo);
        return prefix + "/living/add";
    }

    @RequestMapping("/edit/{mrtonprocId}")
    public String edit(@PathVariable("mrtonprocId") String mrtonprocId,ModelMap modelMap){
        MrtonProcCommonQVO mrtonProcInfo=mrtonProcInfoService.queryMrtonInfoById(mrtonprocId);
        modelMap.put("mrtonProcInfo",mrtonProcInfo);
        return prefix + "/living/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(MrtonProcInfo mrtonProcInfo){

        if(Strings.isNullOrEmpty(mrtonProcInfo.getId())){
            Preconditions.checkArgument(!Strings.isNullOrEmpty(mrtonProcInfo.getMarathonId()),"直播-保存-赛事ID不能为空");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(mrtonProcInfo.getParentProcId()),"直播-保存-父任务ID不能为空");
        }

        Preconditions.checkArgument(!Strings.isNullOrEmpty(mrtonProcInfo.getProcName()),"直播-保存-任务名称不能为空");

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
