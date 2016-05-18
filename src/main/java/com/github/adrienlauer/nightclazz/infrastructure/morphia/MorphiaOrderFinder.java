package com.github.adrienlauer.nightclazz.infrastructure.morphia;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import com.github.adrienlauer.nightclazz.rest.order.OrderFinder;
import com.github.adrienlauer.nightclazz.rest.order.OrderRepresentation;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.seedstack.business.assembler.FluentAssembler;
import org.seedstack.business.assembler.ModelMapper;
import org.seedstack.mongodb.morphia.MorphiaDatastore;

import javax.inject.Inject;
import java.util.List;

public class MorphiaOrderFinder implements OrderFinder {
    @Inject
    @MorphiaDatastore(clientName = "main", dbName = "ddd")
    private Datastore datastore;
    @Inject
    private FluentAssembler fluentAssembler;

    @Override
    public List<OrderRepresentation> findAllOrders() {
        Query<Order> query = datastore.find(Order.class);
        query.field("checkoutDate").notEqual(null);
        return fluentAssembler
                .assemble(query.asList())
                .with(ModelMapper.class)
                .to(OrderRepresentation.class);
    }

    @Override
    public List<OrderRepresentation> findCustomerOrders(long customerId) {
        Query<Order> query = datastore.find(Order.class);
        query.field("checkoutDate").notEqual(null);
        query.field("customerId").equal(customerId);
        return fluentAssembler
                .assemble(query.asList())
                .with(ModelMapper.class)
                .to(OrderRepresentation.class);
    }
}
