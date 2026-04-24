package com.pzp.model;

import org.springframework.data.annotation.Id;

//@TableName("book")
public class SharedingBook {

	@Id
	private long userId;
	
    private long orderId;
	
	private String name;
	
	private int numbers;
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

}
