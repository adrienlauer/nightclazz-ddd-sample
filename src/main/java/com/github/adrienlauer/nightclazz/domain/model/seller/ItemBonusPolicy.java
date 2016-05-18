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

import javax.inject.Named;

@Named(BonusPolicy.PER_ITEM)
class ItemBonusPolicy implements BonusPolicy {
    private static final int ITEM_BONUS = 10;

    @Override
    public double computeBonus(Order order) {
        return order.getItems().stream().mapToInt(OrderItem::getQuantity).sum() * ITEM_BONUS;
    }
}
