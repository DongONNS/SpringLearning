package edu.csu.dao.impl;

import edu.csu.dao.IAccountDao;
import edu.csu.dao.IAccountDao2;
import edu.csu.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository(value = "accountDao3")
public class AccountDaoImpl3 implements IAccountDao2 {

    @Autowired
    private QueryRunner runner;
    //如果采用基于注解的方式则不需要再配置文件中进行注入操作了
//    public void setRunner(QueryRunner runner) {
//        this.runner = runner;
//    }

    public List<Account> findAllAccount(){
        List<Account> result = null;
        try{
            result = runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public Account findAccountById(Integer accountId) {
        Account result = null;
        try{
            result = runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),accountId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void saveAccount(Account account) {
        try{
            runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try{
            runner.update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            runner.update("delete from  account where id = ?",accountId);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}