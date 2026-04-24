package com.pzp.model;

import org.springframework.data.annotation.Id;

public class Book {

	@Id
	private long id;
	
	private String name;
	
	private int numbers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
