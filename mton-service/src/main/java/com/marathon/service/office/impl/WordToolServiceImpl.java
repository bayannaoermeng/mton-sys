package com.marathon.service.office.impl;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.marathon.service.office.WordToolService;
import lombok.extern.slf4j.Slf4j;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author cuiguangqiang
 * @version WordToolServiceImpl, v0.1 2020/4/27 17:50
 * @description 类说明
 */
@Slf4j
@Service
public class WordToolServiceImpl implements WordToolService {

    private Map<String, Iconvert> specialMap = ImmutableMap.<String, Iconvert>builder()
            .put("participants", new NewLineConvert())
            .build();

    @Override
    public void renderDocument(String tempaltePath, Map<String, String> dataMap, String outputFilePath) {
        try {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(tempaltePath));
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

            Map<String,String> datMapCopy = Maps.newHashMap(dataMap);

            specialMap.forEach((k, v) -> {
                if (datMapCopy.containsKey(k)) {
                    String value = datMapCopy.get(k);
                    datMapCopy.put(k, v.convert(value));
                }
            });

            // 替换普通变量
            documentPart.variableReplace(datMapCopy);
            // 保存结果
            wordMLPackage.save(new File(outputFilePath));
        } catch (Docx4JException e) {
            log.error("word模板文档【{}】渲染失败", tempaltePath, e);
        } catch (JAXBException e) {
            log.error("word模板文档【{}】渲染失败", tempaltePath, e);
        }
    }

    public interface Iconvert {

        public String convert(String input);

    }

    public class NewLineConvert implements Iconvert {
        @Override
        public String convert(String input) {
            List<String> lstItem = Splitter.on(",").splitToList(input);
            return newlineToBreakHack(Joiner.on("\n").join(lstItem));
        }
    }

    /**
     * Hack to convert a new line character into w:br.
     * If you need this sort of thing, consider using
     * OpenDoPE content control data binding instead.
     *
     * @param r
     * @return
     */
    private static String newlineToBreakHack(String r) {

        StringTokenizer st = new StringTokenizer(r, "\n\r\f"); // tokenize on the newline character, the carriage-return character, and the form-feed character
        StringBuilder sb = new StringBuilder();

        boolean firsttoken = true;
        while (st.hasMoreTokens()) {
            String line = (String) st.nextToken();
            if (firsttoken) {
                firsttoken = false;
            } else {
                sb.append("</w:t><w:br/><w:t>");
            }
            sb.append(line);
        }
        return sb.toString();
    }
}
