package com.shop.localzone.controller;

import com.shop.localzone.JwtUtil;
import com.shop.localzone.entity.VendorRegisterResponse;
import com.shop.localzone.entity.VendorSignUpRequest;
import com.shop.localzone.entity.VendorValidateRequest;
import com.shop.localzone.entity.VendorValidationResponse;
import com.shop.localzone.model.Vendor;
import com.shop.localzone.repository.VendorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

@RestController
@RequestMapping("/")
public class VendorOnboardController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private VendorRepository vendorRepository;

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
            String jwtToken = jwtUtil.generateToken(vendor.getPhone());
            return ResponseEntity.ok().body(new VendorValidationResponse(true, jwtToken));
        }
        return ResponseEntity.badRequest().body(new VendorValidationResponse(false, null));
    }

}
