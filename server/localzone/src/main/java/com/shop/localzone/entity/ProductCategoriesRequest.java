package com.shop.localzone.entity;

import java.util.List;

public class ProductCategoriesRequest {
    private List<String> categories;

    public ProductCategoriesRequest() {
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
