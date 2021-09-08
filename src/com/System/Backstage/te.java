package com.System.Backstage;

import com.System.window.QueryInterface_Student;

import java.sql.*;
import java.util.Scanner;

public class te {
    public static void main(String[] args) throws SQLException {
        //通过数据库对象获取sql执行对象

        String sql = "select  * from logininformation  where user=? and  password=?";
//  获取数据库连接对象 Connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345678");
        //获取sql执行对象
        PreparedStatement ps = null;
        //返回结果集
        ResultSet set = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "202010139066");
            ps.setString(2, "123456");

            //执行sql
            set = ps.executeQuery();

            if (set.next()) {

                System.out.println("ok");
                String s=set.getString("department");
                System.out.println(s);
            }


        }catch (Exception e)
        {

        }
    }
}


