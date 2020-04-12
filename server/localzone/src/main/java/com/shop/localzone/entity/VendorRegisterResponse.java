package com.shop.localzone.entity;

public class VendorRegisterResponse {
    private Long id;
    private String msg;

    public VendorRegisterResponse(Long id) {
        this.id = id;
        this.msg = "Validate sent OTP!";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
