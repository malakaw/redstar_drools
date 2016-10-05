package com.rs.demo.promotion.fact.coupon;

import com.franco.demo.drools.facts.SubtractCouponFact;
import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by wengxiaojun on 16/10/5.
 */
public class SubtractCouponTest {

    @Test
    public void test1()
    {
        //如果使用date-expires or date-effective需要这个配置
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("drools/coupons/subtract.drl"), ResourceType.DRL);
        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
        //test 1活动期内,返回优惠5元
        SubtractCoupon subC =
                new SubtractCoupon(System.currentTimeMillis(),         //now_time
                                   System.currentTimeMillis()-2000,    //begin_time
                                   System.currentTimeMillis()+3000,    //end_time
                                   99,                                 //promotion_id
                                   new BigDecimal(199.01));            //input_price
        subC.setTrigger_price(new BigDecimal(100));
        subC.setPreferential_price(new BigDecimal(5));
        //run...
        ksession.execute(subC);
        org.junit.Assert.assertEquals(new BigDecimal(5),subC.getBenefit_price());


        //test 2输入金额不满足100,返回优惠金额0
        subC =
                new SubtractCoupon(System.currentTimeMillis(),         //now_time
                        System.currentTimeMillis()-2000,    //begin_time
                        System.currentTimeMillis()+3000,    //end_time
                        99,                                 //promotion_id
                        new BigDecimal(19.01));             //input_price
        subC.setTrigger_price(new BigDecimal(100));
        subC.setPreferential_price(new BigDecimal(5));
        //run...
        ksession.execute(subC);
        org.junit.Assert.assertEquals(new BigDecimal(0),subC.getBenefit_price());


        //test 3当前时间不在活动期内,返回0
        subC =
                new SubtractCoupon(System.currentTimeMillis(),         //now_time
                        System.currentTimeMillis()+1,       //begin_time
                        System.currentTimeMillis()+3000,    //end_time
                        99,                                 //promotion_id
                        new BigDecimal(191.01));            //input_price
        subC.setTrigger_price(new BigDecimal(100));
        subC.setPreferential_price(new BigDecimal(5));
        //run...
        ksession.execute(subC);
        org.junit.Assert.assertEquals(new BigDecimal(0),subC.getBenefit_price());

    }
}
