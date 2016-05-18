/**
 * Copyright (c) 2013-2015, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.adrienlauer.nightclazz.domain.model.order;

import org.seedstack.business.domain.BaseAggregateRoot;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order extends BaseAggregateRoot<Long> {
    private Long orderId;
    private Long customerId;
    private Date checkoutDate;
    private Map<Long, OrderItem> items = new HashMap<>();
    private double total = 0d;

    public Order(Long orderId, Long customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    @Override
    public Long getEntityId() {
        return orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void checkout() {
        checkoutDate = new Date();
    }

    public boolean isCompleted() {
        return checkoutDate != null;
    }

    public void addItem(OrderItem orderItem) {
        if (isCompleted()) {
            throw new IllegalStateException("Cannot add items to a completed order");
        }

        long productId = orderItem.getProductId();
        if (items.containsKey(productId)) {
            throw new IllegalStateException("An order item for product " + productId + " already exists");
        }

        items.put(productId, orderItem);
        total += orderItem.getQuantity() * orderItem.getUnitaryPrice();
    }

    public OrderItem removeItem(OrderItem orderItem) {
        if (isCompleted()) {
            throw new IllegalStateException("Cannot remove items from a completed order");
        }

        OrderItem removedItem = items.remove(orderItem.getProductId());
        if (removedItem == null) {
            throw new IllegalStateException("Item for product " + orderItem.getProductId() + "doesn't exists");
        }

        total -= orderItem.getQuantity() * orderItem.getUnitaryPrice();
        return orderItem;
    }

    public Collection<OrderItem> getItems() {
        return Collections.unmodifiableCollection(items.values());
    }

    public double getTotal() {
        return total;
    }
}
