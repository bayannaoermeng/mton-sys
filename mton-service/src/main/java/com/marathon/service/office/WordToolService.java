package com.marathon.service.office;

import java.util.Map;

/**
 * @author cuiguangqiang
 * @version WordToolService, v0.1 2020/4/27 17:49
 * @description word模板渲染、PDF预览操作
 */
public interface WordToolService {

    /**
     * word模板内容渲染，生成文件输出
     * @param tempaltePath
     * @param dataMap
     * @param outputFilePath
     */
    public void renderDocument(String tempaltePath, Map<String,String> dataMap,String outputFilePath);

}
