/**
 * 毕升回存回调请求参数
 */
package com.marathon.qvo;

import java.util.List;

public class OfficeFileSaveBackQO {

    private String docId;
    private String action;
    private Data data;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private String docId;
        private String docURL;
        private String docUrlEncode;
        private List<ModifyBy> modifyBy = null;
        private Boolean unchanged;
        private String pngUrl;
        private String txtUrl;
        private String txtUrlEncode;
        private String pngUrlEncode;

        public String getDocId() {
            return docId;
        }

        public void setDocId(String docId) {
            this.docId = docId;
        }

        public String getDocURL() {
            return docURL;
        }

        public void setDocURL(String docURL) {
            this.docURL = docURL;
        }

        public String getDocUrlEncode() {
            return docUrlEncode;
        }

        public void setDocUrlEncode(String docUrlEncode) {
            this.docUrlEncode = docUrlEncode;
        }

        public List<ModifyBy> getModifyBy() {
            return modifyBy;
        }

        public void setModifyBy(List<ModifyBy> modifyBy) {
            this.modifyBy = modifyBy;
        }

        public Boolean getUnchanged() {
            return unchanged;
        }

        public void setUnchanged(Boolean unchanged) {
            this.unchanged = unchanged;
        }

        public String getPngUrl() {
            return pngUrl;
        }

        public void setPngUrl(String pngUrl) {
            this.pngUrl = pngUrl;
        }

        public String getTxtUrl() {
            return txtUrl;
        }

        public void setTxtUrl(String txtUrl) {
            this.txtUrl = txtUrl;
        }

        public String getTxtUrlEncode() {
            return txtUrlEncode;
        }

        public void setTxtUrlEncode(String txtUrlEncode) {
            this.txtUrlEncode = txtUrlEncode;
        }

        public String getPngUrlEncode() {
            return pngUrlEncode;
        }

        public void setPngUrlEncode(String pngUrlEncode) {
            this.pngUrlEncode = pngUrlEncode;
        }

        public static class ModifyBy {
            public String uid;
            public String oid;
            public String avatar;
            public String nickName;

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

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }
        }

    }


}