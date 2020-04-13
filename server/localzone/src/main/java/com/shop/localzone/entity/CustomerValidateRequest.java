package com.shop.localzone.entity;

public class CustomerValidateRequest {
    private Long customerId;
    private String otp;

    public CustomerValidateRequest(Long customerId, String otp) {
        this.customerId = customerId;
        this.otp = otp;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
