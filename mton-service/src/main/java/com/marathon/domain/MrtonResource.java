package com.marathon.domain;

import java.io.Serializable;
import java.util.Date;

public class MrtonResource implements Serializable {
    private Integer id;

    private String procId;

    /**
     * 文件名
     *
     * @mbggenerated
     */
    private String resourceName;

    private String resourceUrl;

    /**
     * 上传时间
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * 编辑者
     *
     * @mbggenerated
     */
    private Integer uploader;

    /**
     * 是否是模板
     *
     * @mbggenerated
     */
    private Boolean istemplate;

    /**
     * 是否被删除
     *
     * @mbggenerated
     */
    private Boolean delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId == null ? null : procId.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUploader() {
        return uploader;
    }

    public void setUploader(Integer uploader) {
        this.uploader = uploader;
    }

    public Boolean getIstemplate() {
        return istemplate;
    }

    public void setIstemplate(Boolean istemplate) {
        this.istemplate = istemplate;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}