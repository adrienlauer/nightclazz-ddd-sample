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

public class TotalBonusPolicyTest {
    private TotalBonusPolicy underTest = new TotalBonusPolicy();

    @Test
    public void bonusShouldBeEqualToTheNumberOfItems() {
        assertBonus(0);
        assertBonus(10);
        assertBonus(33);
    }

    private void assertBonus(double total) {
        double bonus = underTest.computeBonus(prepareOrder(total));
        Assertions.assertThat(bonus).isEqualTo(total * .02);
    }

    private Order prepareOrder(double total) {
        Order order = new Order(1L, 2L);
        order.addItem(new OrderItem(1, 1, total));
        return order;
    }
}
