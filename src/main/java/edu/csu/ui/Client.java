package edu.csu.ui;

import edu.csu.dao.IAccountDao;
import edu.csu.service.IAccountService;
import edu.csu.service.impl.AccountServiceImpl;
import edu.csu.service.impl.AccountServiceImpl2;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//模拟一个表现层，用于调用业务层
public class Client {
    /*
    获取spring的核心容器，并根据id获取对象
    ApplicationContext的三个常用实现类
        ClassPathXmlApplicationContext,它可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话加载不赖哦
        FileSystemXmlApplicationContext,它可以记载磁盘任意路径下的配置文件（必须有访问权限）
        AnnotationConfigApplicationContext,它是用于读取注解创建容器的，
     */

    /*
    核心容器的两个接口引发出的问题
    ApplicationContext:     ~单例对象适用    大部分时候采用此接口
        他在构建核心容器时，创建对象采取的方式是立即加载的方式，也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
    BeanFactory:            ~多例对象适用
        它在构建核心容器时，创建对象采取的策略是延迟加载的方式，也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
     */

    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
//        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
//        as.saveAccount();
        //测试采用工厂模式时设置成单例的方法;
//        for (int i = 0;i<5;i++){
//            System.out.println(as);
//        }

        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\LX\\Desktop\\bean.xml");
        //2.根据id获取bean对象
        //2.1将获取到的对象进行强制类型转化;
//        IAccountService as = (IAccountService) ac.getBean("accountService");
        //2.2在获取对象直接进行类型的转化;
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
//        as.saveAccount();
//------BeanFactory-----------------------
        /*
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService accountServicec = (IAccountService) factory.getBean("accountService");
        System.out.println(as);
         */
//        //1.获取核心容器对象
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        //2.根据id获取bean对象
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//        as.saveAccount();
        //手动关闭容器
//        ac.close();

        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
        //手动关闭容器
        ac.close();
    }
}
