package com.shop.localzone.repository;

import com.shop.localzone.model.VendorProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorProductCategoryRepository extends JpaRepository<VendorProductCategory, Long> {
}
