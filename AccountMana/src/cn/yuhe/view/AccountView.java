package cn.yuhe.view;

import cn.yuhe.dao.AccountDao;
import cn.yuhe.entity.Account;
import cn.yuhe.entity.User;
import cn.yuhe.service.AccountService;
import cn.yuhe.service.UserService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountView {
    UserService userService = new UserService();
    AccountService accountDao = new AccountService();

    Scanner sc = new Scanner(System.in);
    public void run(){

        while (true){
            System.out.println("======账务管理系统=====");
            System.out.println("请选择您要使用的功能：\t1.查询\t2.修改\t3.删除\t4.增加\t5.测试功能\t6.新修改");
            int in = sc.nextInt();
            switch (in){
                case 1:
                    System.out.println("请选择您要使用的查询方式：\n1.查询所有\t2.通过id查询\t3.通过姓名查询\t4.通过支付方式查询");
                    int nextInt = sc.nextInt();
                    if(nextInt==1){
                        List chaxun = accountDao.selectAll();
                        chaxun.forEach(System.out::println);
                    }
                    else if(nextInt==2){
                        System.out.println("请输入您要查询的id：");
                        int nextInt1 = sc.nextInt();
                        System.out.println(accountDao.selectById(nextInt1));
                    }
                    else if(nextInt==3){
                        System.out.println("请输入您要查询的姓名：");
                        sc.nextLine();
                        String s = sc.nextLine();
                        List list = accountDao.selectByCname(s);
                        list.forEach(System.out::println);
                    }
                    else if(nextInt==4){
                        System.out.println("请输入您要查询的支付类型：");
                        sc.nextLine();
                        String s = sc.nextLine();
                        List list = accountDao.selectByPaytype(s);
                        list.forEach(System.out::println);
                    }
                    break;
                case 2:
                    System.out.println("请输入您要修改的账务id：");
                    int nextInt2 = sc.nextInt();
                    System.out.println("价格修改为？（请输入）");
                    double v1 = sc.nextDouble();
                    accountDao.updateMoney(nextInt2,v1);
                    break;
                case 3:
                    int delete = delete();
                    System.out.println("本次操作共删除了" + delete + "行");
//                    System.out.println("请输入您要删除账务的id：");
//                    int nextInt1 = sc.nextInt();
//                    System.out.println(accountDao.deleteById(nextInt1) > 0 ? "删除成功" : "删除失败");
                    break;
                case 4:
                    while(true){
                        System.out.println("请输入您要添加的账务名称：");
                        sc.nextLine();
                        String s = sc.nextLine();
                        System.out.println("请输入您要添加的账务价格：");
                        double v = sc.nextDouble();
                        System.out.println("请输入您要添加的账务类型：");
                        sc.nextLine();
                        String s1 = sc.nextLine();
                        System.out.println("请输入您要添加的账务时间：");
                        String s2 = sc.nextLine();
                        System.out.println("请输入您要添加的账务介绍：");
                        String s3 = sc.nextLine();
                        Account account = new Account(0,s,v,s1,s2,s3);
                        System.out.println(accountDao.insert(account) > 0 ? "添加成功！" : "添加失败！");
                        System.out.println("是否同继续添加？输入1结束，任意键继续");
                        String s4 = sc.nextLine();
                        if(s4.equals("1")){
                            break;
                        }
                    }
                    break;



                case 5:
                    System.out.println("测试~~~");
                    List chaxun = chaxun();
                    chaxun.forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("修改测试~~~");
//                    List chaxun = chaxun();
//                    chaxun.forEach(System.out::println);
                    int xiugai = xiugai();
                    System.out.println(xiugai > 0 ? "修改成功" : "修改失败");
                    System.out.println(xiugai);
                    break;
                default:
                    System.out.println("程序退出成功！欢迎下次光临~");
                    //输出其他退出程序
                    System.exit(0);
                    break;
            }
        }
    }

    private int delete(){
        List<Integer> list = new ArrayList<Integer>();
        while (true){
            System.out.println("请输入要删除的用户id（输入 0 结束输入）");
            int nextInt = sc.nextInt();
            if(nextInt==0){
                break;
            }
            else {
                list.add(nextInt);
            }
        }
        return accountDao.newDelete(list);

    }

    public List chaxun(){
        System.out.println("请选择您要使用的查询方式：\n1.查询所有\t2.通过支付方式和支付时间查询");
        int nextInt = sc.nextInt();
        switch (nextInt){
            case 1:
                System.out.println("中");
                return null;

            case 2:
                System.out.println("请输入支付方式：");
                sc.nextLine();
                String s = sc.nextLine();
                System.out.println("请输入支付时间：");
                String s1 = sc.nextLine();
                List<Account> li =  accountDao.delete(s,s1);
                return li;
            default:
                break;
        }
        return null;
    }
    public int xiugai(){
        System.out.println("请输入您要修改的编号（id）：");
        int nextInt = sc.nextInt();
        System.out.println("请输入账务名称：");
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println("请输入修改的账务价格：");
        double v = sc.nextDouble();
        System.out.println("请输入账务类型：");
        sc.nextLine();
        String s1 = sc.nextLine();
        System.out.println("请输入账务时间：");
        String s2 = sc.nextLine();
        System.out.println("请输入账务介绍：");
        String s3 = sc.nextLine();
        Account account = new Account(nextInt,s,v,s1,s2,s3);
        return accountDao.xiugai(account);

    }
    public void login(){
        System.out.println("请输入您的账号");
        String username = sc.nextLine();
        System.out.println("请输入您的密码");
        String password = sc.nextLine();
        User login = userService.login(username, password);
        if(login==null){
            System.out.println("登陆失败！请检查账号和密码");
        }
        else {
            System.out.println("登陆成功！");
            this.run();
        }


    }
}
