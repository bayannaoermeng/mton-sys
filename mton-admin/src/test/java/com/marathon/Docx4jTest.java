package com.marathon;


import com.marathon.service.office.Docx4jTemplate;
import com.marathon.service.office.WordToolService;
import com.marathon.service.office.impl.WordToolServiceImpl;
import com.mton.MrtonApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cuiguangqiang
 * @version MrtonProcCfgInit, v0.1 2019/10/8 16:53
 * @description 类说明
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MrtonApplication.class)
public class Docx4jTest {

    @Autowired
    private WordToolServiceImpl wordToolService;

    @Test
    public void test(){
    }

    @Test
    public void testInit(){
        Docx4jTemplate template = new Docx4jTemplate();
        try {
            template.replaceTemplateDocx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
