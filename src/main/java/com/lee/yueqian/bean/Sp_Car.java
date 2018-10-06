package com.lee.yueqian.bean;

/**
 * 记录商品id、商品数量、店家
 */
public class Sp_Car {
    private Integer id;
    //商品id
    private Integer spCarId;
    //商品数量
    private String number;
    //店家
    private String spCarUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpCarId() {
        return spCarId;
    }

    public void setSpCarId(Integer spCarId) {
        this.spCarId = spCarId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getSpCarUser() {
        return spCarUser;
    }

    public void setSpCarUser(String spCarUser) {
        this.spCarUser = spCarUser == null ? null : spCarUser.trim();
    }
}