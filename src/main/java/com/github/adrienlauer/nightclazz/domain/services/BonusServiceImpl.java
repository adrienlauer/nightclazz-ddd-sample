/**
 * Copyright (c) 2013-2015, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.adrienlauer.nightclazz.domain.services;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import com.github.adrienlauer.nightclazz.domain.model.seller.BonusPolicy;
import com.github.adrienlauer.nightclazz.domain.model.seller.Seller;
import org.seedstack.business.domain.DomainRegistry;

import javax.inject.Inject;

class BonusServiceImpl implements BonusService {
    private final DomainRegistry domainRegistry;

    @Inject
    public BonusServiceImpl(DomainRegistry domainRegistry) {
        this.domainRegistry = domainRegistry;
    }

    public void updateSellerBonus(Seller seller, Order order) {
        BonusPolicy bonusPolicy = domainRegistry.getPolicy(BonusPolicy.class, seller.getBonusPolicy());
        double orderBonus = bonusPolicy.computeBonus(order);
        seller.addToMonthlyBonus(orderBonus);
    }
}
