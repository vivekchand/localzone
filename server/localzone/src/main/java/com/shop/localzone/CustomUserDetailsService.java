package com.shop.localzone;

import com.shop.localzone.entity.CustomerUserDetails;
import com.shop.localzone.entity.VendorUserDetails;
import com.shop.localzone.model.Customer;
import com.shop.localzone.model.Vendor;
import com.shop.localzone.repository.CustomerRepository;
import com.shop.localzone.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String typeHashIdHashPhone) throws UsernameNotFoundException {
        String[] str = typeHashIdHashPhone.split("#");
        String type = str[0];
        String id = str[1];
        String phone = str[2];
        if(type.contentEquals("vendor")) {
            Vendor vendor = vendorRepository.findById(Long.valueOf(id)).orElseThrow(() -> new UsernameNotFoundException("No such vendor found!"));
            return new VendorUserDetails(vendor);
        } else if(type.contentEquals("customer")) {
            Customer customer = customerRepository.findById(Long.valueOf(id)).orElseThrow(() -> new UsernameNotFoundException("No such customer found!"));
            return new CustomerUserDetails(customer);
        }
        throw new RuntimeException("Invalid user type");
    }
}
