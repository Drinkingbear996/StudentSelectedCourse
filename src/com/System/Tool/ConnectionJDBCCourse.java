package com.System.Tool;

import com.mysql.cj.xdevapi.Table;

import java.sql.*;
import java.util.ArrayList;
public class ConnectionJDBCCourse {

    public String courseID;
    public String courseName;
    public String credit;



    public ConnectionJDBCCourse(String courseID,String courseName, String credit)
    {
        this.courseID=courseID;
        this.courseName=courseName;
        this.credit=credit;
    }

    public ConnectionJDBCCourse() throws SQLException {

    }

    //输入你要查询的内容
    public ArrayList<ConnectionJDBCCourse> SQL() throws SQLException {
        //通过数据库对象获取sql执行对象
       ArrayList<ConnectionJDBCCourse> arrayList;

        //学号为唯一标识
        String sql = "select * from course  ";
//  获取数据库连接对象 Connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345678");
        //获取sql执行对象
        PreparedStatement ps = null;
        //返回结果集
        ResultSet set = null;

        arrayList=new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);


            //执行sql
            set = ps.executeQuery();


            while (set.next()) {

                arrayList.add(
                new ConnectionJDBCCourse(
                        set.getString("courseID"),
                        set.getString("courseName"),
                        set.getString("credit")
                      )

                              );

            }

        }catch (Exception e)
        {
            System.out.println("查询时发送错误");
        }
        return arrayList ;
    }



    public static void main(String[] args) throws SQLException {
        ArrayList<ConnectionJDBCCourse> a= new ConnectionJDBCCourse().SQL();

        for (ConnectionJDBCCourse i:a) {
            System.out.println(i.courseID);
            System.out.println(i.courseName);
            System.out.println(i.credit);

        }

    }
}
