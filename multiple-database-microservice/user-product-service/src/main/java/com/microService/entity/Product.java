package com.microService.entity;

public class Product {

	private Integer id;
	private String productName;
	private Integer price;
	
	public Product() {
		super();
	}

	public Product(Integer id, String productName, Integer price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}
}
