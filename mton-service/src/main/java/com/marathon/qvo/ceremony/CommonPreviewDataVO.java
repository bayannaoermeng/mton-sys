package com.marathon.qvo.ceremony;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version CommonPreviewDataVO, v0.1 2020/5/19 9:50
 * @description 预览列表数据结构
 */
@Data
public class CommonPreviewDataVO {

    private List<PreviewData> lstPreview;

    public List<PreviewData> getLstPreview() {
        if(lstPreview == null){
            lstPreview = Lists.newArrayList();
        }
        return lstPreview;
    }
}
