package com.hjianfei.beacon.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HJianFei on 2016/9/19.
 */

public class Educations implements Serializable {


    private String status;

    private List<EducationsBean> educations;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EducationsBean> getEducations() {
        return educations;
    }

    public void setEducations(List<EducationsBean> educations) {
        this.educations = educations;
    }

    public static class EducationsBean {
        private int id;
        private String content;
        private String detail_url;
        private String content_time;
        private String type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public String getContent_time() {
            return content_time;
        }

        public void setContent_time(String content_time) {
            this.content_time = content_time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
