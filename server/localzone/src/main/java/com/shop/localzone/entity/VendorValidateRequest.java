package com.shop.localzone.entity;

public class VendorValidateRequest {
    private Long vendorId;
    private String otp;

    public VendorValidateRequest(Long vendorId, String otp) {
        this.vendorId = vendorId;
        this.otp = otp;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
