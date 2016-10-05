package com.rs.demo.promotion.fact.coupon;

import java.math.BigDecimal;

/**
 * Created by wengxiaojun on 16/10/5.
 */
public class Coupon {
    public long getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(long begin_time) {
        this.begin_time = begin_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBenefit_price() {
        return benefit_price;
    }

    public void setBenefit_price(BigDecimal benefit_price) {
        this.benefit_price = benefit_price;
    }

    public BigDecimal getInput_price() {
        return input_price;
    }

    public void setInput_price(BigDecimal input_price) {
        this.input_price = input_price;
    }

    public long getNow_time() {
        return now_time;
    }

    public void setNow_time(long now_time) {
        this.now_time = now_time;
    }


    public Coupon(long now_time, long begin_time, long end_time, long id, BigDecimal input_price) {
        this.now_time = now_time;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.id = id;
        this.input_price = input_price;
    }

    //当前时间
    private  long now_time;
    //优惠券生效时间
    private long begin_time;
    //优惠券失效时间
    private long end_time;
    //优惠券id
    private long id;
    //输入价格
    private BigDecimal input_price;

    //计算完可以优惠的金额
    private BigDecimal benefit_price = BigDecimal.ZERO;

}
