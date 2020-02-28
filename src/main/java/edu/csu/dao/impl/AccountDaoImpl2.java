package edu.csu.dao.impl;

import edu.csu.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository(value = "accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    public void saveAccount(){
        System.out.println("账户已保存");
    }
}
