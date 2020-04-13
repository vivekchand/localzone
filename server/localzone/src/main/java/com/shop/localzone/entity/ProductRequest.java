package com.shop.localzone.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductRequest {
    private String name;
    private String description;
    private Float ratePerUnit;
    private Long availableQty;
    private String category;
    private List<String> base64EncodedImages;

    public ProductRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRatePerUnit() {
        return ratePerUnit;
    }

    public void setRatePerUnit(Float ratePerUnit) {
        this.ratePerUnit = ratePerUnit;
    }

    public Long getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Long availableQty) {
        this.availableQty = availableQty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getBase64EncodedImages() {
        return base64EncodedImages == null? new ArrayList<>():base64EncodedImages;
    }

    public void setBase64EncodedImages(List<String> base64EncodedImages) {
        this.base64EncodedImages = base64EncodedImages;
    }
}
