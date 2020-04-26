package com.marathon.domain;

import java.io.Serializable;

public class MrtonProcCfgResource implements Serializable {
    /**
     * 任务配置资源ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 任务ID(mrton_proc_cfg)
     *
     * @mbggenerated
     */
    private String cfgProcId;

    /**
     * 模板资源名称
     *
     * @mbggenerated
     */
    private String resourceName;

    /**
     * 是否提供模板文件
     *
     * @mbggenerated
     */
    private Integer hasTemplate;

    /**
     *  资源路径
     *
     * @mbggenerated
     */
    private String resourceUrl;

    private String reserve1;

    private String reserve2;

    /**
     * 是否被删除
     *
     * @mbggenerated
     */
    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCfgProcId() {
        return cfgProcId;
    }

    public void setCfgProcId(String cfgProcId) {
        this.cfgProcId = cfgProcId == null ? null : cfgProcId.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public Integer getHasTemplate() {
        return hasTemplate;
    }

    public void setHasTemplate(Integer hasTemplate) {
        this.hasTemplate = hasTemplate;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}