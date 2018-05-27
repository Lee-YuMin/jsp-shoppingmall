package com.shopping;

import java.sql.Date;

public class ProductDTO {
	private int Squence;
	private String product_name;
	private String age_group;
	private String type;
	private int price;
	private int discount;
	private boolean hot;
	private Date created_date;
	
	
	public int getSquence() {
		return Squence;
	}
	public void setSquence(int squence) {
		Squence = squence;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getAge_group() {
		return age_group;
	}
	public void setAge_group(String age_group) {
		this.age_group = age_group;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public boolean isHot() {
		return hot;
	}
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	} 
}
