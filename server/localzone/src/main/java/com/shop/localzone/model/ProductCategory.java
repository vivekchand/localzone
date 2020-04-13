package com.shop.localzone.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ProductCategory {
    FRUITS("Fruits"),
    VEGETABLES("Vegetables"),
    DIARY_PRODUCTS("Diary Products"),
    BAKERY_PRODUCTS("Bakery Products"),
    SNACKS("Snacks"),
    RICE("Rice"),
    FLOUR("Flour"),
    GRAINS_AND_PULES("Grains & Pulses"),
    INSTANT_FOOD("Instant Food"),
    SPICES_AND_COMMODITIES("Spices & Commodities"),
    OIL("Oil"),
    HOME_CLEANERS("Home Cleaners"),
    HEALTH("Health"),
    TEA_AND_COFFEE("Tea & Coffee");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public static List<String> getValues() {
        return Arrays.stream(values()).map(ProductCategory::getDisplayName).collect(Collectors.toList());
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ProductCategory fromDisplayName(String displayName) {
        return Arrays.stream(ProductCategory.values()).filter(productCategory ->
                productCategory.getDisplayName().equals(displayName)).findFirst().orElse(null);
    }
}
