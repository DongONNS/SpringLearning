package edu.csu.dao;

import edu.csu.domain.Account;

import java.util.List;

public interface IAccountDao2 {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
