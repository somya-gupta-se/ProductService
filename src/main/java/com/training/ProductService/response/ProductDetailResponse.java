package com.training.ProductService.response;

public class ProductDetailResponse {
    private Long productId;
    private String description;
    private String category;
    private String design;
    private String size;
    private Double price;

    private Boolean available;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ProductDetailResponse{" +
                "productId=" + productId +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", design='" + design + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
