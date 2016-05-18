package com.github.adrienlauer.nightclazz.rest.order;

import org.seedstack.business.finder.Finder;

import java.util.List;

@Finder
public interface OrderFinder {
    List<OrderRepresentation> findAllOrders();

    List<OrderRepresentation> findCustomerOrders(long customerId);
}
