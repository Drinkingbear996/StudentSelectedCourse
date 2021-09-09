package com.System.Backstage;

import javax.swing.*;
import java.sql.*;

public class DatabaseAddCourseForTeacher extends JFrame {

    private  String courseID;
    private  String courseName;
    private  String courseCredit;

    public DatabaseAddCourseForTeacher(String courseID, String courseName, String courseCredit) throws SQLException {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCredit = courseCredit;

    }



    public void init() throws SQLException {

        String sql="insert into course(courseID,courseName,credit) values (?,?,?) ";

        //获取连接数据库对象
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","12345678");
        //通过数据库对象获取sql执行对象
        PreparedStatement ps ;
        try {


            ps = con.prepareStatement(sql);

            ps.setString(1,courseID);
            ps.setString(2,courseName);
            ps.setString(3,courseCredit);



            //返回执行成功(受到影响)的命令数

            int count1=ps.executeUpdate(sql);
            if (count1>0)
            {
                System.out.println("信息已经添加至数据库!");
                JOptionPane.showMessageDialog(this,"添加成功");
            }
            else
            {
                System.out.println("数据添加失败!");
                JOptionPane.showMessageDialog(this,"添加失败");
            }
            ps.close();
            con.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }







    }
}
