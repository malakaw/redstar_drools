package com.franco.demo.drools;
import org.drools.KnowledgeBase;
import org.drools.SystemEventListener;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Test;


/**
 * Created by malaka on 16/6/27.
 */
public class AccountTest {


    @Test
    public void testAccount() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        kbuilder.add(ResourceFactory.newClassPathResource("drools/r1.drl"), ResourceType.DRL);
        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
        //测试account_1
        long t1_time_start = System.currentTimeMillis();
        Account account = new Account(200, 300);
        account.withdraw(1000);
        ksession.execute(account);
        System.out.println("use timeMillis:" + (System.currentTimeMillis() - t1_time_start));

        //测试account_2
        long t2_time_start = System.currentTimeMillis();
        account = new Account(200, 300);
        account.withdraw(10);
        ksession.execute(account);
        System.out.println("use timeMillis:" + (System.currentTimeMillis() - t2_time_start));

    }
}
