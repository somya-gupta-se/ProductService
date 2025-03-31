package com.training.ProductService.service;

import com.training.ProductService.dto.ProductDTO;
import com.training.ProductService.entity.Product;
import com.training.ProductService.exception.ProductNotFoundException;
import com.training.ProductService.feign.ProductDetailClient;
import com.training.ProductService.repository.ProductRepository;
import com.training.ProductService.response.ProductDetailResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductDetailClient productDetailClient;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    public Product addProduct(Product product) {
        return repository.save(product);
    }


    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public ProductDTO getProductById(Long id) {
        Optional<Product> product = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found")));
        ProductDetailResponse productDetail= productDetailClient.getProductDetail(id);
        ProductDTO productDetails = new ProductDTO(id,product.get().getName(),productDetail);
        LOGGER.info("Product details are : {}", productDetails.toString());
        return productDetails;
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
