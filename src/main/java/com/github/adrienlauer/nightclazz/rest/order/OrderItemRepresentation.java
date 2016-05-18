package com.github.adrienlauer.nightclazz.rest.order;

import org.seedstack.seed.rest.hal.HalRepresentation;

public class OrderItemRepresentation extends HalRepresentation {
    private String product;
    private int quantity;
    private double unitaryPrice;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }
}
