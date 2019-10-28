package com.hzf.entity;

public class Good {
    private Integer goodid;

    private String goodname;

    private Integer userid;

    private Float price;

    private String description;

    private Integer catelogId;

    private Integer status;

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Integer catelogId) {
        this.catelogId = catelogId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodid=" + goodid +
                ", goodname='" + goodname + '\'' +
                ", userid=" + userid +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", catelogId=" + catelogId +
                ", status=" + status +
                '}';
    }
}