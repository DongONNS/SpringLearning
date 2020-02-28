package edu.csu.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.activation.DataSource;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 * Configuration
 *      作用：表示当前类是一个配置类
 *      细节：如果该注解所在的类与AnnotationConfigApplicationContext的参数是一致的，那么这个注解可以省略；
 *
 * ComponentScan:
 *      作用：用于通过注解指定spring在在创建容器时要扫描的包
 *      属性：
 *          value:它和basePackage的作用是一样的，都是用于指定创建容器时要扫描的包。
 *          我们使用此注解就相当于在xml中配置了：
 *              <context:component-scan base-package="edu.csu"></context:component-scan>
 *
 * Bean:
 *      作用：用于把当前方法的返回值作为bean对象存入spring容器中
 *      属性：
 *          name:用于指定bean的id,当不写时，默认返回值是当前方法名
 *      细节：当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象，
 *           查找的方式和Autowired注解的作用是一样的
 *
 * Import
 *      作用：用于导入其他的配置类
 *      属性：
 *          value:用于指定其他配置类的字节码
 *                  当我们使用Import的注解之后，有import注解的类就是父配置类，而导入的都是子配置类；
 *
 * PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value:指定文件的名称和路径
 *              关键字：classpath,表示类路径
 */
@Configuration
//下面的注解中basePackage可以默认省略，而{}是因为在源码中是一个数组，所以用了花括号，如果只有一个元素则可以省略；
//@ComponentScan(basePackages = {"edu.csu"})
@ComponentScan("edu.csu")
@Import(JdbcConfig.class)
@PropertySource("classpath:JdbcConfig.properties")
public class SpringConfiguration {



}
