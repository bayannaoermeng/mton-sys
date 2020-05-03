package com.marathon.qvo;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version OrgChartDataVO, v0.1 2020/4/27 9:41
 * @description orgChart插件返回数据结构
 */
@Data
public class OrgChartDataVO {

    private String id;
    private String name;
    private String title;
    private int seq;
    private List<OrgChartDataVO> children;

    public List<OrgChartDataVO> getChildren() {
        if (children == null) {
            children = Lists.newArrayList();
        }
        return children;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id",id).add("name", name).add("title", title).add("children", children).toString();
    }
}
