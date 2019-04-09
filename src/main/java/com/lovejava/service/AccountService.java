package com.lovejava.service;

import com.lovejava.domain.Account;

import java.util.List;

/**
 * @author:tianyao
 * @date:2019-04-09 9:27
 */
public interface AccountService {
    /**
     * 保存
     * @param account
     */
    void save(Account account);

    /**
     * 更新
     * @param account
     */
    void update(Account account);

    /**
     * 删除
     * @param accountId
     */
    void delete(Integer accountId);

    /**
     * 根据id查询
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();
}
