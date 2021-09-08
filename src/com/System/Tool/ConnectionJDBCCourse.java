package com.System.Tool;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ConnectionJDBCCourse {


 public String  result;

public ArrayList<String> arrayList;
    //输入你要查询的内容
    public ArrayList<String> SQL() throws SQLException {
        //通过数据库对象获取sql执行对象


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

                arrayList.add(set.getString("courseID"));
                arrayList.add(set.getString("courseName"));
                arrayList.add(set.getString("credit"));
                arrayList.add(set.getString("CourseCount"));
            }

        }catch (Exception e)
        {
            System.out.println("查询时发送错误");
        }
        return arrayList ;
    }

    public static void main(String[] args) throws SQLException {
       ArrayList<String> a= new ArrayList<>();
       a=new ConnectionJDBCCourse().SQL();

       Iterator<String> i=a.iterator();
       while(i.hasNext())
       {
           System.out.println("信息"+i.next()+"");
       }
    }
}
