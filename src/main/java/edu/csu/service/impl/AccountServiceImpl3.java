package edu.csu.service.impl;

import edu.csu.dao.IAccountDao;
import edu.csu.dao.impl.AccountDaoImpl;
import edu.csu.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl3 implements IAccountService {
    //如果是经常变化的数据，那么不适合用依赖注入
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

//    public AccountServiceImpl3(String name, Integer age, Date birthday){
//        this.name = name;
//        this.age = age;
//        this.birthday = birthday;
//    }

    public void saveAccount() {
        System.out.println("saveAccount()方法被执行了！"+name+"    "+age+"    "+birthday);
    }
}
