package com.lovejava.service.impl;

import com.lovejava.dao.AccountDao;
import com.lovejava.domain.Account;
import com.lovejava.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:tianyao
 * @date:2019-04-09 9:27
 */
@Service("accountService")//相当于<bean>标签
public class AccountServiceImpl implements AccountService {
    /*public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }*/
    @Autowired//根据类型注入，接口有一个实现类，直接用，超过2个、多个就要确定是注入的哪个实现类，根据name注入，
    @Qualifier("accountDao")// 用Qualifire(value:"")注解,value指定的是bean的id
    private AccountDao accountDao;

    public void save(Account account) {
        accountDao.save(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Integer accountId) {
        accountDao.delete(accountId);
    }

    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }
    
}
