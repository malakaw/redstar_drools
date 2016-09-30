package com.franco.demo.drools.coupon;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Created by malaka on 16/9/30.
 */
public class SubtractCoupon extends Coupon{


    public SubtractCoupon(long date_effective, long date_expires, String name, BigDecimal count_trigger, BigDecimal count_preferential) {
        super(date_effective, date_expires, name);
        this.count_trigger = count_trigger;
        this.count_preferential = count_preferential;
    }

    public BigDecimal getCount_trigger() {
        return count_trigger;
    }

    public void setCount_trigger(BigDecimal count_trigger) {
        this.count_trigger = count_trigger;
    }

    public BigDecimal getCount_preferential() {
        return count_preferential;
    }

    public void setCount_preferential(BigDecimal count_preferential) {
        this.count_preferential = count_preferential;
    }

    //优惠券满多少金额触发
    private BigDecimal  count_trigger ;
    //优惠的金额
    private BigDecimal  count_preferential;



}
