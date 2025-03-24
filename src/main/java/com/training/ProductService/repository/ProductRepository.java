package com.training.ProductService.repository;


import com.training.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //List<Product> findByCategory(String category);
    //Product findById(Long id);
}
