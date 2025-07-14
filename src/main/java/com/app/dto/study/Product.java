package com.app.dto.study;

public class Product {
	public String id;
	public String name;
	public int price;
	
	// 인자를 받는 생성자 추가
	public Product(String id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	// (선택 사항) 기본 생성자를 명시적으로 추가하는 것이 좋습니다.
	// Product product = new Product(); 와 같이 사용할 경우 필요합니다.
	public Product() {} 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}