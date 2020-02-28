package edu.csu.service.impl;

import edu.csu.dao.IAccountDao;
import edu.csu.dao.impl.AccountDaoImpl;
import edu.csu.service.IAccountService;
import edu.csu.service.IAccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;

/*
账户的业务层实现类

曾经的xml的配置
<bean id="accountService" class="edu.csu.service.impl.AccountServiceImpl"
        scope="" init-method="" destroy-method="">
        <property name="" value="" / ref="">
</bean>
一、用于创建对象的注解
    它们的作用就和在xml配置文件中编写一个<bean>标签是一样的
    @Component：
                作用：用于把当前类对象存入spring容器中
                属性：
                    value:用于指定bean的id当我们不写时，它的默认值是当前类名，且首字母改成小写
    @Controller:一般用在表现层
    @Service:一般用在业务层
    @Repository:一般用在持久层
    以上三个注解的作用和属性与Component是一模一样的。
    它们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰。

二、用于注入数据的注解
    它们的作用和在xml配置文件中的bean标签写一个property标签的作用是一样的
    Autowired:
        作用：自动按照类型注入，只要容器中有唯一的bean对象类型和要注入的变量类型匹配，就可以注入成功
             如果ioc容器中没有任何bena类型和要注入的变量类型匹配，则报错
             如果ioc容器中有多个类型匹配时：先圈定出匹配的对象，再根据id在圈定的范围内继续查找。
        出现位置：
            可以在变量上，也可以在方法上
        细节：
            在使用注解注入时，set方法就不是必须的了
    @Qualifier:
        作用：在按照类中注入的基础上，再按照名称注入，他在给类成员注入时不能单独使用(和autowired一起使用)，但是在给方法参数注入时可以
    @Resource
        作用：直接按照bean的id注入，它可以独立使用
        属性：
            name:用于指定bean的id值
     以上三个注解都只能诸如其他bean类型的数据，而基本类型和String类型无法使用上述注解形式实现
     另外，结合类型的注入只能用xml形式的注入
     value:
        作用：用于注入基本类型和String类型的数据
        属性：
            value:用于指定数据的值，它可以使用spring中的SpEL(也就是spring的el表达式)
            SpEL的写法：${表达式}

三、用于改变作用范围的注解
    它们的作用就和在bean标签中使用scope属性的功能是一样的
    scope:
        作用：用于指定bean的作用范围
        属性：
            value:指定范围的取值，常用取值：singleton prototype
四、和生命周期相关的注解
    它们的作用就和在bean标签中使用init-method和destroy-method是一样的


 */
//@Component(value="accountService")
//@Service(value="accountService")
//@Scope("prototype") //多例的销毁方式不由spring负责,而取决于java的垃圾回收机制
public class AccountServiceImpl5 implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行了");
    }


}
