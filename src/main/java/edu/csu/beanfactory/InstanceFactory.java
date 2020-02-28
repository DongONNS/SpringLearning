package edu.csu.beanfactory;

import edu.csu.service.IAccountService;
import edu.csu.service.impl.AccountServiceImpl;
//模拟一个工厂类，该类可能是存在与jar包中，我们无法通过改变源码的方式来提供默认构造函数
public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
