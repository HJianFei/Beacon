package com.hjianfei.beacon.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 创建时间： 2016/9/17.
 * 作者：HJianFei
 * 功能描述：
 */

public class Appreciates implements Serializable {

    /**
     * appreciates : [{"id":235,"img_url":"http://www.gdmuseum.com/attachment/201607/12/2_1468309962hLlA.jpg","content":"明代景德镇窑青花花鸟纹瓣口折沿碗","detail_url":"http://www.gdmuseum.com/curio_detail.php?picid=11290&subgid=1&gid=160&title=�໨��֮Լ","type":"青花瓷之约"}]
     * status : 1
     */

    private String status;
    /**
     * id : 235
     * img_url : http://www.gdmuseum.com/attachment/201607/12/2_1468309962hLlA.jpg
     * content : 明代景德镇窑青花花鸟纹瓣口折沿碗
     * detail_url : http://www.gdmuseum.com/curio_detail.php?picid=11290&subgid=1&gid=160&title=�໨��֮Լ
     * type : 青花瓷之约
     */

    private List<AppreciatesBean> appreciates;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AppreciatesBean> getAppreciates() {
        return appreciates;
    }

    public void setAppreciates(List<AppreciatesBean> appreciates) {
        this.appreciates = appreciates;
    }

    public static class AppreciatesBean {
        private int id;
        private String img_url;
        private String content;
        private String detail_url;
        private String type;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
