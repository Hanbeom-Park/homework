package com.ssafy.hw;

import java.io.Serializable;

public class TV extends Product{

	private int wide;

	public TV() {
		super();
	}

	public TV(String name, int price, int amount, int wide) {
		super(name, price, amount);
		this.wide=wide;
	}
	public TV(String name, int price, int amount) {
		this(name, price, amount,0);
	}

	@Override
	public String toString() {
		return "TV [no=" + no + ", name=" + name + ", price=" + price + ", amount=" + amount + ", wide=" + wide + "]\n";
	}

	public int getWide() {
		return wide;
	}

	public void setWide(int wide) {
		this.wide = wide;
	}

}
