drools 使用记录,建议用intellij来开发,支持drl高亮和跳转


# 第一个简单的入门demo
## 文件
<pre><code>
//参与规则计算的java类
main/java/com.franco.demo.drools.Account
//规则文件
main/resources/drools/r1.drl
//测试类
test/java/com.franco.demo.drools.AccountTest
</code></pre>


在drools中，这个传递数据进去的对象，术语叫 Fact对象,上面的Account就是fact.规则中可以对当前的对象进行任何的读写操作.
## 规则文件r1.drl
<pre><code>
import com.franco.demo.drools.Account
rule "accountBalanceAtLeast"
  salience 3
  when
  $account : Account( balance < 0 )
  then
  System.out.println("Warning! money running out!");
end
</pre></code>

上面的代码中Account，就是可以  $account : Account( balance < 0 )的方式获取并判断比较。


执行test/java/com.franco.demo.drools.AccountTest运行结果
<pre><code>
Warning! money running out!
Warning! money <30 out!
use timeMillis:109
use timeMillis:1
</pre></code>
可以看到第一次慢点，后面1毫秒还是很快的，但是一定不能重复去创建StatelessKnowledgeSession

# StatefulKnowledgeSession vs StatelessKnowledgeSession
从字面理解就是有无状态的会话session,大家可以按照实际业务场景来使用。
事实上，StatelessKnowledgeSession 对StatefulKnowledgeSession做了包装，使得在使用 StatelessKnowledgeSession 对象时不需要再调用 dispose()方法释放内存资源了。
参考：
http://benbenxiongyuan.iteye.com/blog/1121479
http://stackoverflow.com/questions/17175037/droolsstateless-vs-stateful-knowledge-session








