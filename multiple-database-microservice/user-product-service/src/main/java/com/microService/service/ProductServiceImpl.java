package com.microService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microService.entity.Product;
import com.microService.entity.ProductList;
import com.microService.facade.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RestTemplate restTemp;
	
	@Override
	public ProductList productList() {

		return this.restTemp.getForObject("http://PRODUCT/product/all",ProductList.class);
	}

	@Override
	public Product productById(Integer id) {

		return this.restTemp.getForObject("http://PRODUCT/product/id/"+id,Product.class);
	}

	@Override
	public Product saveProduct(Product product) {

		return this.restTemp.postForObject("http://PRODUCT/product/save",product,Product.class);
	}

	@Override
	public Product updateProduct(Product product) {

		return this.restTemp.postForObject("http://PRODUCT/product/update",product,Product.class);
	}

	@Override
	public Boolean deleteProduct(Integer id) {

		return this.restTemp.getForObject("http://PRODUCT/product/delete/"+id,Boolean.class);
	}
}
