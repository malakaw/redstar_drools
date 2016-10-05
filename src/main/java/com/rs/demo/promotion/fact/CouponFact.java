package com.rs.demo.promotion.fact;

import com.rs.demo.promotion.fact.coupon.EverySubtractCoupon;
import com.rs.demo.promotion.fact.coupon.SubtractCoupon;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wengxiaojun on 16/10/5.
 */
public class CouponFact {


    //满减券  [这里使用treemap是为了按照trigger_price排序]  map ,key=>优惠的大小
    private Map map_subtract_coupon = new TreeMap<BigDecimal,List<SubtractCoupon>>();

    //每满减券
    private Map map_every_subtract_coupon = new TreeMap<BigDecimal,List<EverySubtractCoupon>>();

    public Map getMap_subtract_coupon() {
        return map_subtract_coupon;
    }

    public void setMap_subtract_coupon(Map map_subtract_coupon) {
        this.map_subtract_coupon = map_subtract_coupon;
    }

    public Map getMap_every_subtract_coupon() {
        return map_every_subtract_coupon;
    }

    public void setMap_every_subtract_coupon(Map map_every_subtract_coupon) {
        this.map_every_subtract_coupon = map_every_subtract_coupon;
    }




//     //优惠总金额
//    private BigDecimal benefit_count;
//
//
//    public BigDecimal getBenefit_count() {
//        return benefit_count;
//    }
//
//    public void setBenefit_count(BigDecimal benefit_count) {
//        this.benefit_count = benefit_count;
//    }

}
