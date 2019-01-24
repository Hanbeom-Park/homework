package com.ssafy.hw;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8830458749870130835L;
	protected String no;
	protected String name;
	protected int price ;
	protected int amount;
	public Product() {
		super();
	}
	public Product(String name, int price, int amount) {
		super();
		//this.no = no;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", amount=" + amount + "]\n";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
