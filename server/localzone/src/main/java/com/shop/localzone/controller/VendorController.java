package com.shop.localzone.controller;

import com.shop.localzone.entity.VendorValidationResponse;
import com.shop.localzone.model.Vendor;
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
    public ResponseEntity<VendorValidationResponse> vendorDetails(Principal principal) throws NotFoundException {
        Vendor vendor = vendorRepository.findByPhone(principal.getName()).orElseThrow(() -> new NotFoundException("No such Vendor found!"));
        return null;
    }


}
