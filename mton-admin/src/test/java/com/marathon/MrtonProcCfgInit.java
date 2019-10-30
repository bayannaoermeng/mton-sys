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
public class MrtonProcCfgInit {

    @Autowired
    private IMrtonProcCfgService mrtonProcCfgService;

    String[] proc={"了解赛事，确定赛事规模",
            "组委会会议初次碰头",
            "实地勘察场地，了解赛事各项规划措施",
            "形成安保建议方案（公安+交警）",
            "约公安交警现场碰头汇报各项方案",
            "主动询问公安交警的意见反馈",
            "筹备过程中多沟通，对外信息的公告",
            "证件盖章",
            "安保演练",
            "赛时安全保障",
            "赛后安保意见反馈"};

    @Test
    public void initMrtonProcCfg(){

        MrtonProcCfg cfg=new MrtonProcCfg();
        String parentUUID=UUID.randomUUID().toString();
        cfg.setProcId(parentUUID);
        cfg.setProcName("安保");
        mrtonProcCfgService.insertMrtonProcCfg(cfg);

    }

    @Test
    public void initMrtonProcCfg_(){
        Arrays.asList(proc).forEach(proc->{
            MrtonProcCfg cfg=new MrtonProcCfg();
            cfg.setProcId(UUID.randomUUID().toString());
            cfg.setParentProcId("ac5905fb-ec57-4e22-8a38-75edc6063378");
            cfg.setProcName(proc);

            mrtonProcCfgService.insertMrtonProcCfg(cfg);

        });
    }
}
