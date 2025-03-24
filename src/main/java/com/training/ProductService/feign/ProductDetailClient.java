package com.training.ProductService.feign;

import com.training.ProductService.response.ProductDetailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ProductDetailService", path = "/product-details")
public interface ProductDetailClient {

    @GetMapping("/get/{productId}")
    ProductDetailResponse getProductDetail(@PathVariable Long productId);
}
