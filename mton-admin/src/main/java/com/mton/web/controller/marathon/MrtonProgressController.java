package com.mton.web.controller.marathon;

import com.marathon.qvo.MrtonProgDetailVO;
import com.marathon.service.IMrtonProgressService;
import com.mton.common.base.AjaxResult;
import com.mton.framework.web.base.BaseController;
import com.mton.system.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version MrtonProgressController, v0.1 2019/10/23 15:21
 * @description 赛事进度监控Controller
 */
@Slf4j
@Controller
@RequestMapping("mrtonprogress")
public class MrtonProgressController extends BaseController {

    private final String prefix="marathon/monitor";

    @Autowired
    private IMrtonProgressService mrtonProgressService;

    @RequestMapping("/index")
    public String index(){
        return prefix + "/mrtonprogress";
    }

    /**
     * 我创建的赛事进度监控
     * @return
     */
    @GetMapping("/mymrtonprgdetail")
    @ResponseBody
    public AjaxResult myMrtonPrgDetail(){

        SysUser user=getSysUser();

        List<MrtonProgDetailVO> lstMrtonProgDetail=mrtonProgressService.getMyMrtonProgDetail(user);

        return AjaxResult.success(lstMrtonProgDetail);
    }
}
