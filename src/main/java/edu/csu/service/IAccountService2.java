package edu.csu.service;

import edu.csu.domain.Account;

import java.util.List;

public interface IAccountService2 {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

}
