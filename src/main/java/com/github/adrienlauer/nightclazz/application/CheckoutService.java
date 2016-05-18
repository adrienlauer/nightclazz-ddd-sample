package com.github.adrienlauer.nightclazz.application;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import org.seedstack.business.Service;

@Service
public interface CheckoutService {
    void checkout(Order order) throws CheckoutException;
}
