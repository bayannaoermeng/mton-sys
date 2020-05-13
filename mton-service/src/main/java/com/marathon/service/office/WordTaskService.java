package com.marathon.service.office;

import java.util.Map;

/**
 * WORD文档任务服务
 */
public interface WordTaskService {

    /**
     * 生成文档，并返回预览地址
     * @param taskId
     * @param dataMap
     * @return
     */
    String genWordDoc(String taskId, Map<String,String> dataMap);

    /**
     * 返回任务（word模板任务）预览地址，没有生成文件的返回模板预览地址
     * @param mrtonprocId
     * @return
     */
    String getPreviewFileName(String mrtonprocId);

}
