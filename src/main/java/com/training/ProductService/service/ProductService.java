package com.training.ProductService.service;

import com.training.ProductService.dto.ProductDTO;
import com.training.ProductService.entity.Product;
import com.training.ProductService.feign.ProductDetailClient;
import com.training.ProductService.repository.ProductRepository;
import com.training.ProductService.response.ProductDetailResponse;
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

/*    public void sendProduct(String data){
        kafkaTemplate.send("productTopic", "1", data);
    }*/

    public Product addProduct(Product product) {
        //product.setAvailable(true);
        return repository.save(product);
    }


    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public ProductDTO getProductById(Long id) {
        Optional<Product> product = repository.findById(id);
        ProductDetailResponse productDetail= productDetailClient.getProductDetail(id);
        ProductDTO productDetails = new ProductDTO(id,product.get().getName(),productDetail);
        System.out.println("Product details are : "+productDetails.toString());
        return productDetails;
    //return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    /*public List<Product> getProductsByCategory(String category) {
        return repository.findByCategory(category);
    }*/

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
