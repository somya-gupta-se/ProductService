package com.training.ProductService.dto;

import com.training.ProductService.response.ProductDetailResponse;

public class ProductDTO {
    private Long id;

    public ProductDTO(Long id, String name, ProductDetailResponse productDetail) {
        this.id = id;
        this.name = name;
        this.productDetail = productDetail;
    }

    private String name;

    private ProductDetailResponse productDetail;

    public ProductDetailResponse getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailResponse productDetail) {
        this.productDetail = productDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
