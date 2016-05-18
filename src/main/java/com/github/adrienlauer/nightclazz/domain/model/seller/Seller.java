/**
 * Copyright (c) 2013-2015, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.github.adrienlauer.nightclazz.domain.model.seller;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.seedstack.business.domain.BaseAggregateRoot;

import java.util.Date;

@Entity
public class Seller extends BaseAggregateRoot<Long> {
    public static final int SENIORITY_THRESHOLD = 90;
    public static final long MILLISECONDS_IN_A_DAY = 1000 * 60 * 60 * 24;

    @Id
    private Long sellerId;
    private Date hireDate;
    private String bonusPolicy = BonusPolicy.PER_ITEM;
    private double monthlyBonus = 0;

    public Seller(long sellerId, Date hireDate) {
        this.sellerId = sellerId;
        this.hireDate = hireDate;
    }

    private Seller() {
        // required by Morphia
    }

    @Override
    public Long getEntityId() {
        return sellerId;
    }

    public void enablePercentageBonusPolicy() {
        if (new Date().getTime() - hireDate.getTime() < SENIORITY_THRESHOLD * MILLISECONDS_IN_A_DAY) {
            throw new IllegalStateException("Percentage bonus policy requires at least 3 years of seniority");
        }
        bonusPolicy = BonusPolicy.TOTAL_PERCENTAGE;
    }

    public void revertBonusPolicy() {
        bonusPolicy = BonusPolicy.PER_ITEM;
    }

    public String getBonusPolicy() {
        return bonusPolicy;
    }

    public void addToMonthlyBonus(double newBonus) {
        this.monthlyBonus += newBonus;
    }

    public void resetMonthlyBonus() {
        this.monthlyBonus = 0;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public double getMonthlyBonus() {
        return monthlyBonus;
    }
}
