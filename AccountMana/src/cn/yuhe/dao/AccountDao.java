package cn.yuhe.dao;

import cn.yuhe.entity.Account;
import cn.yuhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public class AccountDao {

    QueryRunner qr= new QueryRunner(JdbcUtils.getDataSource());
    public List selcetAll(){
        String sql = "select * from account";
        try {
            return qr.query(sql,new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Account selectById(int id){
        String sql = "select * from account where id = ?";
        try {
            return qr.query(sql, new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List selectByCname(String name){
        String sql = "select * from account where cname = ?";
        try {
            return qr.query(sql, new BeanListHandler<Account>(Account.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List selectByPaytype(String paytype){
        String sql = "select * from account where paytype = ?";
        try {
            return qr.query(sql, new BeanListHandler<Account>(Account.class),paytype);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List selectByCreatetime(){
        return null;
    }

//    public List<Integer> select_id_from_account(){
//        try {
////            List<Integer> select_id_from_account = qr.query("select id from account;",);
//            qr.query("select id from account",new List<Integer>(Integer.class))
////            return select_id_from_account;
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public int deleteById(int id){

        String sql = "delete from account where id = ?";
        try {
            return qr.update(sql, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int insert(Account account){
        String sql = "insert into account values(null,?,?,?,?,?)";
        try {
            return qr.update(sql, account.getCname(), account.getMoney(), account.getPaytype(), account.getCreatetime(), account.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateMoney(int id,double money){
        String sql = "update account set money = ? where id = ?";
        try {
            return qr.update(sql, money, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }


    public List<Account> select(String sql, Object[] obj) {
        try {
            return qr.query(sql, new BeanListHandler<Account>(Account.class), obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int xiugai(String sqlsql, Object[] toArray) {
        try {
            int update = qr.update(sqlsql, toArray);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
