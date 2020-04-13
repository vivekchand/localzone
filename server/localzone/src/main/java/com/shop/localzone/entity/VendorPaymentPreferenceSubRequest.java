package com.shop.localzone.entity;

public class VendorPaymentPreferenceSubRequest {
    private Boolean payByCash;
    private Boolean payByUpi;
    private String upiAddress;

    public VendorPaymentPreferenceSubRequest(Boolean payByCash, Boolean payByUpi, String upiAddress) {
        this.payByCash = payByCash;
        this.payByUpi = payByUpi;
        this.upiAddress = upiAddress;
    }

    public Boolean getPayByCash() {
        return payByCash;
    }

    public void setPayByCash(Boolean payByCash) {
        this.payByCash = payByCash;
    }

    public Boolean getPayByUpi() {
        return payByUpi;
    }

    public void setPayByUpi(Boolean payByUpi) {
        this.payByUpi = payByUpi;
    }

    public String getUpiAddress() {
        return upiAddress;
    }

    public void setUpiAddress(String upiAddress) {
        this.upiAddress = upiAddress;
    }
}
