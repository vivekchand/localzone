package com.shop.localzone.entity;

public class VendorValidationResponse {
    private Boolean success;
    private String jwtToken;

    public VendorValidationResponse(Boolean success, String jwtToken) {
        this.success = success;
        this.jwtToken = jwtToken;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
