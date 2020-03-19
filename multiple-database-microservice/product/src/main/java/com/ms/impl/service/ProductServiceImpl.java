package com.ms.impl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.entity.product.Product;
import com.ms.facade.service.ProductService;
import com.ms.repository.product.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> productList() {

		return this.productRepository.findAll();
	}

	@Override
	public Product productById(Integer id) {

		Optional<Product> optionals = this.productRepository.findById(id);
		
		Product product = null;
		if(optionals.isPresent())
			product = optionals.get();
		
		return product;
	}

	@Override
	public Product saveProduct(Product product) {

		return this.productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {

		return this.productRepository.save(product);
	}

	@Override
	public Boolean deleteProduct(Integer id) {

		this.productRepository.deleteById(id);
		
		return true;
	}
}
