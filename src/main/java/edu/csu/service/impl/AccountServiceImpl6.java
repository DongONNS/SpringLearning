package edu.csu.service.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import edu.csu.dao.IAccountDao;
import edu.csu.dao.IAccountDao2;
import edu.csu.domain.Account;
import edu.csu.service.IAccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//账户的业务层实现类
@Service(value = "accountService6")
public class AccountServiceImpl6 implements IAccountService2 {
//    如果采用基于配置的方式是需要set方法的，如果使用基于注解的方式则不需要set方法的存在;
//    public void setAccountDao(IAccountDao2 accountDao) {
//        this.accountDao = accountDao;
//    }
    @Autowired
    private IAccountDao2 accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
