package com.marathon.qvo;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;

/**
 * @author cuiguangqiang
 * @version OfficeFileAclVO, v0.1 2020/2/4 17:34
 * @description 类说明
 */
public class OfficeFileAclVO {

    public Doc doc;
    public User user;

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public class Doc {
        private String docId;
        private String title;
        private String mimeType;
        private String fetchUrl;
        private Boolean fromApi = true;

        public String getDocId() {
            return docId;
        }

        public void setDocId(String docId) {
            this.docId = docId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getFetchUrl() {
            return fetchUrl;
        }

        public void setFetchUrl(String fetchUrl) {
            this.fetchUrl = fetchUrl;
        }

        public Boolean getFromApi() {
            return fromApi;
        }

        public void setFromApi(Boolean fromApi) {
            this.fromApi = fromApi;
        }
    }

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

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getOid() {
            return oid;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public List<String> getPrivilege() {
            return privilege;
        }

        public void setPrivilege(List<String> privilege) {
            this.privilege = privilege;
        }
    }
}
