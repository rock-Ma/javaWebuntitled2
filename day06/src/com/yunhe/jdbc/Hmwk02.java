package com.yunhe.jdbc;
/***2、使用preparedStament对象完成crud操作 （创建一张学生表 sid  name  email  score）***/
import com.yunhe.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Hmwk02 {
    public static void main(String[] args) throws SQLException {
        //增
//        add();
        //删
//        delete();
        //改
//        change();
        //查
        cha();
    }
    private static void cha() throws SQLException {
        Connection con = JdbcUtils.getConnection();
        String sql_cha = "select * from student2";
        PreparedStatement ps = con.prepareStatement(sql_cha);
        ResultSet res = ps.executeQuery();
        if(res.next()){
            int sid = res.getInt("sid");
            String name = res.getString("name");
            String email = res.getString("email");
            double score = res.getDouble("score");
            System.out.println(sid+"\t"+name+"\t"+email+"\t"+score);
        }
        JdbcUtils.closeResource(res,ps,con);
    }
    private static void change() throws SQLException {
        Connection con = JdbcUtils.getConnection();
        String sql_gai = "update student2 set name = ? where sid = ?";
        PreparedStatement ps = con.prepareStatement(sql_gai);
        ps.setString(1,"王祖贤");
        ps.setInt(2,1);
        System.out.println(ps.executeUpdate() > 0 ? "修改成功" : "修改失败");
        JdbcUtils.closeResource(null,ps,con);
    }
    private static void delete() throws SQLException {
        Connection con = JdbcUtils.getConnection();
        String sql_shan = "delete from student2 where sid = ?";
        PreparedStatement ps = con.prepareStatement(sql_shan);
        ps.setInt(1,1);
        System.out.println(ps.executeUpdate() > 0 ? "删除成功" : "删除失败");
        JdbcUtils.closeResource(null,ps,con);
    }
    private static void add() throws SQLException {
        Connection con = JdbcUtils.getConnection();
        String sql_zeng = "insert into student2 values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql_zeng);
        ps.setInt(1,1);
        ps.setString(2,"张曼玉");
        ps.setString(3,"manyu@qq.com");
        ps.setDouble(4,88);
        System.out.println(ps.executeUpdate() > 0 ? "添加成功" : "添加失败");
        JdbcUtils.closeResource(null,ps,con);
    }
}
