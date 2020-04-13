package com.shop.localzone.entity;

public class VendorDeliveryPreferenceSubRequest {
    private Boolean deliveryByPickup;
    private Boolean deliveryByPartner;

    public VendorDeliveryPreferenceSubRequest() {
    }

    public Boolean getDeliveryByPickup() {
        return deliveryByPickup;
    }

    public void setDeliveryByPickup(Boolean deliveryByPickup) {
        this.deliveryByPickup = deliveryByPickup;
    }

    public Boolean getDeliveryByPartner() {
        return deliveryByPartner;
    }

    public void setDeliveryByPartner(Boolean deliveryByPartner) {
        this.deliveryByPartner = deliveryByPartner;
    }
}
