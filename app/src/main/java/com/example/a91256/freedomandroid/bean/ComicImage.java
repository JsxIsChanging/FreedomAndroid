package com.example.a91256.freedomandroid.bean;

import java.util.List;

/**
 * Created by 91256 on 2017/6/9.
 */

public class ComicImage {

    /**
     * location : http://img7.cdn.u17i.com/12/06/27107/996329_1339612666_ZsrZ6FyAFQfz.529ce_svol.jpg
     * image_id : 927316
     * width : 565
     * height : 800
     * total_tucao : 26
     * webp : 0
     * type : 0
     * img05 : http://img7.cdn.u17i.com/12/06/27107/wp/996329_1339612666_ZsrZ6FyAFQfz.ac896_05.jpg
     * img50 : http://img7.cdn.u17i.com/12/06/27107/wp/996329_1339612666_ZsrZ6FyAFQfz.ac896_50.jpg
     * images : [{"id":"658347","sort":"0","width":"565","height":"800","img05":"http://img7.cdn.u17i.com/12/06/27107/wp/996329_1339612666_ZsrZ6FyAFQfz.ac896_05.jpg","img50":"http://img7.cdn.u17i.com/12/06/27107/wp/996329_1339612666_ZsrZ6FyAFQfz.ac896_50.jpg"}]
     */

    private String location;
    private String image_id;
    private String width;
    private String height;
    private String total_tucao;
    private String webp;
    private String type;
    private String img05;
    private String img50;
    private List<ImagesBean> images;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTotal_tucao() {
        return total_tucao;
    }

    public void setTotal_tucao(String total_tucao) {
        this.total_tucao = total_tucao;
    }

    public String getWebp() {
        return webp;
    }

    public void setWebp(String webp) {
        this.webp = webp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg05() {
        return img05;
    }

    public void setImg05(String img05) {
        this.img05 = img05;
    }

    public String getImg50() {
        return img50;
    }

    public void setImg50(String img50) {
        this.img50 = img50;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class ImagesBean {
        /**
         * id : 658347
         * sort : 0
         * width : 565
         * height : 800
         * img05 : http://img7.cdn.u17i.com/12/06/27107/wp/996329_1339612666_ZsrZ6FyAFQfz.ac896_05.jpg
         * img50 : http://img7.cdn.u17i.com/12/06/27107/wp/996329_1339612666_ZsrZ6FyAFQfz.ac896_50.jpg
         */

        private String id;
        private String sort;
        private String width;
        private String height;
        private String img05;
        private String img50;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getImg05() {
            return img05;
        }

        public void setImg05(String img05) {
            this.img05 = img05;
        }

        public String getImg50() {
            return img50;
        }

        public void setImg50(String img50) {
            this.img50 = img50;
        }
    }
}
