package com.mton.web.controller.monitor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mton.framework.web.base.BaseController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * druid 监控
 *
 * @author mton
 */
@Controller
@RequestMapping("/monitor/data")
@ApiIgnore(value = "druid数据源监控")
public class DruidController extends BaseController {

    @RequiresPermissions("monitor:data:view")
    @GetMapping()
    public String index() {
        String url = "/monitor/druid/index";
        return redirect(url);
    }
}
