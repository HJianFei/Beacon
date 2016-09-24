package com.hjianfei.beacon.bean;

import java.io.Serializable;

/**
 * Created by HJianFei on 2016/9/24.
 */

public class EducationDetail implements Serializable {
    
    private EducationDetailBean educationDetail;

    private String status;

    public EducationDetailBean getEducationDetail() {
        return educationDetail;
    }

    public void setEducationDetail(EducationDetailBean educationDetail) {
        this.educationDetail = educationDetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class EducationDetailBean {
        private String detail_url;
        private String content;

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
