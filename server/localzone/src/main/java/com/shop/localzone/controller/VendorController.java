package com.shop.localzone.controller;

import com.shop.localzone.entity.VendorSignUp;
import com.shop.localzone.model.Vendor;
import com.shop.localzone.repository.VendorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

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

    // vendor register api
    @PostMapping("vendor/register")
    public Vendor signUpVendor(@RequestBody VendorSignUp vendorSignUp) {
        Vendor vendor = new Vendor();
        vendor.setShopName(vendorSignUp.getShopName());
        vendor.setPhone(vendorSignUp.getPhoneNo());
        // TODO: Send OTP here
        return this.vendorRepository.save(vendor);
    }
}
