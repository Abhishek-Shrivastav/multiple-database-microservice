package com.microService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microService.entity.ProductDetail;
import com.microService.facade.ProductDetailService;
import com.microService.repository.ProductDetailRepository;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

	@Autowired
	private ProductDetailRepository productDetailRepository;
	
	@Override
	public List<ProductDetail> productDetailList() {

		return this.productDetailRepository.findAll();
	}

	@Override
	public ProductDetail productDetailById(Integer id) {

		Optional<ProductDetail> optionals = this.productDetailRepository.findById(id);
		
		ProductDetail productDetail = null;
		if(optionals.isPresent())
			productDetail = optionals.get();
		
		return productDetail;
	}

	@Override
	public ProductDetail saveProductDetail(ProductDetail productDetail) {

		return this.productDetailRepository.save(productDetail);
	}

	@Override
	public ProductDetail updateProductDetail(ProductDetail productDetail) {

		return this.productDetailRepository.save(productDetail);
	}

	@Override
	public Boolean deleteProductDetail(Integer id) {

		this.productDetailRepository.deleteById(id);
		
		return true;
	}
}
