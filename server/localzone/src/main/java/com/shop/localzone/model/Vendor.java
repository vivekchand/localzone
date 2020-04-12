package com.shop.localzone.model;

import javax.persistence.*;

@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "validation_otp")
    private String validationOtp;

    @Column(name = "is_validated")
    private Boolean isValidated;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "address_line_3")
    private String addressLine3;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_state")
    private String addressState;

    @Column(name = "address_zip_code")
    private String addressZipCode;

    @Column(name = "address_country")
    private String addressCountry;

    @Column(name = "payment_by_cash")
    private Boolean paymentByCash;

    @Column(name = "payment_by_upi")
    private Boolean paymentByUPI;

    @Column(name = "delivery_by_pickup")
    private Boolean deliveryByPickup;

    @Column(name = "delivery_by_partner")
    private Boolean deliveryByPartner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public Boolean getPaymentByCash() {
        return paymentByCash;
    }

    public void setPaymentByCash(Boolean paymentByCash) {
        this.paymentByCash = paymentByCash;
    }

    public Boolean getPaymentByUPI() {
        return paymentByUPI;
    }

    public void setPaymentByUPI(Boolean paymentByUPI) {
        this.paymentByUPI = paymentByUPI;
    }

    public Boolean getDeliveryByPickup() {
        return deliveryByPickup;
    }

    public void setDeliveryByPickup(Boolean deliveryByPickup) {
        this.deliveryByPickup = deliveryByPickup;
    }

    public Boolean getDeliveryByPartner() {
        return deliveryByPartner;
    }

    public void setDeliveryByPartner(Boolean deliveryByPartner) {
        this.deliveryByPartner = deliveryByPartner;
    }

    public String getValidationOtp() {
        return validationOtp;
    }

    public void setValidationOtp(String validationOtp) {
        this.validationOtp = validationOtp;
    }

    public Boolean getValidated() {
        return isValidated;
    }

    public void setValidated(Boolean validated) {
        isValidated = validated;
    }
}

