package com.System.window;

import com.System.Student_Window.AllCourse;
import com.System.Student_Window.AlterCourse;
import com.System.Student_Window.MyCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/** 标准600x500*/
public class QueryInterface_Student extends JFrame {

    private JFrame jFrame;
    private JPanel jPanel;
    private String name;

    public QueryInterface_Student()

    {

        initQueryInterface_Student();
    }

    public void initQueryInterface_Student()
    {


        JOptionPane.showMessageDialog(this,"欢迎进入学生选课管理系统！");

        //尺寸
        setSize(600,500);
        setLayout(new GridLayout(2,2));
        setVisible(true);

        jPanel=new JPanel();
        JButton jb1=new JButton("我的课程");
        JButton jb2=new JButton("全部课程");
        JButton jb3=new JButton("修改课程信息");
        JButton jb4=new JButton("退出系统");


        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new MyCourse();
                removeNotify();
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AllCourse();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                removeNotify();
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new AlterCourse();
                removeNotify();
            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        new QueryInterface_Student();
    }

}
