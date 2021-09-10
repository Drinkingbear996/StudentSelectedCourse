package com.System.Tool;

import java.sql.*;

/**
 * 封装一个查询的类 传入主键和查询内容即可
 * */
public class ConnectionJDBC {


    String result=null;


    public String SQL(String User,String Content) throws SQLException {
        //通过数据库对象获取sql执行对象


        //学号为唯一标识
        String sql = "select * from logininformation  where user=? ";



        //  获取数据库连接对象 Connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345678");
        //获取sql执行对象
        PreparedStatement ps = null;
        //返回结果集
        ResultSet set = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, User);


            //执行sql
            set = ps.executeQuery();

            if (set.next()) {

                result=set.getString(Content);
                System.out.println(result);

            }


        }catch (Exception e)
        {
            System.out.println("查询时发送错误");
        }
        return  result;
    }

}
