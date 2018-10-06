package com.lee.yueqian.bean;

/**
 * 用户购物车页面联合查询结果类
 * @author Lee34
 */
public class ShopCar {

	Integer carId;
	
	Integer shopInfoId;
	
	String number;
	
	Integer shopTypeId;
	
	String shopName;
	
	String oldPrice;
	
	String newPrice;
	
	String shopInfo;
	
	String shopImg;


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getShopTypeId() {
		return shopTypeId;
	}

	public void setShopTypeId(Integer shopTypeId) {
		this.shopTypeId = shopTypeId;
	}

	public String getShopName() {
		return shopName;
	}


	public String getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(String newPrice) {
		this.newPrice = newPrice;
	}

	public String getShopInfo() {
		return shopInfo;
	}


	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getShopInfoId() {
		return shopInfoId;
	}


	@Override
	public String toString() {
		return "ShopCar [carId=" + carId + ", ShopInfoId=" + shopInfoId + ", number=" + number + ", shopTypeId="
				+ shopTypeId + ", shopName=" + shopName + ", oldPrice=" + oldPrice + ", newPrice=" + newPrice
				+ ", shopInfo=" + shopInfo + ", shopImg=" + shopImg + "]";
	}

	public void setShopInfoId(Integer shopInfoId) {
		this.shopInfoId = shopInfoId;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setShopInfo(String shopInfo) {
		this.shopInfo = shopInfo;
	}

	
}
