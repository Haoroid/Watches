package com.union.model;

public class Order {

	private int id;
	private String username;
	private String realname;
	private String commitTime;
	private String address;
	private String status;
	private int goodsId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Order(int id, String username, String realname, String commitTime,
			String address, String status) {
		super();
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.commitTime = commitTime;
		this.address = address;
		this.status = status;
	}
	public Order() {
		super();
		
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
}
