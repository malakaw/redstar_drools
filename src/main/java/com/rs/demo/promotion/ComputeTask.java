package com.rs.demo.promotion;

import com.rs.demo.promotion.fact.coupon.Coupon;

import java.math.BigDecimal;
import java.util.concurrent.RecursiveTask;

/**
 * Created by wengxiaojun on 16/10/5.
 */
public class ComputeTask  extends RecursiveTask<BigDecimal> {


    private int coupon_type ;
    private Coupon coupon = null;

    public ComputeTask(int coupon_type,Coupon coupon)
    {
        this.coupon_type = coupon_type;
        this.coupon      = coupon;
    }




    protected BigDecimal compute() {
        try {
            PromotionSessions.getInstance().getSession(coupon_type).execute(coupon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coupon.getBenefit_price();
    }

}
