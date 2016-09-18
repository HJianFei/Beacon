package com.hjianfei.beacon.bean;

import java.io.Serializable;


public class Exhibition implements Serializable {

    /**
     * content : 相看两不厌——馆藏明清瓷画与绘画的对视 2016-10-25至 2017-2-26三楼展厅一
     * detail_url : http://www.gdmuseum.com/exhibit3_detail.php?picid=9299&LibID=41&gid=7&title=展览预告
     * id : 1089
     * img_url : http://www.gdmuseum.com/attachment/201602/19/2_1455847877pPJ1.jpg
     * type : 0
     */

    private ExhibitionBean exhibition;
    /**
     * exhibition : {"content":"相看两不厌\u2014\u2014馆藏明清瓷画与绘画的对视 2016-10-25至 2017-2-26三楼展厅一","detail_url":"http://www.gdmuseum.com/exhibit3_detail.php?picid=9299&LibID=41&gid=7&title=展览预告","id":1089,"img_url":"http://www.gdmuseum.com/attachment/201602/19/2_1455847877pPJ1.jpg","type":"0"}
     * status : 1
     */

    private String status;

    public ExhibitionBean getExhibition() {
        return exhibition;
    }

    public void setExhibition(ExhibitionBean exhibition) {
        this.exhibition = exhibition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ExhibitionBean {
        private String content;
        private String detail_url;
        private int id;
        private String img_url;
        private String type;

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
