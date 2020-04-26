package com.marathon.service;

import com.marathon.qvo.OfficeFileAclVO;
import com.marathon.qvo.OfficeFileSaveBackQO;
import com.marathon.qvo.OfficeFileSaveBackVO;

/**
 * Office工具服务
 */
public interface IReferOfficeService {

    /**
     * 获取链接
     * @param fileId
     * @param userId
     * @param operation
     * @return
     */
    public String getLink(String fileId, Integer userId, String operation);

    /**
     * 配置文件信息
     * @param fileId
     * @param userId
     * @return
     */
    OfficeFileAclVO fileAcl(String fileId, String userId);

}
