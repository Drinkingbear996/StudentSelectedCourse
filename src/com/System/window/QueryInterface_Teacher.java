package com.System.window;

import com.System.Teacher_Window.AddORDeleteCourse;
import com.System.Teacher_Window.AllCourseForTeacher;
import com.System.Teacher_Window.MyTeaching;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QueryInterface_Teacher  extends JFrame {


    private JFrame jFrame;
    private JPanel jPanel;
    private String name;

    public QueryInterface_Teacher()
    {
       initQueryInterface_Teacher();
    }

    public void initQueryInterface_Teacher()
    {

        JOptionPane.showMessageDialog(this,"欢迎进入学生选课管理系统！");

        //尺寸
        setSize(600,500);
        setLayout(new GridLayout(2,2));
        setVisible(true);

        jPanel=new JPanel();
        JButton jb1=new JButton("创建/删除课程");
        JButton jb2=new JButton("所有课程");
        JButton jb3=new JButton("我的授课");
        JButton jb4=new JButton("退出系统");


        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddORDeleteCourse();
                removeNotify();
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new AllCourseForTeacher();
                removeNotify();
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyTeaching();
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

}
