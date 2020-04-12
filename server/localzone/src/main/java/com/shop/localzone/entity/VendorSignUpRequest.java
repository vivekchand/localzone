package com.shop.localzone.entity;

public class VendorSignUpRequest {
    private String shopName;
    private String phoneNo;

    public VendorSignUpRequest() {
    }

    public VendorSignUpRequest(String shopName, String phoneNo) {
        this.shopName = shopName;
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return shopName;
    }

    public String getShopName() {
        return phoneNo;
    }
}
