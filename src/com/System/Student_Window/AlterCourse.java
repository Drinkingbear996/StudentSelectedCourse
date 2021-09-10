package com.System.Student_Window;

import com.System.Backstage.AddCourseForStudent;
import com.System.Backstage.DatabaseAddCourseForTeacher;
import com.System.window.QueryInterface_Student;
import com.System.window.QueryInterface_Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class AlterCourse extends JFrame {

    private   JPanel jPanelTop;
    private   JPanel jPanelBottom;
    private JPanel output;

   private JFrame jframe;
    public AlterCourse()
    {
        jframe =new JFrame("增添课程");

        jframe.setVisible(true);


        jframe.setSize(400,300);
        jframe.setBackground(Color.white);

        //窗口可以设置默认关闭
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //创建面板
        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);

        jframe.add(jPanel);

        init(jPanel);


    }


    public void init(JPanel jPanel)
    {

        //用户
        JLabel jLabelAddCourseID=new JLabel("选择课程ID");
        jLabelAddCourseID.setBounds(50,20,80,25);
        jPanel.add(jLabelAddCourseID);


        JTextField jAddCourseID=new JTextField(20);
        jAddCourseID.setBounds(140,20,165,25);
        jPanel.add(jAddCourseID);


        JLabel jLabelAddCourseName=new JLabel("选择课程名称");
        jLabelAddCourseName.setBounds(50,50,80,25);
        jPanel.add(jLabelAddCourseName);


        JTextField jAddCourseName=new JTextField(20);
        jAddCourseName.setBounds(140,50,165,25);
        jPanel.add(jAddCourseName);


        JLabel jLabelName=new JLabel("姓名");
        jLabelName.setBounds(50,80,80,25);
        jPanel.add(jLabelName);

        JTextField Name=new JTextField(20);
        Name.setBounds(140,80,165,25);
        jPanel.add(Name);

        //登录按钮
        JButton jButtonAdd=new JButton("添加");
        jButtonAdd.setBounds(130,140,80,25);
        jPanel.add(jButtonAdd);

        JButton jButtonReturn=new JButton("返回");
        jButtonReturn.setBounds(240,140,80,25);
        jPanel.add(jButtonReturn);

        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseID=jAddCourseID.getText();
                String CourseName=jAddCourseName.getText();
                String SelectedName=Name.getText();

                try {
                 new AddCourseForStudent(courseID,CourseName,SelectedName).init();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });

        jButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new QueryInterface_Student();
               jframe.removeNotify();
            }
        });
        pack();

    }

    public static void main(String[] args) {
        new AlterCourse();
    }
}
