package edu.csu.service.impl;

import edu.csu.beanfactory.BeanFactory;
import edu.csu.dao.impl.AccountDaoImpl;
import edu.csu.dao.IAccountDao;
import edu.csu.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();
//    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
