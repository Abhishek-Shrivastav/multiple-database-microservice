package com.microService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microService.entity.ProductDetail;
import com.microService.facade.ProductDetailService;

@RestController
@RequestMapping("/product/detail")
public class ProductDetailController {

	@Autowired
	private ProductDetailService productDetailService;
	
	@GetMapping("/")
	public List<ProductDetail> getAll()
	{
		return this.productDetailService.productDetailList(); 
	}
	
	@GetMapping("/id/{id}")
	public ProductDetail getById(@PathVariable("id")Integer id)
	{
		return this.productDetailService.productDetailById(id); 
	}
}
