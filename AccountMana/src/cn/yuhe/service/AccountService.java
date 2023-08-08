package cn.yuhe.service;

import cn.yuhe.dao.AccountDao;
import cn.yuhe.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    AccountDao accountDao = new AccountDao();

    public List selectAll(){
        return accountDao.selcetAll();
    }
    public Account selectById(int id){
        return accountDao.selectById(id);
    }
    public List selectByCname(String name){
        return accountDao.selectByCname(name);
    }
    public List selectByPaytype(String paytype){
        return accountDao.selectByPaytype(paytype);
    }
    public int deleteById(int id){
        return accountDao.deleteById(id);
    }
    public int insert(Account account){
        return accountDao.insert(account);
    }
    public int updateMoney(int id,double money){
        return accountDao.updateMoney(id,money);
    }

    public List<Account> delete(String s, String s1) {
        List li = new ArrayList<>();
        String sql = "select * from account where 1 = 1 ";
        if(!"".equals(s)){
            sql = sql.concat("and paytype = ? ");
            li.add(s);
        }
        if(!"".equals(s1)){
            sql = sql.concat("and createtime = ? ");
            li.add(s1);
        }
        Object[] obj = li.toArray();
        return accountDao.select(sql, obj);

    }

    public int xiugai(Account account) {
        List list = new ArrayList<>();
        String sql = "update account set ";
        if(!"".equals(account.getCname())){
            sql = sql.concat("cname = ?, ");
            list.add(account.getCname());
        }
        if(account.getMoney()!=0.0){
            sql = sql.concat("money = ?, ");
            list.add(account.getMoney());
        }
        if(!"".equals(account.getPaytype())){
            sql = sql.concat("paytype = ?, ");
            list.add(account.getPaytype());
        }
        if(!"".equals(account.getCreatetime())){
            sql = sql.concat("createtime = ?, ");
            list.add(account.getCreatetime());
        }
        if(!"".equals(account.getDescription())){
            sql = sql.concat("description = ?, ");
            list.add(account.getDescription());
        }
        String sqlsql = sql.substring(0, sql.lastIndexOf(","));
        sqlsql = sqlsql.concat("where id = ?;");
        list.add(account.getId());

        return accountDao.xiugai(sqlsql, list.toArray());


    }

    public int newDelete(List<Integer> list) {

        //定义index记录删除行数
        int index = 0;
        for (Integer it: list
             ) {
            //调用selectbyid方法判断是否存在此id
            if(accountDao.selectById(it)!=null){
                //i>0说明删除成功
                int i = accountDao.deleteById(it);
                if(i>0){
                    //index计数
                    index++;
                }
                else {
                    return 0;
                }
            }
        }
        return index;
    }
}
