package com.marathon.service.docx4j;

import com.marathon.qvo.ceremony.AwardsPlan;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.docx4j.XmlUtils;
import org.docx4j.dml.chart.*;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.DrawingML.Chart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.openpackaging.parts.relationships.Namespaces;
import org.docx4j.openpackaging.parts.relationships.RelationshipsPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Docx4jTempateServiceImpl {
    private String inputfilepath = "D:\\profile\\upload\\template\\10.1.2颁奖仪式方案.docx";
    private static final String outputfilepath = "D:/sys_" + System.currentTimeMillis() + ".docx";
    public static org.docx4j.wml.ObjectFactory factory = Context.getWmlObjectFactory();


    public void replaceTemplateDocx() throws Exception {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(inputfilepath));

        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        Map<String, String> staticMap = getStaticData();

        // 替换普通变量
        documentPart.variableReplace(staticMap);
        // 保存结果
        wordMLPackage.save(new File(outputfilepath));
    }

    /**
     * 获取静态数据
     */
    private Map<String, String> getStaticData() {

        AwardsPlan plan = new AwardsPlan();

        plan.setTitle("2020年西太湖马拉松");
        plan.setTime("2020年11月11日 7:30-13:00");
        plan.setLocation("中国杭州");
        plan.setGuestMenModal("张三");
        plan.setGuestMenTrophy("李四");
        plan.setGuestMenCheck("王五");
        plan.setGuestMenPrize("赵六");

        plan.setGuestWomenModal("张三");
        plan.setGuestWomenTrophy("李四");
        plan.setGuestWomenCheck("王五");
        plan.setGuestWomenPrize("赵六");


        plan.setMenAwardsTime("7:30-8:00");
        plan.setMenPlayTime("7:30");
        plan.setMenIntrTime("7:30");
        plan.setMenModalTime("7:30");
        plan.setMenTrophyTime("7:30");
        plan.setMenCheckTime("7:30");
        plan.setMenPrizeTime("7:30");
        plan.setMenPhotoTime("7:30");

        plan.setWomenAwardsTime("7:30-8:00");
        plan.setWomenPlayTime("7:30");
        plan.setWomenIntrTime("7:30");
        plan.setWomenModalTime("7:30");
        plan.setWomenTrophyTime("7:30");
        plan.setWomenCheckTime("7:30");
        plan.setWomenPrizeTime("7:30");
        plan.setWomenPhotoTime("7:30");

        plan.setEndTime("13:00");

        try {
            return BeanUtils.describe(plan);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

}