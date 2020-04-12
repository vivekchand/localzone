package com.shop.localzone.entity;

public class VendorValidationResponse {
    private Boolean success;

    public VendorValidationResponse(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
