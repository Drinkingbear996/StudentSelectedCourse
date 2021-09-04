package com.System.Backstage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBaseVerification  {

    //接收SQL
private String sql;

    public DataBaseVerification(String sql)
    {
        this.sql=sql;
    }

    public boolean VerificationLogin() throws Exception {


        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","12345678");

        //通过数据库对象获取sql执行对象
        Statement st= null;
        try {
            st = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        //定义sql
        String DataMatchSQL=sql;

        //返回执行成功(受到影响)的命令数

        int count1=st.executeUpdate(DataMatchSQL);

        if (count1>0)
        {
            System.out.println("与数据库中匹配!");
            return true;
        }
        else
        {
            System.out.println("与数据库中不匹配!");
            return false;
        }


        }


}
