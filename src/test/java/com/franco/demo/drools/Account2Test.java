package com.franco.demo.drools;

import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by wengxiaojun on 16/10/7.
 */
public class Account2Test {
    @Test
    public void testAccount() throws Exception {

        //----6.4.final
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");
        Account2 account = new Account2(200);
        account.withdraw(130);

        kSession.insert(account);
        //kSession.fireAllRules();
        kSession.fireAllRules(new RuleNameStartsWithAgendaFilter("jerry"));


        System.out.println("------------");
        KieSession kSession2 = kContainer.newKieSession("r2");
        Account2 account2 = new Account2(200);
        account2.withdraw(130);

        kSession2.insert(account2);
       // kSession2.fireAllRules();

        kSession2.fireAllRules(1);

        // System.out.println(customerRuleObject.getMessage());
    }
}
