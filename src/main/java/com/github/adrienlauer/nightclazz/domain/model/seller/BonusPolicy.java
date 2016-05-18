/**
 * Copyright (c) 2013-2015, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.adrienlauer.nightclazz.domain.model.seller;

import com.github.adrienlauer.nightclazz.domain.model.order.Order;
import org.seedstack.business.domain.DomainPolicy;

@DomainPolicy
public interface BonusPolicy {
    String PER_ITEM = "item";
    String TOTAL_PERCENTAGE = "percentage";

    double computeBonus(Order order);
}
