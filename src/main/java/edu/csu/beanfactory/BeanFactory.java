package edu.csu.beanfactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建bean对象的工厂
 * Bean:在计算机英语中，有可重用组件的含义。
 * JavaBean:用java语言编写的可重用组件
 *          javabean的范围是大于实体类的，两者并不相等
 * 我们可以创建我们的service和dao对象，创建过程分为两步
 *      第一步：需要一个配置文件来配置我们的service和dao
 *              配置的内容，唯一标识 == 全限定类名（key-value形式）
 *      第二步：通过读取配置文件中的配置内容，反射创建对象
 * 配置文件可以是xml形式的也可以是property形式的。
 */

public class BeanFactory {
    //定义一个peoperty对象
    private static Properties prop;

    //定义一个map用于存放我们要创建的对象
    private static Map<String,Object> beans;
    static{

        try {
            //实例化对象
            prop = new Properties();
            //取出property文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            prop.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            Enumeration<Object> keys = prop.keys();
            while(keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取相应的value;
                String beanPath = prop.getProperty(key);
                //根据反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存放进容器
                beans.put(key,value);
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化property失败！");
        }
    }

//    /**
//     * 根据bean名称获取bean对象
//     * @param beanName
//     * @return
//     */
//    public static Object getBean(String beanName){
//        Object bean = null;
//        try{
//            String beanPath = prop.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//    }

    /**
     * 根据bean名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
