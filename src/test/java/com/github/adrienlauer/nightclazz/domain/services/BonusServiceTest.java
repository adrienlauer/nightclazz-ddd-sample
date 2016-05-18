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
import org.junit.Before;
import org.junit.Test;
import org.seedstack.business.domain.DomainRegistry;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BonusServiceTest {
    private static final long ORDER_ID = 1111L;
    private static final long CUSTOMER_ID = 222L;
    private static final double BONUS_VALUE = 100D;

    private BonusService underTest;
    private DomainRegistry domainRegistry;

    @Before
    public void before() {
        domainRegistry = mock(DomainRegistry.class);
        underTest = new BonusServiceImpl(domainRegistry);
    }

    @Test
    public void updateBonusShouldModifyTheSeller() {
        Seller seller = mock(Seller.class);
        Order order = new Order(ORDER_ID, CUSTOMER_ID);
        mockBonusPolicy(seller, order);

        underTest.updateSellerBonus(seller, order);

        then(seller).should().addToMonthlyBonus(BONUS_VALUE);
    }

    private void mockBonusPolicy(Seller seller, Order order) {
        BonusPolicy bonusPolicy = mock(BonusPolicy.class);
        when(domainRegistry.getPolicy(BonusPolicy.class, seller.getBonusPolicy())).thenReturn(bonusPolicy);
        when(bonusPolicy.computeBonus(order)).thenReturn(BONUS_VALUE);
    }
}
