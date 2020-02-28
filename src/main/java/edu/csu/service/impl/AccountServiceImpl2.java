package edu.csu.service.impl;

import edu.csu.dao.IAccountDao;
import edu.csu.service.IAccountService;

public class AccountServiceImpl2 implements IAccountService {
    public void saveAccount() {
        //简化处理过程，不再涉及dao层的操作
        System.out.println("service中的saveAccount()方法执行了");
    }
}
