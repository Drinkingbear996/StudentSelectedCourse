package com.System.Backstage;
import com.System.window.QueryInterface_Student;
import com.System.window.QueryInterface_Teacher;

import javax.swing.*;
import java.sql.*;

public class DataBaseVerification {

    //传入部门和用户名 和密码
    private String User_Verification;
    private String password_Verification;

    public DataBaseVerification(String User_Verification, String password_Verification) throws  Exception {


        this.User_Verification=User_Verification;
        this.password_Verification=password_Verification;



    }
    public DataBaseVerification()
    {

    }



    public void VerificationLogin() throws Exception {

        String sql="select  department from loginInformation where user=? and password=? ";

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","12345678");

        //通过数据库对象获取sql执行对象
        PreparedStatement pst= null;
        try {
            pst = con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        //返回结果集
        ResultSet rs=pst.executeQuery(sql);
        pst.setString(1,User_Verification);
        pst.setString(2,password_Verification);


        //如果能匹配
        if (rs.next())
        {
            System.out.println("与数据库中匹配!");

            String department = rs.getString("department");

            if ("学生".equals(department))
            {
                new QueryInterface_Student();
            }
            else  if ("老师".equals(department))
            {
                new QueryInterface_Teacher();
            }


        }
        else
        {
            System.out.println("与数据库中不匹配!");

        }








        }


}
