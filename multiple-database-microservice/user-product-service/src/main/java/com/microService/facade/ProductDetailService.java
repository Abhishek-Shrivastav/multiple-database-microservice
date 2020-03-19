package com.microService.facade;

import java.util.List;

import com.microService.entity.ProductDetail;

public interface ProductDetailService {

	List<ProductDetail> productDetailList();
	ProductDetail productDetailById(Integer id);
	ProductDetail saveProductDetail(ProductDetail productDetail);
	ProductDetail updateProductDetail(ProductDetail productDetail);
	Boolean deleteProductDetail(Integer id);
}
