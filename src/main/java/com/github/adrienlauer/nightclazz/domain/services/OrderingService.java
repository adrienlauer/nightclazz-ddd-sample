package com.github.adrienlauer.nightclazz.domain.services;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import com.github.adrienlauer.nightclazz.domain.model.product.Product;
import org.seedstack.business.Service;

@Service
public interface OrderingService {
    void addProductToOrder(Order order, Product product, int quantity);
}
