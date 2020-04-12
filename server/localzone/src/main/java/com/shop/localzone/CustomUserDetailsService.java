package com.shop.localzone;

import com.shop.localzone.entity.CustomUserDetails;
import com.shop.localzone.model.Vendor;
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

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Vendor vendor = vendorRepository.findByPhone(phone).orElseThrow(() -> new UsernameNotFoundException("No such vendor found!"));
        return new CustomUserDetails(vendor);
    }
}
