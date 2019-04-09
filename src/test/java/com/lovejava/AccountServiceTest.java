package com.lovejava;


import com.lovejava.config.SpringConfig;
import com.lovejava.domain.Account;
import com.lovejava.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试类
 * @author:tianyao
 * @date:2019-04-09 9:39
 */
@RunWith(SpringJUnit4ClassRunner.class)//测试运行环境
@ContextConfiguration(classes = SpringConfig.class)//配置类加载方式
//@ContextConfiguration("classpath:applicationContext.xml")//配置文件加载方式
public class AccountServiceTest {
    //普通方式获取容器
   /* private ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
    private AccountService accountService = (AccountService) ac.getBean("accountService");*/
   //通过spring内部整合的junit测试获取容器
    @Autowired
    private AccountService accountService;
    /**
     * 保存
     */
    @Test
    public void testSave(){
        Account account = new Account();
        account.setMoney(999f);
        account.setName("小红");
        accountService.save(account);
    }

    /**
     * 更新
     */
    @Test
    public void testUpdate(){
        //查询出id=3的账户，再修改
        Account account = accountService.findById(4);
        account.setName("zhangsan");
        //修改
        accountService.update(account);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete(){
        Integer accountId=3;
        accountService.delete(accountId);
    }

    /**
     * 根据id查询
     * @return
     */
    @Test
    public void testFindById(){
        Integer accountId=3;
        Account account = accountService.findById(accountId);
        System.out.println(account);
    }

    /**
     * 查询所有
     * @return
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
