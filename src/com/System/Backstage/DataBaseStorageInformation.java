package com.System.Backstage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseStorageInformation {

    private  String User;
    private  String Password;

    public DataBaseStorageInformation(String User, String Password) throws Exception {
        this.User = User;
        this.Password = Password;
        JDbcStorage();
    }
  //抛出CastCatchClass异常
    public void JDbcStorage() throws Exception {
        //1. 导入驱动jar包
        //配置JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接数据库对象
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","12345678");
        //通过数据库对象获取sql执行对象
        Statement st= null;
        try {
            st = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //


        //定义sql
        String sql1="insert into Student(user,password) values "+"("+User+","+Password+")";
        //返回执行成功(受到影响)的命令数

        int count1=st.executeUpdate(sql1);
        if (count1>0)
        {
            System.out.println("信息已经添加至数据库!");
        }
        else
        {
            System.out.println("数据添加失败!");
        }


        st.close();
        con.close();
    }

    public static void main(String[] args) throws Exception {

    }
}
