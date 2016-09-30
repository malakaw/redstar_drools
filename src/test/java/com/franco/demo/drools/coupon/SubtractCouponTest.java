package com.franco.demo.drools.coupon;

import com.franco.demo.drools.facts.SubtractCouponFact;
import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by malaka on 16/9/30.
 */
public class SubtractCouponTest {

    @Test
    public void test1()
    {
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        kbuilder.add(ResourceFactory.newClassPathResource("drools/coupon_1.drl"), ResourceType.DRL);
        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
       // StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

        SubtractCouponFact subC = new SubtractCouponFact(new BigDecimal(311));
       // subC.setNow(999995l);
       // subC.setCheck_date_ok(true);


        ksession.insert(subC);
        ksession.fireAllRules();
        ksession.dispose();

        //ksession.execute(subC);

        System.out.println("out:"+subC.getOut_result_price());

    }
}
