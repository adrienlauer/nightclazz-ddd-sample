package com.github.adrienlauer.nightclazz.application;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import com.github.adrienlauer.nightclazz.domain.model.seller.Seller;
import com.github.adrienlauer.nightclazz.domain.services.BonusService;
import org.seedstack.business.domain.Repository;
import org.seedstack.mongodb.morphia.Morphia;

import javax.inject.Inject;
import java.util.Optional;

class CheckoutServiceImpl implements CheckoutService {
    @Inject
    @Morphia
    Repository<Seller, Long> sellerRepository;
    @Inject
    @Morphia
    Repository<Order, Long> orderRepository;
    @Inject
    BonusService bonusService;

    @Override
    public void checkout(Order order) throws CheckoutException {
        Optional<Seller> authenticatedSeller = getAuthenticatedSeller();
        if (authenticatedSeller.isPresent()) {
            // Do the checkout
            order.checkout();
            orderRepository.save(order);

            // Update seller info
            Seller seller = authenticatedSeller.get();
            bonusService.updateSellerBonus(seller, order);
            sellerRepository.save(seller);
        } else {
            throw new CheckoutException("No user authenticated or current user is not a seller");
        }
    }

    public Optional<Seller> getAuthenticatedSeller() {
        return Optional.of(sellerRepository.load(1L));
    }
}
