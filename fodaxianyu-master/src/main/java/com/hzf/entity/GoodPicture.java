package com.hzf.entity;

import java.util.List;

public class GoodPicture extends Good {
    Integer pictureid;
    Integer picturegoodid;
    String pictureurl;

    public Integer getPictureid() {
        return pictureid;
    }

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public Integer getPicturegoodid() {
        return picturegoodid;
    }

    public void setPicturegoodid(Integer picturegoodid) {
        this.picturegoodid = picturegoodid;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    @Override
    public String toString() {
        return super.toString()+"       GoodPicture{" +
                "pictureid=" + pictureid +
                ", picturegoodid=" + picturegoodid +
                ", pictureurl=" + pictureurl +
                '}';
    }
}
