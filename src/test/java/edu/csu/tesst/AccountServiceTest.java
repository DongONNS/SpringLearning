package edu.csu.tesst;

import edu.csu.config.JdbcConfig;
import edu.csu.config.SpringConfiguration;
import edu.csu.domain.Account;
import edu.csu.service.IAccountService;
import edu.csu.service.IAccountService2;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * 1.应用程序的入口
 *      main()方法
 * 2.junit单元测试中，没有main方法也能被执行
 *      junit集成了一个main方法
 *      该方法会判断当前测试类中有哪些方法有@Test注解
 *      junit就让有test注解的方法执行
 * 3. junit不会管我们是否采用spring框架
 *      在执行测试方法时，junit根本不知道我们是不是使用了spring框架
 *      所以也不会为我们读取配置文件，配置类创建spring核心容器
 * 4.由以上三点可知，
 *      当测试方法执行时，没有ioc容器，就算写了autowired注解也无法实现注入
 */

/**
 * 使用junit单元测试，测试我们的配置
 * spring整合junit的配置
 *      1.导入Spring整合junit的坐标
 *      2.使用junit提供的一个注解把原有的main方法替换了，替换成spring提供的main方法（@Runwith注解）
 *      3.告知spring的运行器，spring和ioc创建的是基于xml还是基于注解，并且说明位置
 *          @ContextConfiguration
 *              location:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes:指定注解类所在的位置
 *当我们使用spring 5.x版本的时候，要求junit的jar必须在4.12及以上
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

//    private ApplicationContext ac;
//    private IAccountService2 as;

    @Autowired
    private IAccountService2 as;

//    在所有的测试方法中都有获取核心容器然后获取bean组件的方式，此处我们可以考虑使用一个@Before注解的方法
    @Before
    public void init(){
        //1.获取容器
//        ac  = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
//        as = ac.getBean("accountService6",IAccountService2.class);

    }

    @Test
    public void testFindAll(){
        //1.获取容器//1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        如果去掉bean.xml中的配置文件，采用注解的方式那就不能用ClassPathXmlApplicationContext的方式了
//        而是要用AnnotationConfigApplicationContext
//        ApplicationContext ac  = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        ApplicationContext ac  = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        //2.得到业务层对象
//        IAccountService2 as = ac.getBean("accountService6",IAccountService2.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
//        IAccountService2 as = ac.getBean("accountService6",IAccountService2.class);
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2.得到业务层对象
//        IAccountService2 as = ac.getBean("accountService6",IAccountService2.class);
        //3.执行方法
        Account account = new Account();
        account.setName("dc");
        account.setMoney(1008611f);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
//        IAccountService2 as = ac.getBean("accountService6",IAccountService2.class);
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
//        IAccountService2 as = ac.getBean("accountService6",IAccountService2.class);
        //3.执行方法
        as.deleteAccount(4);
    }

    /**
     * 测试queryRunner对象是否为单例的
     */
    @Test
    public void testQueryRunner(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner = ac.getBean("runner",QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner",QueryRunner.class);
        System.out.println(runner == runner1);
    }
}
