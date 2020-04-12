package com.shop.localzone.entity;

public class VendorRegisterResponse {
    private Long vendorId;
    private String msg;

    public VendorRegisterResponse(Long vendorId) {
        this.vendorId = vendorId;
        this.msg = "Validate sent OTP!";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
}
