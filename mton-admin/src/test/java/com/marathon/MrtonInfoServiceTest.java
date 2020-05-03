package com.marathon;


import com.marathon.domain.MarathonInfo;
import com.marathon.service.IMarathonInfoService;
import com.mton.MrtonApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cuiguangqiang
 * @version MrtonProcInfoServiceTest, v0.1 2019/10/8 16:53
 * @description 类说明
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MrtonApplication.class)
public class MrtonInfoServiceTest {

    @Autowired
    private IMarathonInfoService marathonInfoService;

    @Test
    public void testInitMrton(){

        MarathonInfo info = new MarathonInfo();
        info.setMarathon_name("测试事例");
        info.setMarathon_creater("1");

        marathonInfoService.insertMarathon_info(info);

    }

}
