package com.github.adrienlauer.nightclazz.rest.order;

import org.seedstack.seed.rest.hal.HalRepresentation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderDetailsRepresentation extends HalRepresentation {
    private Long orderId;
    private Long customerId;
    private Date checkoutDate;
    private double total;
    private Set<OrderItemRepresentation> items = new HashSet<>();

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<OrderItemRepresentation> getItems() {
        return items;
    }

    public void setItems(Set<OrderItemRepresentation> items) {
        this.items = items;
    }
}
