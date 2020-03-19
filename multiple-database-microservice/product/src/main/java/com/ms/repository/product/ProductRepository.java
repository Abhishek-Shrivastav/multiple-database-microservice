package com.ms.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.entity.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
