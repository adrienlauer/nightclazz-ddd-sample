/**
 * Copyright (c) 2013-2015, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.adrienlauer.nightclazz.domain.model.seller;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import com.github.adrienlauer.nightclazz.domain.model.order.OrderItem;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ItemBonusPolicyTest {
    private static final long CUSTOMER_ID = 200L;
    private static final long ORDER_ID = 100L;

    private ItemBonusPolicy underTest = new ItemBonusPolicy();

    @Test
    public void bonusShouldBeEqualToTheNumberOfItems() {
        assertBonus(1, 2);
        assertBonus(7, 5);
        assertBonus(0, 0);
    }

    private void assertBonus(int quantity, int itemSize) {
        double bonus = underTest.computeBonus(prepareOrder(quantity, itemSize));
        Assertions.assertThat(bonus).isEqualTo(quantity * itemSize * 10);
    }

    private Order prepareOrder(int quantity, int itemSize) {
        Order order = new Order(ORDER_ID, CUSTOMER_ID);
        for (int i = 0; i < itemSize; i++) {
            order.addItem(new OrderItem(i, quantity, 50d));
        }
        return order;
    }
}
