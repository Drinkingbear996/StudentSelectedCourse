package com.System.Backstage;

import com.System.Teacher_Window.QuaryCourseForStudent;
import com.System.Tool.ConnectionJDBCCourse;

import java.sql.*;
import java.util.ArrayList;

public class QuaryCountAccordingCourse {

    public String courseID;
    public String CourseName;
    public String SelectedName;


    public QuaryCountAccordingCourse(String courseID, String courseName, String selectedName) {
        this.courseID = courseID;
        this.CourseName = courseName;
        this.SelectedName = selectedName;
    }



    public QuaryCountAccordingCourse()
    {

    }

    public ArrayList<QuaryCountAccordingCourse> SQL(String CourseName) throws SQLException {
        //通过数据库对象获取sql执行对象
        ArrayList<QuaryCountAccordingCourse> arrayList=new ArrayList<>();

        //学号为唯一标识

        String SQLList="select  * from SelectedCourse where SelectedCourseName=?";

//  获取数据库连接对象 Connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345678");
        //获取sql执行对象
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;

        //返回结果集
        ResultSet set = null;

        ResultSet set1=null;

        try {
            ps = con.prepareStatement(SQLList);
            ps.setString(1,CourseName);

            //执行sql
            set = ps.executeQuery();


            while (set.next()) {

                arrayList.add(
                        new QuaryCountAccordingCourse(
                                set.getString("SelectedCourseID"),
                                set.getString("SelectedCourseName"),
                                set.getString("StudentName")
                        )

                );

            }

        }catch (Exception e)
        {
            System.out.println("查询时发送错误");
        }
        return arrayList ;
    }

    public String Count(String CourseName) throws SQLException {

        String SQLcount = "select   count(ifnull(StudentName,0)) from SelectedCourse where SelectedCourseName=?  ";

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345678");
        //获取sql执行对象
        PreparedStatement ps1 = null;

        //返回结果集
        ResultSet set1=null;

        ps1 = con.prepareStatement(SQLcount);


        //执行sql
        set1 = ps1.executeQuery();

        String result;
        if (set1.next())
        {
             result=set1.getString(1);
            return result;
        }
        else
        {
            return "0";
        }
    }
}