package com.shop.localzone.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vendorProductCategory")
public class VendorProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="vendor_id", nullable=false)
    private Vendor vendor;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    private ProductCategory productCategory;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="vendorProductCategory")
    private Set<Product> products = new HashSet<>();

    public VendorProductCategory() {
    }

    public VendorProductCategory(Vendor vendor, ProductCategory productCategory, String name) {
        this.vendor = vendor;
        this.productCategory = productCategory;
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
