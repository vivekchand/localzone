package com.shop.localzone.repository;

import com.shop.localzone.model.Customer;
import com.shop.localzone.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Vendor> findByPhone(String phone);
}
