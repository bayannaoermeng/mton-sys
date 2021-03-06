package com.mton.web.controller.system;

import com.marathon.service.IMrtonProcInfoService;
import com.marathon.service.IMrtonProcUserService;
import com.mton.common.annotation.LoginAuth;
import com.mton.common.config.Global;
import com.mton.framework.web.base.BaseController;
import com.mton.system.domain.SysMenu;
import com.mton.system.domain.SysUser;
import com.mton.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 首页 业务处理
 *
 * @author mton
 */
@Controller
@LoginAuth
public class SysIndexController extends BaseController {

    private final ISysMenuService menuService;

    @Autowired
    private IMrtonProcInfoService mrtonProcInfoService;

    @Autowired
    public SysIndexController(ISysMenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 系统首页
     *
     * @param mmap ModelMap
     * @return
     */
    @GetMapping("/index")
    public String index(ModelMap mmap,SysUser sysUser) {
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(sysUser);
        mrtonProcInfoService.buildMrtonMenu(sysUser,menus);

        mmap.put("menus", menus);
        mmap.put("user", sysUser);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        return "index";
    }


    /**
     * 系统介绍
     *
     * @param mmap ModelMap
     * @return
     */
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
        mmap.put("version", Global.getVersion());
        return "main";
    }

    /**
     * 统计模版首页
     *
     * @param mmap ModelMap
     * @return
     */
    @GetMapping("/system/mainV1")
    public String mainV1(ModelMap mmap) {
        mmap.put("version", Global.getVersion());
        return "main_v1";
    }
}
