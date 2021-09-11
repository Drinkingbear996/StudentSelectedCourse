package com.System.Backstage;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class AddCourseForStudent {
    public String selectCourseID;
    public String selectCourseName;
    public String Studentname;

    public AddCourseForStudent(String selectCourseID, String selectCourseName,String Studentname) throws SQLException {
        this.selectCourseID=selectCourseID;
        this.selectCourseName=selectCourseName;
        this.Studentname=Studentname;

    }


    public void init() throws SQLException {



        String INSERTSQL="insert into SelectedCourse(SelectedCourseID,SelectedCourseName,StudentName) values (?,?,?)";

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","12345678");

        //通过数据库对象获取sql执行对象

        PreparedStatement pst;


        pst = con.prepareStatement(INSERTSQL);
        try {


            //拿到课程表信息与输入信息比对
            ArrayList<ConnectionJDBCCourse> list=new ConnectionJDBCCourse().SQL();

            int judge=0;
            for (ConnectionJDBCCourse i:list) {
              if ((i.courseID.equals(selectCourseID))&&(i.courseName.equals(selectCourseName)))
              {

                  System.out.println("已找到课程，正在添加！");

                  pst.setString(1,selectCourseID);
                  pst.setString(2,selectCourseName);
                  pst.setString(3,Studentname);

                 judge= pst.executeUpdate();
                  if (judge>0)
                  {
                      JOptionPane.showMessageDialog(null,"课程添加成功");
                      System.out.println("学生添加数据课程成功！");
                      break;
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null,"课程添加失败");
                      System.out.println("学生添加课程数据失败！");
                      break;
                  }


              }
              else  if(!(i.courseID.equals(selectCourseID))||!(i.courseName.equals(selectCourseName)))
              {
                  System.out.println("查无此课程，继续搜索中");
              }



            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("查找数据库错误");


        }
    }

    public static void main(String[] args) throws SQLException {
         new AddCourseForStudent("2","java","黄伟超").init();
    }
}
