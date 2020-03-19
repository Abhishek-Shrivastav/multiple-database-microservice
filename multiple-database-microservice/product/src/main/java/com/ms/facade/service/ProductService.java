package com.ms.facade.service;

import java.util.List;

import com.ms.entity.product.Product;

public interface ProductService {

	List<Product> productList();
	Product productById(Integer id);
	Product saveProduct(Product product);
	Product updateProduct(Product product);
	Boolean deleteProduct(Integer id);
}
