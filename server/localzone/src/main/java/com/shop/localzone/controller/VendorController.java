package com.shop.localzone.controller;

import com.shop.localzone.entity.ProductCategoriesRequest;
import com.shop.localzone.entity.VendorDetailsRequest;
import com.shop.localzone.model.ProductCategory;
import com.shop.localzone.model.Vendor;
import com.shop.localzone.model.VendorProductCategory;
import com.shop.localzone.repository.VendorProductCategoryRepository;
import com.shop.localzone.repository.VendorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/app/")
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorProductCategoryRepository vendorProductCategoryRepository;

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

    @PostMapping("vendor/preferredCategories")
    public void categories(Principal principal, @RequestBody ProductCategoriesRequest productCategoriesRequest) throws NotFoundException {
        Vendor vendor = vendorRepository.findByPhone(principal.getName()).orElseThrow(() -> new NotFoundException("No such Vendor found!"));
        for (String categoryName : productCategoriesRequest.getCategories()) {
            ProductCategory existingCategory;
            try {
                existingCategory = ProductCategory.fromDisplayName(categoryName);
            } catch (Exception e) {
                existingCategory = null;
            }
            if(vendor.getVendorProductCategories().stream().noneMatch(vendorProductCategory -> vendorProductCategory.getName().equals(categoryName))) {
                VendorProductCategory vendorProductCategory = new VendorProductCategory();
                vendorProductCategory.setVendor(vendor);
                vendorProductCategory.setName(categoryName);
                if (existingCategory != null) {
                    vendorProductCategory.setProductCategory(existingCategory);
                }
                vendorProductCategoryRepository.save(vendorProductCategory);
                vendor.addVendorProductCategory(vendorProductCategory);
                vendorRepository.save(vendor);
            }
        }
    }
}
