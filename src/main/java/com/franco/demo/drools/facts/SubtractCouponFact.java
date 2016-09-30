package com.franco.demo.drools.facts;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by malaka on 16/9/30.
 */
public class SubtractCouponFact   {


    public SubtractCouponFact(BigDecimal in_order_price  ) {
        this.in_order_price = in_order_price;
        this.now = new Date().getTime();
    }

    //输入订单价格
    private BigDecimal in_order_price;
    //输出最后订单价格
    private BigDecimal out_result_price;

    //当前时间(单位:毫秒)
    private long now ;


    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }
    public BigDecimal getIn_order_price() {
        return in_order_price;
    }

    public void setIn_order_price(BigDecimal in_order_price) {
        this.in_order_price = in_order_price;
    }

    public BigDecimal getOut_result_price() {
        return out_result_price;
    }

    public void setOut_result_price(BigDecimal out_result_price) {
        this.out_result_price = out_result_price;
    }






}
