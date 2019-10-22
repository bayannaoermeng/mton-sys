package com.ruoyi.web.controller.marathon;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.marathon.MrtonProcEnum;
import com.marathon.MrtonProcStatusEnum;
import com.marathon.domain.MarathonInfo;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.qvo.MyMrtonProcQO;
import com.marathon.qvo.MyMrtonProcVO;
import com.marathon.service.IMrtonProcInfoService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

/**
 * @author cuiguangqiang
 * @version MrtonProcController, v0.1 2019/10/16 9:16
 * @description 类说明
 */

@Slf4j
@Controller
@RequestMapping("marathon/mrtonproc")
public class MrtonProcController extends BaseController {

    @Autowired
    private IMrtonProcInfoService mrtonProcInfoService;


    /**
     * 根据赛事过程序号查询我的赛事列表
     * @param procSeq
     * @return
     */
    @GetMapping
    @RequestMapping("/mymrtonlist/{procSequence}")
    @ResponseBody
    public AjaxResult listMyMarathon(@PathVariable("procSequence") String procSeq ){

        SysUser user=getSysUser();

        MrtonProcEnum mrtonProcEnum=MrtonProcEnum.getValue(Integer.valueOf(procSeq));

        List<MarathonInfo> lstMyMrton=mrtonProcInfoService.selectMyMrton(user,mrtonProcEnum);

        return AjaxResult.success(lstMyMrton);
    }

    /**
     * 根据赛事过程序号查询我的赛事任务列表
     * @param qo
     * @return
     */
    @PostMapping
    @RequestMapping("/mymrtonproc")
    @ResponseBody
    public TableDataInfo listMyMrtonProc(MyMrtonProcQO qo){
        startPage();

        SysUser user=getSysUser();

        MrtonProcEnum mrtonProcEnum=MrtonProcEnum.getValue(qo.getProcSequence());

        String marathonId=qo.getMarathonId();

        Preconditions.checkArgument(!Strings.isNullOrEmpty(marathonId),"请求参数不能为空");

        List<MyMrtonProcVO> lstMyMrtonProc=mrtonProcInfoService.selectMyMrtonProc(user,mrtonProcEnum,marathonId);

        return getDataTable(lstMyMrtonProc);
    }

    /**
     * 启动任务
     * @param mrtonprocId
     * @return
     */
    @GetMapping
    @RequestMapping("/start/{mrtonprocId}")
    @ResponseBody
    public AjaxResult startProc(@PathVariable("mrtonprocId") String mrtonprocId){

        MrtonProcInfo mrtonProcInfo=new MrtonProcInfo();
        mrtonProcInfo.setId(mrtonprocId);
        mrtonProcInfo.setStatus(MrtonProcStatusEnum.STATUS_RUNNING.getKey());
        mrtonProcInfo.setReserve1(String.valueOf(getUserId()));
        mrtonProcInfo.setRealStarttime(Calendar.getInstance().getTime());

        mrtonProcInfoService.updateMrtonProcInfo(mrtonProcInfo);

        return AjaxResult.success();
    }

    /**
     * 结束任务
     * @param mrtonprocId
     * @return
     */
    @GetMapping
    @RequestMapping("/finish/{mrtonprocId}")
    @ResponseBody
    public AjaxResult finishProc(@PathVariable("mrtonprocId") String mrtonprocId){

        MrtonProcInfo mrtonProcInfo=new MrtonProcInfo();
        mrtonProcInfo.setId(mrtonprocId);
        mrtonProcInfo.setStatus(MrtonProcStatusEnum.FINISH.getKey());
        mrtonProcInfo.setReserve1(String.valueOf(getUserId()));
        mrtonProcInfo.setRealEndtime(Calendar.getInstance().getTime());

        mrtonProcInfoService.updateMrtonProcInfo(mrtonProcInfo);

        return AjaxResult.success();
    }
}
