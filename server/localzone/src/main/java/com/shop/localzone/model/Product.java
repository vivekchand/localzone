package com.shop.localzone.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="vendor_product_category_id", nullable=false)
    private VendorProductCategory vendorProductCategory;

    @ManyToOne
    @JoinColumn(name="vendor_id", nullable=false)
    private Vendor vendor;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "rate_per_unit")
    private Float ratePerUnit;

    @Column(name = "available_qty")
    private Long availableQty;

    @OneToMany(mappedBy="product")
    private Set<ProductImage> productImages = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VendorProductCategory getVendorProductCategory() {
        return vendorProductCategory;
    }

    public void setVendorProductCategory(VendorProductCategory vendorProductCategory) {
        this.vendorProductCategory = vendorProductCategory;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
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

    public Set<ProductImage> getProductImages() {
        return productImages == null? new HashSet<>(): productImages;
    }

    public void addProductImage(ProductImage productImage) {
        productImages.add(productImage);
    }
}
