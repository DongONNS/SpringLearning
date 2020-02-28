package edu.csu.jdbc;

import java.sql.*;
/*
    耦合：程序之间的依赖关系
        类之间的耦合
        方法之间的耦合
    解耦：降低程序之间的依赖
    实际开发中，编译器不依赖，运行时才依赖
    解耦的思路：
        第一步：使用发射来创建对象，而不是使用new关键字
        第二步：通过读取配置文件来获取要创建的对象的全限定类名

 */



public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        DriverManager.registerDriver((new com.mysql.jdbc.Driver()));
        //2.获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
        //3.获取执行数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行sql，获取结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
