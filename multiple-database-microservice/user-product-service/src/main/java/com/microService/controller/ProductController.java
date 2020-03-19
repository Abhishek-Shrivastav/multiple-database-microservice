package com.microService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microService.entity.Product;
import com.microService.entity.ProductDetail;
import com.microService.entity.ProductList;
import com.microService.facade.ProductDetailService;
import com.microService.facade.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDetailService productDetailService;
	
	@GetMapping("/")
	public ProductList getAll()
	{
		return this.productService.productList(); 
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
		
		if(product1 != null)
		{
			ProductDetail pd = new ProductDetail(product.getId(),product.getProductName(),product.getPrice());
			ProductDetail productDetail1 = this.productDetailService.saveProductDetail(pd);
			
			if(productDetail1 != null)
				return product1;
		}
		return product1;
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product)
	{
		Product product1 = this.productService.updateProduct(product);
		
		if(product1 != null)
		{
			ProductDetail pd = new ProductDetail(product.getId(),product.getProductName(),product.getPrice());
			ProductDetail productDetail1 = this.productDetailService.updateProductDetail(pd);
			
			if(productDetail1 != null)
				return product1;
		}
		return product1;
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteProduct(@PathVariable("id")Integer id)
	{
		Product product = this.productService.productById(id);;
		ProductDetail productDetail = this.productDetailService.productDetailById(id);
		
		Boolean status = false;
		if(product.getId() == productDetail.getId())
		{
			status = this.productService.deleteProduct(product.getId());
			
			if(status)
			{
				status = this.productDetailService.deleteProductDetail(productDetail.getId());
			}
		}
		
		return status;
	}
}
