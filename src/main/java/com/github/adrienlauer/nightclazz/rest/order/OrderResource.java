package com.github.adrienlauer.nightclazz.rest.order;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import org.seedstack.business.assembler.FluentAssembler;
import org.seedstack.business.assembler.ModelMapper;
import org.seedstack.business.domain.Repository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/orders")
public class OrderResource {
    @Inject
    private OrderFinder orderFinder;
    @Inject
    private Repository<Order, Long> orderRepository;
    @Inject
    private FluentAssembler fluentAssembler;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<OrderRepresentation> listOrders(@QueryParam("customerId") Long customerId) {
        if (customerId == null) {
            return orderFinder.findAllOrders();
        } else {
            return orderFinder.findCustomerOrders(customerId);
        }
    }

    @GET
    @Path("/{orderId}")
    @Produces({MediaType.APPLICATION_JSON})
    public OrderRepresentation getOrderDetails(@PathParam("orderId") Long orderId) {
        Order order = orderRepository.load(orderId);
        if (order == null) {
            throw new NotFoundException("Order " + orderId + " not found");
        }
        return fluentAssembler.assemble(order).with(ModelMapper.class).to(OrderRepresentation.class);
    }
}
