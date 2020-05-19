package com.marathon.service.office;

import com.marathon.qvo.ceremony.CommonPreviewDataVO;
import com.marathon.qvo.ceremony.CommonWordPlanVO;

import javax.servlet.http.HttpServletRequest;

/**
 * WORD文档任务服务
 */
public interface WordTaskService {


    /**
     * 返回任务（word模板任务）预览地址，没有生成文件的返回模板预览地址
     * @param mrtonprocId
     * @return
     */
    String getPreviewFileName(String mrtonprocId);


    /**
     * wordItem转化成bean
     * @param mrtonprocId
     * @param bean
     * @param kind
     */
    void getWordItemBean(String mrtonprocId, CommonWordPlanVO bean, Class kind);


    /**
     * 渲染word并且生成PDF预览，返回预览地址
     *
     * @param object
     * @param request
     * @return
     */
    String genWordAndPreview(Object object, HttpServletRequest request);

    /**
     * word任务历史参考文件列表
     * @param wordTaskName
     * @return
     */
    CommonPreviewDataVO getRelatePreviewData(String wordTaskName);
}
