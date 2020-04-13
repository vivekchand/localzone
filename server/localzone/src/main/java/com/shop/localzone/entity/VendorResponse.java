package com.shop.localzone.entity;

import com.shop.localzone.model.Vendor;

public class VendorResponse {
    private Long id;
    private String shopName;
    private String phone;
    private Boolean isValidated;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressCity;
    private String addressState;
    private String addressZipcode;
    private String addressCountry;
    private Boolean paymentByCash;
    private Boolean paymentByUPI;
    private String paymentUpiAddress;
    private Boolean deliveryByPickup;
    private Boolean deliveryByPartner;

    public VendorResponse(Vendor vendor) {
        this.id = vendor.getId();
        this.shopName = vendor.getShopName();
        this.phone = vendor.getPhone();
        this.isValidated = vendor.getValidated();
        this.addressLine1 = vendor.getAddressLine1();
        this.addressLine2 = vendor.getAddressLine2();
        this.addressLine3 = vendor.getAddressLine3();
        this.addressCity = vendor.getAddressCity();
        this.addressState = vendor.getAddressState();
        this.addressZipcode = vendor.getAddressZipCode();
        this.addressCountry = vendor.getAddressCountry();
        this.paymentByCash = vendor.getPaymentByCash();
        this.paymentByUPI = vendor.getPaymentByUPI();
        this.paymentUpiAddress = vendor.getPaymentUpiAddress();
        this.deliveryByPartner = vendor.getDeliveryByPartner();
        this.deliveryByPickup = vendor.getDeliveryByPickup();
    }

    public Long getId() {
        return id;
    }

    public String getShopName() {
        return shopName;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getValidated() {
        return isValidated;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public String getAddressZipcode() {
        return addressZipcode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public Boolean getPaymentByCash() {
        return paymentByCash;
    }

    public Boolean getPaymentByUPI() {
        return paymentByUPI;
    }

    public String getPaymentUpiAddress() {
        return paymentUpiAddress;
    }

    public Boolean getDeliveryByPickup() {
        return deliveryByPickup;
    }

    public Boolean getDeliveryByPartner() {
        return deliveryByPartner;
    }
}
