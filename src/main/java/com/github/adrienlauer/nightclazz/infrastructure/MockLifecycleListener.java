package com.github.adrienlauer.nightclazz.infrastructure;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import com.github.adrienlauer.nightclazz.domain.model.product.Product;
import com.github.adrienlauer.nightclazz.domain.model.seller.Seller;
import com.github.adrienlauer.nightclazz.domain.services.OrderingService;
import org.seedstack.business.domain.Repository;
import org.seedstack.mongodb.morphia.Morphia;
import org.seedstack.seed.LifecycleListener;

import javax.inject.Inject;
import java.util.Date;
import java.util.Random;

public class MockLifecycleListener implements LifecycleListener {
    @Inject
    @Morphia
    private Repository<Order, Long> orderRepository;
    @Inject
    @Morphia
    private Repository<Product, Long> productRepository;
    @Inject
    @Morphia
    private Repository<Seller, Long> sellerRepository;
    @Inject
    private OrderingService orderingService;

    @Override
    public void started() {
        clearData();

        // Sellers
        sellerRepository.persist(new Seller(1, new Date()));

        // Products
        productRepository.persist(new Product(1, "Product 1", 350));
        productRepository.persist(new Product(2, "Product 2", 420));
        productRepository.persist(new Product(3, "Product 3", 320));
        productRepository.persist(new Product(4, "Product 4", 100));
        productRepository.persist(new Product(5, "Product 5", 76));

        // Customer 1 orders
        orderRepository.persist(buildOrder(1, 1, 2));
        orderRepository.persist(buildOrder(2, 1, 5));
        orderRepository.persist(buildOrder(3, 1, 3));

        // Customer 2 orders
        orderRepository.persist(buildOrder(4, 2, 8));
    }

    @Override
    public void stopping() {
        clearData();
    }

    private Order buildOrder(long id, long customerId, int itemCount) {
        Order order = new Order(id, customerId);

        Random random = new Random();
        long productCount = productRepository.count();
        for (int i = 0; i < itemCount; i++) {
            Product product = productRepository.load((Math.abs(random.nextLong()) % productCount) + 1);
            orderingService.addProductToOrder(order, product, random.nextInt(5) + 1);
        }

        order.checkout();

        return order;
    }

    private void clearData() {
        orderRepository.clear();
        productRepository.clear();
        sellerRepository.clear();
    }
}
