package com.rs.demo.promotion.fact.coupon;

import java.math.BigDecimal;

/**
 * Created by wengxiaojun on 16/10/5.
 * 满减优惠券
 */
public class SubtractCoupon extends Coupon {


    public SubtractCoupon(long now_time, long begin_time, long end_time, long id, BigDecimal input_price) {
        super(now_time, begin_time, end_time, id, input_price);
    }

    public BigDecimal getTrigger_price() {
        return trigger_price;
    }

    public void setTrigger_price(BigDecimal trigger_price) {
        this.trigger_price = trigger_price;
    }

    public BigDecimal getPreferential_price() {
        return preferential_price;
    }

    public void setPreferential_price(BigDecimal preferential_price) {
        this.preferential_price = preferential_price;
    }

    //优惠券满多少金额触发
    private BigDecimal  trigger_price ;
    //优惠的金额
    private BigDecimal  preferential_price;





}
