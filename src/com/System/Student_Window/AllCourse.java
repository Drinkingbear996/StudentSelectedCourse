package com.System.Student_Window;

import com.System.Tool.ConnectionJDBC;
import com.System.Tool.ConnectionJDBCCourse;
import com.System.window.QueryInterface_Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** 默认是320 350*/


public class AllCourse extends JFrame {

  private   JPanel jPanelTop;
  private   JPanel jPanelBottom;
  private JPanel output;

    ArrayList<String> list;

public AllCourse() throws SQLException {
    init();
}



    public void init() throws SQLException {
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setSize(320,350);
        setLayout( new BorderLayout());


       jPanelTop=new JPanel();
        jPanelBottom=new JPanel();
        output=new JPanel();

       jPanelTop.setVisible(true);
       jPanelTop.setLayout(new FlowLayout());

        jPanelBottom.setVisible(true);
        jPanelBottom.setLayout(new FlowLayout());

        output.setVisible(true);
        output.setLayout(new BorderLayout());



/** ---------------------------------------------------------*/
       JButton back=new JButton("返回");
       back.setSize(10,25);
        jPanelTop.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new QueryInterface_Student();
                removeNotify();
            }
        });



        JButton SearchBtn=new JButton("点击查询所有课程");
        SearchBtn.setSize(10,25);
        jPanelTop.add(SearchBtn);





/** ---------------------------------------------------------*/

      JLabel OutPutLabel=new JLabel("显示框");
        OutPutLabel.setSize(80,25);

      output.add(OutPutLabel,BorderLayout.NORTH);

      //显示文本
        JTextArea jTextArea=new JTextArea(10,10);
        jTextArea.setBounds(100,20,165,25);
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);//如果内容过长，自动换行，在文本域加上滚动条，水平和垂直滚动条始终出现。




        output.add(jTextArea,BorderLayout.CENTER);

/** ---------------------------------------------------------*/

       JLabel OutputUser=new JLabel("欢迎进入!");

       jPanelBottom.add(OutputUser,BorderLayout.SOUTH);

/** ---------------------------------------------------------*/
        add(jPanelTop,BorderLayout.NORTH);
        add(output,BorderLayout.CENTER);
        add(jPanelBottom,BorderLayout.SOUTH);


        //监听查询按钮
        SearchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jTextArea.setText("");
                try {
                    list=new ConnectionJDBCCourse().SQL();


                    jTextArea.append("课程编号  课程名称  课程学分  课程人数\r\n");

                    for (int i = 0; i < list.size(); i++) {

                        if(i==3)
                        {
                            System.out.println();
                        }
                        else
                        {
                            jTextArea.append(list.get(i)+"          ");
                        }


                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });


    }

    public static void main(String[] args) throws SQLException {
        new  AllCourse();
    }
}
