package com.marathon;


import com.marathon.service.docx4j.Docx4jTempateServiceImpl;
import com.marathon.service.docx4j.Docx4jTemplate;
import com.marathon.service.office.Word2PdfService;
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

    @Test
    public void testAwardsPlan() throws Exception {
        Docx4jTempateServiceImpl test = new Docx4jTempateServiceImpl();
        test.replaceTemplateDocx();
    }

    @Test
    public void testWord2PdfService(){
        try {
            System.out.println(Word2PdfService.convert("D:\\mrton\\document\\测试20200504\\起跑仪式方案\\sys_1589111015298.docx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
