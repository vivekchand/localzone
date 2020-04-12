package com.shop.localzone.controller;

import com.shop.localzone.entity.VendorRegisterResponse;
import com.shop.localzone.entity.VendorSignUpRequest;
import com.shop.localzone.entity.VendorValidateRequest;
import com.shop.localzone.entity.VendorValidationResponse;
import com.shop.localzone.model.Vendor;
import com.shop.localzone.repository.VendorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
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
    public ResponseEntity<VendorRegisterResponse> signUpVendor(@RequestBody VendorSignUpRequest vendorSignUpRequest) {
        Vendor vendor = new Vendor();
        vendor.setShopName(vendorSignUpRequest.getShopName());
        vendor.setPhone(vendorSignUpRequest.getPhoneNo());
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        vendor.setValidationOtp(String.format("%d", num));
        // TODO: Send OTP here
        vendor = vendorRepository.save(vendor);
        return ResponseEntity.ok().body(new VendorRegisterResponse(vendor.getId()));
    }

    // vendor register api
    @PostMapping("vendor/validate")
    public ResponseEntity<VendorValidationResponse> validateVendor(@RequestBody VendorValidateRequest vendorValidateRequest) throws NotFoundException {
        Vendor vendor = vendorRepository.findById(vendorValidateRequest.getVendorId()).orElseThrow(() -> new NotFoundException("No such Vendor found!"));
        if(vendor.getValidationOtp().equals(vendorValidateRequest.getOtp())) {
            vendor.setValidated(true);
            vendorRepository.save(vendor);
            return ResponseEntity.ok().body(new VendorValidationResponse(true));
        }
        return ResponseEntity.badRequest().body(new VendorValidationResponse(false));
    }
}
