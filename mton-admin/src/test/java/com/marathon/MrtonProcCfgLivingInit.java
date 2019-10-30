package com.marathon;


import com.marathon.domain.MrtonProcCfg;
import com.marathon.service.IMrtonProcCfgService;
import com.mton.MrtonApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author cuiguangqiang
 * @version MrtonProcCfgInit, v0.1 2019/10/8 16:53
 * @description 类说明
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MrtonApplication.class)
public class MrtonProcCfgLivingInit {

    @Autowired
    private IMrtonProcCfgService mrtonProcCfgService;

    String[] proc = {"赛事基本信息了解",
            "赛道勘察，确定微波点，形成考察报告",
            "宣传片素材",
            "赛事直播-主会场 ",
            "赛事直播-赛道 ",
            "赛事直播-流量卡 ",
            "赛事直播-解说素材 ",
            "赛事直播-直播摩托车 ",
            "赛事直播-直播吊机 ",
            "赛事直播-无人机报备 ",
            "赛事直播-机顶盒安装 ",
            "赛事直播-证件 ",
            "赛后总结"
    };

    @Test
    public void initMrtonProcCfg() {

        MrtonProcCfg cfg = new MrtonProcCfg();
        String parentUUID = UUID.randomUUID().toString();
        cfg.setProcId(parentUUID);
        cfg.setProcName("直播");
        mrtonProcCfgService.insertMrtonProcCfg(cfg);

    }

    @Test
    public void initMrtonProcCfg_() {
        Arrays.asList(proc).forEach(proc -> {
            MrtonProcCfg cfg = new MrtonProcCfg();
            cfg.setProcId(UUID.randomUUID().toString());
            cfg.setParentProcId("d1cd2b5f-630d-438c-b483-19b8c6cf5fdb");
            cfg.setProcName(proc);

            mrtonProcCfgService.insertMrtonProcCfg(cfg);

        });
    }
}
