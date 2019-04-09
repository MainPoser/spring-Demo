package com.lovejava.dao.impl;


import com.lovejava.dao.AccountDao;
import com.lovejava.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author:tianyao
 * @date:2019-04-09 8:55
 */
@Repository("accountDao")//创建id是accountDao的dao层实现类
public class AccountDaoImpl implements AccountDao {
   /* public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }*/
    @Autowired
    @Qualifier("runner")
    private QueryRunner runner;

    /**
     * 保存用户
     * @param account
     */
    @Override
    public void save(Account account) {
        try {
            runner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *更新用户
     * @param account
     */
    @Override
    public void update(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *根据ID删除
     * @param accountId
     */
    @Override
    public void delete(Integer accountId) {
        try {
            runner.update("delete from account where id=?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *根据ID查找用户
     * @param accountId
     * @return
     */
    @Override
    public Account findById(Integer accountId) {
        try {
            return runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *查询所有
     * @return
     */
    @Override
    public List<Account> findAll() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
