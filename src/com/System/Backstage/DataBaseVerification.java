package com.System.Backstage;
import com.System.Student_Window.AllCourse;
import com.System.window.QueryInterface_Student;
import com.System.window.QueryInterface_Teacher;

import javax.swing.*;
import java.sql.*;

public class DataBaseVerification {

    //传入部门和用户名 和密码
    private String UserVer;
    private String passwordVer=null;


    public DataBaseVerification(String User_Verification, String password_Verification) throws  Exception {


        UserVer =User_Verification;
        passwordVer=password_Verification;
        System.out.println("密码："+passwordVer);
        System.out.println("账号:"+UserVer);


    }



    public void VerificationLogin() throws SQLException{

        String sql="select  department from loginInformation where user=? and password=? ";

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","12345678");

        //通过数据库对象获取sql执行对象


        try {
            PreparedStatement pst;
            ResultSet rs;

            pst = con.prepareStatement(sql);
            pst.setString(1,"'"+UserVer+"'" );
            pst.setString(2,"'"+passwordVer+"'");

            rs=pst.executeQuery();

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
                System.out.println("与数据库中无此用户!");
                    JOptionPane.showMessageDialog(null,"与数据库中无此用户");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("查找数据库错误");
        }


        }

    public static void main(String[] args) {

    }

}
