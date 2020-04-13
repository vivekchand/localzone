package com.shop.localzone.controller;

import com.shop.localzone.JwtUtil;
import com.shop.localzone.entity.*;
import com.shop.localzone.model.Customer;
import com.shop.localzone.model.CustomerRequest;
import com.shop.localzone.model.Vendor;
import com.shop.localzone.repository.CustomerRepository;
import com.shop.localzone.repository.VendorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class PublicController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VendorRepository vendorRepository;

    // customer register api
    @PostMapping("customer/register")
    public ResponseEntity<RegisterResponse> signUpCustomer(@RequestBody CustomerRequest customerRequest) {
        if(customerRepository.findByPhone(customerRequest.getPhone()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone number already in use by a customer! Please login.");
        }
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setPhone(customerRequest.getPhone());

        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        customer.setValidationOtp(String.format("%d", num));
        // TODO: Send OTP here
        customer = customerRepository.save(customer);
        return ResponseEntity.ok().body(new RegisterResponse(customer.getId(), customer.getValidationOtp()));
    }

    // customer validate api
    @PostMapping("customer/validate")
    public ResponseEntity<VendorValidationResponse> validateCustomer(@RequestBody CustomerValidateRequest customerValidateRequest) throws NotFoundException {
        Customer customer = customerRepository.findById(customerValidateRequest.getCustomerId()).orElseThrow(() -> new NotFoundException("No such Customer found!"));
        if(customer.getValidationOtp().equals(customerValidateRequest.getOtp())) {
            customer.setValidated(true);
            customerRepository.save(customer);
            String jwtToken = jwtUtil.generateToken("customer#"+customer.getId()+"#"+customer.getPhone());
            return ResponseEntity.ok().body(new VendorValidationResponse(true, jwtToken));
        }
        return ResponseEntity.badRequest().body(new VendorValidationResponse(false, null));
    }


    // vendor register api
    @PostMapping("vendor/register")
    public ResponseEntity<RegisterResponse> signUpVendor(@RequestBody VendorSignUpRequest vendorSignUpRequest) {
        if(customerRepository.findByPhone(vendorSignUpRequest.getPhoneNo()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone number already in use by a vendor! Please login.");
        }
        Vendor vendor = new Vendor();
        vendor.setShopName(vendorSignUpRequest.getShopName());
        vendor.setPhone(vendorSignUpRequest.getPhoneNo());
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        vendor.setValidationOtp(String.format("%d", num));
        // TODO: Send OTP here
        vendor = vendorRepository.save(vendor);
        return ResponseEntity.ok().body(new RegisterResponse(vendor.getId(), vendor.getValidationOtp()));
    }

    // vendor validate api
    @PostMapping("vendor/validate")
    public ResponseEntity<VendorValidationResponse> validateVendor(@RequestBody VendorValidateRequest vendorValidateRequest) throws NotFoundException {
        Vendor vendor = vendorRepository.findById(vendorValidateRequest.getVendorId()).orElseThrow(() -> new NotFoundException("No such Vendor found!"));
        if(vendor.getValidationOtp().equals(vendorValidateRequest.getOtp())) {
            vendor.setValidated(true);
            vendorRepository.save(vendor);
            String jwtToken = jwtUtil.generateToken("vendor#"+vendor.getId()+"#"+vendor.getPhone());
            return ResponseEntity.ok().body(new VendorValidationResponse(true, jwtToken));
        }
        return ResponseEntity.badRequest().body(new VendorValidationResponse(false, null));
    }

    @GetMapping("vendor/{vendorId}/product")
    public List<ProductResponse> getProducts(@PathVariable("vendorId") Long vendorId) throws NotFoundException {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new NotFoundException("No such Vendor found!"));
        return vendor.getProducts().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

}
