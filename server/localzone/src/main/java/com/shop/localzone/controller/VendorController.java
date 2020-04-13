package com.shop.localzone.controller;

import com.shop.localzone.entity.ProductCategoriesRequest;
import com.shop.localzone.entity.ProductRequest;
import com.shop.localzone.entity.ProductResponse;
import com.shop.localzone.entity.VendorDetailsRequest;
import com.shop.localzone.model.*;
import com.shop.localzone.repository.ProductImageRepository;
import com.shop.localzone.repository.ProductRepository;
import com.shop.localzone.repository.VendorProductCategoryRepository;
import com.shop.localzone.repository.VendorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/")
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorProductCategoryRepository vendorProductCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    // list vendors
    @GetMapping("vendor")
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // get vendor by id
    @GetMapping("vendor/{id}")
    public ResponseEntity<Vendor> getVendor(@PathVariable("id") Long id) throws NotFoundException {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(() -> new NotFoundException("No such Vendor"));
        return ResponseEntity.ok().body(vendor);
    }

    // vendor details api
    @PostMapping("vendor/details")
    public ResponseEntity<Vendor> vendorDetails(Principal principal, @RequestBody VendorDetailsRequest vendorDetailsRequest) throws NotFoundException {
        Vendor vendor = vendorRepository.findByPhone(principal.getName()).orElseThrow(() -> new NotFoundException("No such Vendor found!"));
        vendor.setAddressCity(vendorDetailsRequest.getAddress().getCity());
        vendor.setAddressState(vendorDetailsRequest.getAddress().getState());
        vendor.setAddressZipCode(vendorDetailsRequest.getAddress().getZipcode());
        vendor.setAddressCountry(vendorDetailsRequest.getAddress().getCountry());
        vendor.setAddressLine1(vendorDetailsRequest.getAddress().getAddressLine1());
        vendor.setAddressLine2(vendorDetailsRequest.getAddress().getAddressLine2());
        vendor.setAddressLine3(vendorDetailsRequest.getAddress().getAddressLine3());
        vendor.setPaymentByCash(vendorDetailsRequest.getPaymentPreferences().getPayByCash());
        vendor.setPaymentByUPI(vendorDetailsRequest.getPaymentPreferences().getPayByUpi());
        vendor.setPaymentUpiAddress(vendorDetailsRequest.getPaymentPreferences().getUpiAddress());
        vendor.setDeliveryByPickup(vendorDetailsRequest.getDeliveryPreferences().getDeliveryByPickup());
        vendor.setDeliveryByPartner(vendorDetailsRequest.getDeliveryPreferences().getDeliveryByPartner());
        vendorRepository.save(vendor);
        return ResponseEntity.ok().body(vendor);
    }

    @GetMapping("vendor/defaultCategories")
    public List<String> defaultCategories() {
        return ProductCategory.getValues();
    }

    @GetMapping("vendor/preferredCategories")
    public List<String> preferredCategories(Principal principal) throws NotFoundException {
        Vendor vendor = vendorRepository.findByPhone(principal.getName()).orElseThrow(() -> new NotFoundException("No such Vendor found!"));
        return vendor.getVendorProductCategories().stream().map(VendorProductCategory::getName).collect(Collectors.toList());
    }

    @PostMapping("vendor/preferredCategories")
    public void setPreferredCategories(Principal principal, @RequestBody ProductCategoriesRequest productCategoriesRequest) throws NotFoundException {
        Vendor vendor = vendorRepository.findByPhone(principal.getName()).orElseThrow(() -> new NotFoundException("No such Vendor found!"));
        for (String categoryName : productCategoriesRequest.getCategories()) {
            ProductCategory productCategory = ProductCategory.fromDisplayName(categoryName);
            if(vendor.getVendorProductCategories().stream().noneMatch(vendorProductCategory -> vendorProductCategory.getName().equals(categoryName))) {
                VendorProductCategory vendorProductCategory = new VendorProductCategory(vendor, productCategory, categoryName);
                vendorProductCategoryRepository.save(vendorProductCategory);
                vendor.addVendorProductCategory(vendorProductCategory);
                vendorRepository.save(vendor);
            }
        }
    }

    @PostMapping("vendor/product")
    public ResponseEntity<ProductResponse> createProduct(Principal principal, @RequestBody ProductRequest productRequest) throws NotFoundException {
        Vendor vendor = vendorRepository.findByPhone(principal.getName()).orElseThrow(() -> new NotFoundException("No such Vendor found!"));
        VendorProductCategory vendorProductCategory = vendor.getVendorProductCategories().stream().filter(vpc ->
                vpc.getName().equals(productRequest.getCategory())).findFirst().orElse(new VendorProductCategory(vendor,
                ProductCategory.fromDisplayName(productRequest.getCategory()), productRequest.getCategory()));
        vendorProductCategoryRepository.save(vendorProductCategory);
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setAvailableQty(productRequest.getAvailableQty());
        product.setRatePerUnit(productRequest.getRatePerUnit());
        product.setVendor(vendor);
        product.setVendorProductCategory(vendorProductCategory);
        productRepository.save(product);
        productRepository.flush();
        for(String base64EncodedImage: productRequest.getBase64EncodedImages()) {
            ProductImage productImage = new ProductImage();
            productImage.setProduct(product);
            productImage.setBase64EncodedImage(base64EncodedImage);
            productImageRepository.save(productImage);
            product.addProductImage(productImage);
        }
        vendorProductCategory.addProduct(product);
        vendor.addProduct(product);
        productRepository.save(product);
        vendorProductCategoryRepository.save(vendorProductCategory);
        vendorRepository.save(vendor);
        return ResponseEntity.ok().body(new ProductResponse(product));
    }
}
