package com.marathon.service.office;

import java.util.Map;

public interface WordTaskService {

    /**
     * 生成文档，并返回预览地址
     * @param taskId
     * @param dataMap
     * @return
     */
    String genWordDoc(String taskId, Map<String,String> dataMap);

}
