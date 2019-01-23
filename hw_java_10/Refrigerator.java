package com.ssafy.hw;

public class Refrigerator extends Product {

	private int capacity;

	public Refrigerator() {
		super();
	}

	public Refrigerator(String name, int price, int amount, int capacity) {
		super(name, price, amount);
		this.capacity=capacity;
	}
	public Refrigerator(String name, int price, int amount) {
		this(name, price, amount,0);
	}

	@Override
	public String toString() {
		return "Refrigerator [no=" + no + ", name=" + name + ", price=" + price + ", amount=" + amount + ", capacity=" + capacity + "]\n";
	}



	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


}
