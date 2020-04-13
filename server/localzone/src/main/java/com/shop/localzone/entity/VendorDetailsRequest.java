package com.shop.localzone.entity;

public class VendorDetailsRequest {
    private VendorAddressSubRequest address;
    private VendorPaymentPreferenceSubRequest paymentPreferences;
    private VendorDeliveryPreferenceSubRequest deliveryPreferences;

    public VendorDetailsRequest() {
    }

    public VendorAddressSubRequest getAddress() {
        return address;
    }

    public void setAddress(VendorAddressSubRequest address) {
        this.address = address;
    }

    public VendorPaymentPreferenceSubRequest getPaymentPreferences() {
        return paymentPreferences;
    }

    public void setPaymentPreferences(VendorPaymentPreferenceSubRequest paymentPreferences) {
        this.paymentPreferences = paymentPreferences;
    }

    public VendorDeliveryPreferenceSubRequest getDeliveryPreferences() {
        return deliveryPreferences;
    }

    public void setDeliveryPreferences(VendorDeliveryPreferenceSubRequest deliveryPreferences) {
        this.deliveryPreferences = deliveryPreferences;
    }
}
