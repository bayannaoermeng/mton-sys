package com.marathon;


import com.google.common.collect.Lists;
import com.marathon.domain.MrtonProcCfg;
import com.marathon.service.IMrtonProcCfgService;
import com.marathon.service.IMrtonProcInfoService;
import com.mton.MrtonApplication;
import com.mton.system.service.ISysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version MrtonProcInfoServiceTest, v0.1 2019/10/8 16:53
 * @description 类说明
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MrtonApplication.class)
public class MrtonProcInfoServiceTest {

    @Autowired
    private IMrtonProcInfoService mrtonProcInfoService;

    @Autowired
    private ISysUserService sysUserService;

    @Test
    public void testGetProcs(){
        System.out.println(mrtonProcInfoService.selectMrtonProcs("2e4992b4-d958-4a1e-907e-a4ad58efd919"));
    }

    @Test
    public void testMapper(){
        List<Integer> lstUserId= Lists.newArrayList();
        lstUserId.add(1);
        lstUserId.add(2);
        System.out.println(sysUserService.selectUserListByIds(lstUserId));
    }
}
