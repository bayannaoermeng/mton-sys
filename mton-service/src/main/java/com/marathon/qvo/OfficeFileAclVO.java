package com.marathon.qvo;

import com.google.common.collect.ImmutableList;
import lombok.Data;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version OfficeFileAclVO, v0.1 2020/2/4 17:34
 * @description 类说明
 */
@Data
public class OfficeFileAclVO {

    public Doc doc;
    public User user;

    @Data
    public class Doc {
        private String docId;
        private String title;
        private String mimeType;
        private String fetchUrl;
        private Boolean fromApi = true;
        private boolean pdfview;
    }

    @Data
    public class User {
        private String uid;
        private String oid;
        private String nickName;
        private String avatar="";
        private List<String> privilege =  new ImmutableList.Builder<String>()
                .add("FILE_READ")
                .add("FILE_WRITE")
                .add("FILE_DOWNLOAD")
                .add("FILE_PRINT")
                .build();
    }
}
