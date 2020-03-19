package com.microService.entity;

import java.util.List;

public class ProductList {

	private List<Product> listProduct;

	public ProductList() {
		super();
	}

	public ProductList(List<Product> listProduct) {
		super();
		this.listProduct = listProduct;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}
}
