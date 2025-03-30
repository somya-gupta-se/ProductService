package com.training.ProductService.controller;

import com.training.ProductService.dto.ProductDTO;
import com.training.ProductService.entity.Product;
import com.training.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/get/all")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    /*@GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return service.getProductsByCategory(category);
    }*/

/*    @GetMapping("/kafka/{data}")
    public String publishProduct(@PathVariable("data") String data){
        service.sendProduct(data);
        return "data published";
    }*/


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return "Product deleted successfully!";
    }
}
