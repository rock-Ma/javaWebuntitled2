package com.yunhe.pojo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookManger {
    public static void main(String[] args) {
        try{
            //创建bookserver对象
            BookServiceImp bs = new BookServiceImp();
            //创建输入流对象
            Scanner sc = new Scanner(System.in);
            //无限循环
            while (true){
                //菜单
                System.out.println("------------");
                System.out.println("请选择您要使用的功能：\n1.添加书籍\n2.删除书籍\n3.更新书籍\n4.查找书籍\n5.显示所有书籍\n6.退出系统");
                System.out.println("------------");
                int in = sc.nextInt();
                switch (in) {
                    case 1:
                        System.out.println("请输入您要添加书籍的编号：");
                        int id1 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("请输入您要添加书籍的名字：");
                        String name1 = sc.nextLine();
                        System.out.println("请输入您要添加书籍的作者：");
                        String author1 = sc.nextLine();
                        System.out.println("请输入您要添加书籍的价格：");
                        double price1 = sc.nextDouble();
                        Book book = new Book(id1, name1, author1, price1);
                        //调用方法
                        bs.addbook(book);
                        break;

                    case 2:
                        System.out.println("请输入您要删除的书籍编号：");
                        int id2 = sc.nextInt();
                        sc.nextLine();
                        //调用方法
                        bs.deletebook(id2);
                        break;

                    case 3:
                        System.out.println("请输入您要修改的书籍编号");
                        int id03 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("请输入您要添加书籍的编号：");
                        int id3 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("请输入您要添加书籍的名字：");
                        String name3 = sc.nextLine();
                        System.out.println("请输入您要添加书籍的作者：");
                        String author3 = sc.nextLine();
                        System.out.println("请输入您要添加书籍的价格：");
                        double price3 = sc.nextDouble();
                        Book book3 = new Book(id3, name3, author3, price3);
                        //调用方法
                        bs.updatebook(id03, book3);
                        break;

                    case 4:
                        System.out.println("请输入您要查找的书籍的编号：");
                        int id4 = sc.nextInt();
                        sc.nextLine();
                        //调用方法
                        bs.selectbook(id4);
                        break;

                    case 5:
                        System.out.println("以下为全部书籍的信息：");
                        //调用方法
                        bs.showall();
                        break;


                    case 6:
                        System.out.println("退出成功！ ");
                        //退出程序
                        System.exit(0);
                }
            }
        }
        //捕获输入非法产生的异常
        catch (InputMismatchException e){
            System.err.println("输入非法！");
        }




    }
}
