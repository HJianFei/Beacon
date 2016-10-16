package com.hjianfei.beacon.bean;

/**
 * Created by HJianFei on 2016/9/27.
 */

public class NavigationInfo {

    /**
     * minor : 10001
     * detail_url : http://www.gdmuseum.com/curio_detail.php?picid=10631&subgid=698&gid=159&title=�㶫��ʷ����
     * content : 哈哈
     * img_url : http://www.gdmuseum.com/attachment/201602/22/2_1456104721gvl5.jpg, http://www.gdmuseum.com/attachment/201602/22/2_14561047210xMK.jpg
     */

    private NavigationInfoBean navigationInfo;
    /**
     * navigationInfo : {"minor":"10001","detail_url":"http://www.gdmuseum.com/curio_detail.php?picid=10631&subgid=698&gid=159&title=�㶫��ʷ����","content":"哈哈","img_url":"http://www.gdmuseum.com/attachment/201602/22/2_1456104721gvl5.jpg, http://www.gdmuseum.com/attachment/201602/22/2_14561047210xMK.jpg"}
     * status : 1
     */

    private String status;

    public NavigationInfoBean getNavigationInfo() {
        return navigationInfo;
    }

    public void setNavigationInfo(NavigationInfoBean navigationInfo) {
        this.navigationInfo = navigationInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class NavigationInfoBean {
        private String minor;
        private String detail_url;
        private String content;
        private String img_url;

        public String getMinor() {
            return minor;
        }

        public void setMinor(String minor) {
            this.minor = minor;
        }

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

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }
    }

    @Override
    public String toString() {
        return "NavigationInfo{" +
                "navigationInfo=" + navigationInfo +
                ", status='" + status + '\'' +
                '}';
    }
}
