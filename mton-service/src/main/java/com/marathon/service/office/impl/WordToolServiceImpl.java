package com.marathon.service.office.impl;

import com.marathon.service.office.WordToolService;
import lombok.extern.slf4j.Slf4j;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Map;

/**
 * @author cuiguangqiang
 * @version WordToolServiceImpl, v0.1 2020/4/27 17:50
 * @description 类说明
 */
@Slf4j
@Service
public class WordToolServiceImpl implements WordToolService {

    @Override
    public void renderDocument(String tempaltePath, Map<String, String> dataMap, String outputFilePath) {
        try {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(tempaltePath));
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
            // 替换普通变量
            documentPart.variableReplace(dataMap);
            // 保存结果
            wordMLPackage.save(new File(outputFilePath));
        } catch (Docx4JException e) {
            log.error("word模板文档【{}】渲染失败", tempaltePath, e);
        } catch (JAXBException e) {
            log.error("word模板文档【{}】渲染失败", tempaltePath, e);
        }
    }
}
