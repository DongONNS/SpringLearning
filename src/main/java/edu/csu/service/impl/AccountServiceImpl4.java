package edu.csu.service.impl;

import edu.csu.dao.IAccountDao;
import edu.csu.dao.impl.AccountDaoImpl;
import edu.csu.service.IAccountService;

import java.util.*;

public class AccountServiceImpl4 implements IAccountService {

    private String[] myStr;
    private List<String> myList;

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public void saveAccount() {
        System.out.println(Arrays.toString(myStr));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
    }
}
