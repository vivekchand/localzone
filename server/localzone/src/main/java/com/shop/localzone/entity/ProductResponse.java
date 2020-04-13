package com.shop.localzone.entity;

import com.shop.localzone.model.Product;
import com.shop.localzone.model.ProductImage;

import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {
    private Long id;
    private Long vendorId;
    private String name;
    private String description;
    private Float ratePerUnit;
    private Long availableQty;
    private String category;
    private List<String> base64EncodedImages;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.vendorId = product.getVendor().getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.ratePerUnit = product.getRatePerUnit();
        this.availableQty = product.getAvailableQty();
        this.category = product.getVendorProductCategory().getName();
        this.base64EncodedImages = product.getProductImages().stream()
                .map(ProductImage::getBase64EncodedImage).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public String getDescription() {
        return description;
    }

    public Float getRatePerUnit() {
        return ratePerUnit;
    }

    public Long getAvailableQty() {
        return availableQty;
    }

    public List<String> getBase64EncodedImages() {
        return base64EncodedImages;
    }
}
