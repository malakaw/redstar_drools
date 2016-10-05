package com.rs.demo.promotion;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wengxiaojun on 16/10/5.
 */
public class PromotionSessions {


    //现金券
    public final static int CASH_COUPON = 1;
    //满减券
    public final static int SUBTRACT_COUPON = 2;
    //每满减券
    public final static int EVERY_SUBTRACT_COUPON = 3;
    //drools会话map
    private static Map sessionMap = new HashMap<Integer,StatelessKnowledgeSession>();

    private static PromotionSessions instance;

    private PromotionSessions(){}

    public static PromotionSessions getInstance()
    {
        if(null == instance)
        {
            synchronized (PromotionSessions.class)
            {
                if(null == instance)
                {
                    init();
                }
            }
        }
        return instance;
    }

    private static void init()
    {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        KnowledgeBase    kbase    = null;
        //cash coupon session
        kbuilder.add(ResourceFactory.newClassPathResource("drools/coupons/cash.drl"), ResourceType.DRL);
        kbase = kbuilder.newKnowledgeBase();
        sessionMap.put(CASH_COUPON,kbase.newStatelessKnowledgeSession());

        //subtract coupon session
        kbuilder.add(ResourceFactory.newClassPathResource("drools/coupons/subtract.drl"), ResourceType.DRL);
        kbase = kbuilder.newKnowledgeBase();
        sessionMap.put(SUBTRACT_COUPON,kbase.newStatelessKnowledgeSession());

        //every subtract coupon session
        kbuilder.add(ResourceFactory.newClassPathResource("drools/coupons/every_subtract.drl"), ResourceType.DRL);
        kbase = kbuilder.newKnowledgeBase();
        sessionMap.put(SUBTRACT_COUPON,kbase.newStatelessKnowledgeSession());


        //TODO 再添加其他session
        //.....
    }


    public static StatelessKnowledgeSession getSession(Integer coupont_type) throws Exception {
        if(sessionMap.containsKey(coupont_type))
            return (StatelessKnowledgeSession) sessionMap.get(coupont_type);
        else
        {
            //TODO  这里后期自定义Exception
            throw new Exception(" not right coupon type");
        }

    }
}
