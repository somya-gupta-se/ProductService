package com.training.ProductService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/*

@FeignClient(name = "price-service", url = "http://localhost:8082")
public interface PriceServiceClient {

    @GetMapping("/price/{productId}")
    Double getProductPrice(@PathVariable Long productId);
}*/
