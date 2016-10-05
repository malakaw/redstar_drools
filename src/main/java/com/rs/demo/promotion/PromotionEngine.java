package com.rs.demo.promotion;

import com.rs.demo.promotion.fact.CouponFact;
import com.rs.demo.promotion.fact.coupon.EverySubtractCoupon;
import com.rs.demo.promotion.fact.coupon.SubtractCoupon;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by wengxiaojun on 16/10/5.
 */
public class PromotionEngine {


    /**
     * 计算优惠金额,注意执行顺序
     */
    public BigDecimal compute(CouponFact cfact)
    {

        //[step 1]计算满减优惠券
        BigDecimal benefit_count = BigDecimal.ZERO;
        TreeMap<BigDecimal,List<SubtractCoupon>>  map_subtract_coupon = (TreeMap<BigDecimal, List<SubtractCoupon>>) cfact.getMap_subtract_coupon();
        for(Map.Entry<BigDecimal,List<SubtractCoupon>> entry : map_subtract_coupon.entrySet()) {
            for(SubtractCoupon sc : entry.getValue())
            {
                //System.out.println("----");
                try {
                    PromotionSessions.getInstance().getSession(PromotionSessions.SUBTRACT_COUPON).execute(sc);
                 //   System.out.println("优惠金额:"+sc.getBenefit_price());
                    benefit_count = benefit_count.add(sc.getBenefit_price());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("subtract 优惠:"+benefit_count);

        //[step 2]计算每满减优惠券
        cfact.getMap_every_subtract_coupon();

        //step.....


        return null;
    }


    public BigDecimal computeForkJoin(CouponFact cfact)
    {

        //[step 1]计算满减优惠券
        BigDecimal benefit_count = BigDecimal.ZERO;
        TreeMap<BigDecimal,List<SubtractCoupon>>  map_subtract_coupon = (TreeMap<BigDecimal, List<SubtractCoupon>>) cfact.getMap_subtract_coupon();

        //定义task
        List<ComputeTask> listTask = new ArrayList<ComputeTask>();
        for(Map.Entry<BigDecimal,List<SubtractCoupon>> entry : map_subtract_coupon.entrySet()) {
            for(SubtractCoupon sc : entry.getValue())
            {
                listTask.add(new ComputeTask(PromotionSessions.SUBTRACT_COUPON,sc));
            }
        }

        //执行task
        for(ComputeTask ct : listTask)
        {
            ct.fork();
        }

        //等待task执行完成
        for(ComputeTask ct : listTask)
        {
            benefit_count = benefit_count.add(ct.join());
        }



        System.out.println("subtract 优惠:"+benefit_count);


        return null;
    }



    //TODO 查找可用的优惠券
    //查找可用的优惠券
    public Collection find_coupon_ids()
    {
        return null;
    }

}
