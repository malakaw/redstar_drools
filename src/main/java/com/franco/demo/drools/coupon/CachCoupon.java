package com.franco.demo.drools.coupon;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by malaka on 16/9/30.
 */
public class CachCoupon extends Coupon {


    public CachCoupon(long date_effective, long date_expires, String name, BigDecimal count_preferential) {
        super(date_effective, date_expires, name);
        this.count_preferential = count_preferential;
    }

    public void setCount_preferential(BigDecimal count_preferential) {
        this.count_preferential = count_preferential;
    }

    //优惠的金额
    private BigDecimal  count_preferential;



}
