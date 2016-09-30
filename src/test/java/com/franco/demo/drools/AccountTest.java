package com.franco.demo.drools;
import org.drools.KnowledgeBase;
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
        Account account = new Account(200, 300);
        account.withdraw(1000);
        ksession.execute(account);
    }
}
