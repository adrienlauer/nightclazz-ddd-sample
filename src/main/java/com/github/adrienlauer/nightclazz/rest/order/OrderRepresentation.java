package com.github.adrienlauer.nightclazz.rest.order;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import org.seedstack.business.assembler.DtoOf;
import org.seedstack.seed.rest.hal.HalRepresentation;

import java.util.Date;

@DtoOf(Order.class)
public class OrderRepresentation extends HalRepresentation {
    private Long orderId;
    private Long customerId;
    private Date checkoutDate;
    private double total;

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
}
