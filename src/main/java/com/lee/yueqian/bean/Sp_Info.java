package com.lee.yueqian.bean;

/**
 * 商品列表页展示信息
 */
public class Sp_Info {
    private Integer id;

    private Integer spType;

    private String spName;

    private String oldPrice;

    private String newPrice;

    private String spInfo;

    private String spImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpType() {
        return spType;
    }

    public void setSpType(Integer spType) {
        this.spType = spType;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice == null ? null : oldPrice.trim();
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice == null ? null : newPrice.trim();
    }

    public String getSpInfo() {
        return spInfo;
    }

    public void setSpInfo(String spInfo) {
        this.spInfo = spInfo == null ? null : spInfo.trim();
    }

    public String getSpImg() {
        return spImg;
    }

    public void setSpImg(String spImg) {
        this.spImg = spImg == null ? null : spImg.trim();
    }

    @Override
    public String toString() {
        return "Sp_Info{" +
                "id=" + id +
                ", spType=" + spType +
                ", spName='" + spName + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                ", newPrice='" + newPrice + '\'' +
                ", spInfo='" + spInfo + '\'' +
                ", spImg='" + spImg + '\'' +
                '}';
    }
}