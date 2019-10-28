package com.hzf.entity;

public class Pictures {
    private Integer pictureid;

    private Integer goodid;

    private String pictureurl;

    public Integer getPictureid() {
        return pictureid;
    }

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "pictureid=" + pictureid +
                ", goodid=" + goodid +
                ", pictureurl='" + pictureurl + '\'' +
                '}';
    }
}