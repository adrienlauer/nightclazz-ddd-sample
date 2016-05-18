package com.github.adrienlauer.nightclazz.domain.model.order;

import org.mongodb.morphia.annotations.Embedded;
import org.seedstack.business.domain.BaseValueObject;

@Embedded
public class OrderItem extends BaseValueObject {
    private long productId;
    private int quantity;
    private double unitaryPrice;

    public OrderItem(long productId, int quantity, double unitaryPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitaryPrice = unitaryPrice;
    }

    private OrderItem() {
        // require by Morphia
    }

    public int getQuantity() {
        return quantity;
    }

    public long getProductId() {
        return productId;
    }

    public double getUnitaryPrice() {
        return unitaryPrice;
    }
}
