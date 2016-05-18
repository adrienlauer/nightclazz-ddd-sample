package com.github.adrienlauer.nightclazz.domain.model.product;

import org.seedstack.business.domain.BaseAggregateRoot;

public class Product extends BaseAggregateRoot<Long> {
    private Long productId;
    private String description;
    private double price;

    public Product(long productId, String description, double price) {
        this.productId = productId;
        this.description = description;
        this.price = price;
    }

    @Override
    public Long getEntityId() {
        return productId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}