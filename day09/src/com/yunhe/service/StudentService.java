package com.yunhe.service;

import com.yunhe.dao.StudentDao;
import com.yunhe.dao.impl.StudentDaoImpl;
import com.yunhe.entity.Student;
import org.junit.Test;

import java.util.List;

public class StudentService {
    static StudentDaoImpl stu = new StudentDaoImpl();
    @Test

    public void findAlltest(){
        String sql = "select * from student";
        List findall = stu.findall(sql,Student.class);
        findall.forEach(System.out::println);

    }
    @Test
    public void findOneTest(){
        String sql = "select * from student where studentid = ?";
        Object findone = stu.findone(sql, Student.class, 1);
        System.out.println(findone);
    }
    @Test
    public void stuUpdateTest(){
        String sql_charu = "insert into student values(?,?,?,?,?,?)";
        String sql_xiugai = "update student set studentname = ? where studentid = ?";
        String sql_shanchu = "delete from student where studentid = ?";
//        System.out.println(stu.updateT(sql_charu, 6, 24, 2, "美洋洋", "女", "青青草原") > 0 ? "添加成功" : "添加失败");
//        System.out.println(stu.updateT(sql_xiugai,"灰太狼",5) > 0 ? "修改成功" : "修改失败");
        System.out.println(stu.updateT(sql_shanchu,5) > 0 ? "删除成功" : "删除失败");
    }


  }
