package com.shop.localzone.entity;

public class RegisterResponse {
    private Long id;
    private String msg;
    private String otp;

    public RegisterResponse(Long id, String otp) {
        this.id = id;
        this.msg = "Validate sent OTP!";
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
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
