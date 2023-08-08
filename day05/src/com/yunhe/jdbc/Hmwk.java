package com.yunhe.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 1.使用jdbc技术向学生表中添加3条记录，因为主键是自动增长，所以只需指定姓名和性别字段。
 * 2.使用jdbc技术将id为2的用户，姓名更新为"猪八戒"
 * 3.使用jdbc技术查询所有表中的数据将3条数据封装到一个List<Student>集合中并打印输出
 * **/
public class Hmwk {
    public static void main(String[] args) throws Exception {
        //创建list集合
        List<Student> li= new ArrayList<>();
        //获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql:///day0707","root","123admin");
        //获取可执行对象
        Statement st = con.createStatement();
        /**1.使用jdbc技术向学生表中添加3条记录，因为主键是自动增长，所以只需指定姓名和性别字段**/
        String sql1 = "insert into student (sname,sex) values('吕布','男')";
        String sql2 = "insert into student (sname,sex) values('华雄','男')";
        String sql3 = "insert into student (sname,sex) values('关羽','男')";
//        System.out.println(st.executeUpdate(sql1) > 0 ? "添加成功！" : "添加失败");
//        System.out.println(st.executeUpdate(sql2) > 0 ? "添加成功！" : "添加失败");
//        System.out.println(st.executeUpdate(sql3) > 0 ? "添加成功！" : "添加失败");
        /**2.使用jdbc技术将id为2的用户，姓名更新为"猪八戒"**/
        String sql4 = "update student set sname = '猪八戒' where id = 2";
//        System.out.println(st.executeUpdate(sql4) > 0 ? "添加成功！" : "添加失败");
        /**3.使用jdbc技术查询所有表中的数据将3条数据封装到一个List<Student>集合中并打印输出**/
        String sql5 = "select * from student";
        ResultSet res = st.executeQuery(sql5);
        while(res.next()){
            Student student1 = new Student();
            student1.setId(res.getInt("id"));
            student1.setName(res.getString("sname"));
            student1.setSex(res.getString("sex"));
            li.add(student1);
        }
        for (Student s: li) {
            System.out.println(s);
        }
        //释放资源
        st.close();
        con.close();
    }
}
