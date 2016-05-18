package com.github.adrienlauer.nightclazz.rest.order;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import com.github.adrienlauer.nightclazz.domain.model.order.OrderItem;
import com.github.adrienlauer.nightclazz.domain.model.product.Product;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.seedstack.business.assembler.modelmapper.ModelMapperAssembler;
import org.seedstack.business.domain.Repository;

import javax.inject.Inject;

public class OrderDetailsAssembler extends ModelMapperAssembler<Order, OrderDetailsRepresentation> {
    @Inject
    private Repository<Product, Long> productRepository;

    @Override
    protected void configureAssembly(ModelMapper modelMapper) {
        modelMapper.addConverter(new AbstractConverter<OrderItem, OrderItemRepresentation>() {
            @Override
            protected OrderItemRepresentation convert(OrderItem source) {
                OrderItemRepresentation target = new OrderItemRepresentation();
                target.setQuantity(source.getQuantity());
                target.setUnitaryPrice(source.getUnitaryPrice());
                target.setProduct(lookupProductDescription(source.getProductId()));
                return target;
            }
        });
    }

    private String lookupProductDescription(long productId) {
        Product product = productRepository.load(productId);
        if (product == null) {
            throw new IllegalStateException("Invalid product " + productId);
        }
        return product.getDescription();
    }

    @Override
    protected void configureMerge(ModelMapper modelMapper) {
        // not used for now
    }
}
