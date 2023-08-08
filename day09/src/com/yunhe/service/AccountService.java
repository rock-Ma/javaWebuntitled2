package com.yunhe.service;

import com.yunhe.dao.AccountDao;
import com.yunhe.dao.impl.AccountDaoImpl;
import com.yunhe.entity.Account;
import com.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class AccountService {
    static AccountDaoImpl accountDao = new AccountDaoImpl();

    @Test
    public void acFindAllTest(){
        String sql = "select * from account";
        List findall = accountDao.findall(sql, Account.class);
        findall.forEach(System.out::println);
    }
    @Test
    public void acUpdateTest(){
        String sql_charu = "insert into account values(?,?,?)";
        String sql_xiugai = "update account set name = ? where id = ?";
        String sql_shanchu = "delete from account where id = ?";
        //返回值大于0说明添加成功
//        System.out.println(accountDao.updateT(sql_charu, 1003, "88号技师", 10000) > 0 ? "添加成功" : "添加失败");
//        System.out.println(accountDao.updateT(sql_xiugai, "77号技师", 1002) > 0 ? "修改成功" : "修改失败");
        System.out.println(accountDao.updateT(sql_shanchu, 1002) > 0 ? "删除成功" : "删除失败");
    }

}
