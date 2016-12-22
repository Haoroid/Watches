package com.union.model;

public class Goods {

	
	private int id;
	private String name;
	private String price;
	private String picture;
	private String color;
	private String goodsSize;
	private String type;
	private int goodsNum;
	private String discount;
	private String description;//商品简介
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Goods(int id, String name, String price, String picture,
			String color, String goodsSize, String type, String discount,int goodsNum) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.picture = picture;
		this.color = color;
		this.setGoodsSize(goodsSize);
		this.type = type;
		this.discount = discount;
		this.setGoodsNum(goodsNum);
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(String goodsSize) {
		this.goodsSize = goodsSize;
	}
	
	
	
}
