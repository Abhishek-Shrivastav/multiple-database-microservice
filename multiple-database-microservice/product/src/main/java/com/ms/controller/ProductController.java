package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.product.Product;
import com.ms.entity.product.ProductList;
import com.ms.facade.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ProductList getAll()
	{
		ProductList productList = new ProductList(this.productService.productList());
		
		return productList;
	}
	
	@GetMapping("/id/{id}")
	public Product getById(@PathVariable("id")Integer id)
	{
		return this.productService.productById(id); 
	}
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product)
	{
		Product product1 = this.productService.saveProduct(product);
		
		return product1; 
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product)
	{
		Product product1 = this.productService.saveProduct(product);
		
		return product1; 
	}
	
	@GetMapping("/delete/{id}")
	public Boolean deleteProduct(@PathVariable("id")Integer id)
	{
		Boolean status = this.productService.deleteProduct(id);
		
		if(status)
			return status;
		
		return status;
	}
}
