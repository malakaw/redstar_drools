package com.rs.demo.promotion.fact.coupon;

import java.math.BigDecimal;

/**
 * Created by wengxiaojun on 16/10/5.
 * 每满减优惠券
 */
public class EverySubtractCoupon extends SubtractCoupon {

    public EverySubtractCoupon(long now_time, long begin_time, long end_time, long id, BigDecimal input_price) {
        super(now_time, begin_time, end_time, id, input_price);
    }
}
