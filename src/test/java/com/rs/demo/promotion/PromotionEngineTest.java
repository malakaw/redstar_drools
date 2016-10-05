package com.rs.demo.promotion;

import com.rs.demo.promotion.fact.CouponFact;
import com.rs.demo.promotion.fact.coupon.EverySubtractCoupon;
import com.rs.demo.promotion.fact.coupon.SubtractCoupon;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wengxiaojun on 16/10/5.
 */
public class PromotionEngineTest {

    private    CouponFact cfact = new CouponFact();
    private    PromotionEngine engine = new PromotionEngine();

    Map map_subtract_coupon = new TreeMap<BigDecimal,List<SubtractCoupon>>();

    public List setMap(SubtractCoupon sc)
    {
        List l = null;
        if(map_subtract_coupon.containsKey( sc.getPreferential_price()))
        {
            l = (List) map_subtract_coupon.get(sc.getPreferential_price());
        }
        else
        {
            l = new ArrayList();
        }
        l.add(sc);
        return l;
    }

    @Before
    public void init()
    {
        SubtractCoupon subC1 =
                new SubtractCoupon(System.currentTimeMillis(),         //now_time
                        System.currentTimeMillis()-2000,    //begin_time
                        System.currentTimeMillis()+3000,    //end_time
                        99,                                 //promotion_id
                        new BigDecimal(500.01));            //input_price
        subC1.setTrigger_price(new BigDecimal(100));
        subC1.setPreferential_price(new BigDecimal(10));

        SubtractCoupon subC2 =
                new SubtractCoupon(System.currentTimeMillis(),         //now_time
                        System.currentTimeMillis()-2000,    //begin_time
                        System.currentTimeMillis()+3000,    //end_time
                        99,                                 //promotion_id
                        new BigDecimal(300.01));             //input_price
        subC2.setTrigger_price(new BigDecimal(100));
        subC2.setPreferential_price(new BigDecimal(15));

        SubtractCoupon subC3 =
                new SubtractCoupon(System.currentTimeMillis(),         //now_time
                        System.currentTimeMillis()-2000,    //begin_time
                        System.currentTimeMillis()+3000,    //end_time
                        99,                                 //promotion_id
                        new BigDecimal(19.01));             //input_price
        subC3.setTrigger_price(new BigDecimal(100));
        subC3.setPreferential_price(new BigDecimal(5));

        SubtractCoupon subC4 =
                new SubtractCoupon(System.currentTimeMillis(),         //now_time
                        System.currentTimeMillis()-2000,    //begin_time
                        System.currentTimeMillis()+3000,    //end_time
                        99,                                 //promotion_id
                        new BigDecimal(300.01));             //input_price
        subC4.setTrigger_price(new BigDecimal(50));
        subC4.setPreferential_price(new BigDecimal(10));


        map_subtract_coupon.put(subC1.getPreferential_price(),setMap(subC1 ));
        map_subtract_coupon.put(subC2.getPreferential_price(),setMap(subC2 ));
        map_subtract_coupon.put(subC3.getPreferential_price(),setMap(subC3 ));
        map_subtract_coupon.put(subC4.getPreferential_price(),setMap(subC4 ));







        Map map_every_subtract_coupon = new TreeMap<BigDecimal,List<EverySubtractCoupon>>();

        cfact.setMap_subtract_coupon(map_subtract_coupon);


    }

    @Test
    public void test1()
    {
        // fork join计算
        long s3 = System.currentTimeMillis();
        engine.computeForkJoin(cfact);
        System.out.println("compute3耗时(毫秒):"+ (System.currentTimeMillis()-s3));
        long s4 = System.currentTimeMillis();
        engine.computeForkJoin(cfact);
        System.out.println("compute4耗时(毫秒):"+ (System.currentTimeMillis()-s4));
        long s5 = System.currentTimeMillis();
        engine.computeForkJoin(cfact);
        System.out.println("compute5耗时(毫秒):"+ (System.currentTimeMillis()-s5));
        long s6 = System.currentTimeMillis();
        engine.computeForkJoin(cfact);
        System.out.println("compute6耗时(毫秒):"+ (System.currentTimeMillis()-s6));

        s6 = System.currentTimeMillis();
        engine.computeForkJoin(cfact);
        System.out.println("compute6耗时(毫秒):"+ (System.currentTimeMillis()-s6));
        s6 = System.currentTimeMillis();
        engine.computeForkJoin(cfact);
        System.out.println("compute6耗时(毫秒):"+ (System.currentTimeMillis()-s6));
        s6 = System.currentTimeMillis();
        engine.computeForkJoin(cfact);
        System.out.println("compute6耗时(毫秒):"+ (System.currentTimeMillis()-s6));

        System.out.println("--------------");

        //普通计算
        long s0 = System.currentTimeMillis();
        engine.compute(cfact);
        System.out.println("compute1耗时(毫秒):"+ (System.currentTimeMillis()-s0));
        long s1 = System.currentTimeMillis();
        engine.compute(cfact);
        System.out.println("compute1耗时(毫秒):"+ (System.currentTimeMillis()-s1));
        long s2 = System.currentTimeMillis();
        engine.compute(cfact);
        System.out.println("compute2耗时(毫秒):"+ (System.currentTimeMillis()-s2));
        long s2_1 = System.currentTimeMillis();
        engine.compute(cfact);
        System.out.println("compute2_1耗时(毫秒):"+ (System.currentTimeMillis()-s2_1));
        s2_1 = System.currentTimeMillis();
        engine.compute(cfact);
        System.out.println("compute2_1耗时(毫秒):"+ (System.currentTimeMillis()-s2_1));
        s2_1 = System.currentTimeMillis();
        engine.compute(cfact);
        System.out.println("compute2_1耗时(毫秒):"+ (System.currentTimeMillis()-s2_1));
        s2_1 = System.currentTimeMillis();
        engine.compute(cfact);
        System.out.println("compute2_1耗时(毫秒):"+ (System.currentTimeMillis()-s2_1));
        s2_1 = System.currentTimeMillis();
        engine.compute(cfact);
        System.out.println("compute2_1耗时(毫秒):"+ (System.currentTimeMillis()-s2_1));






    }

}
