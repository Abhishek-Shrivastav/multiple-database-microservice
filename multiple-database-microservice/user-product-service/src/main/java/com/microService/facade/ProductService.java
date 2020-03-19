package com.microService.facade;

import com.microService.entity.Product;
import com.microService.entity.ProductList;

public interface ProductService {

	ProductList productList();
	Product productById(Integer id);
	Product saveProduct(Product product);
	Product updateProduct(Product product);
	Boolean deleteProduct(Integer id);
}
