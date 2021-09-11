package com.System.Student_Window;

import com.System.Backstage.QuaryCountAccordingCourse;
import com.System.window.QueryInterface_Student;
import com.System.window.QueryInterface_Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyCourse  extends JFrame {
   public   JPanel jPanelTop;
   public   JPanel jPanelBottom;
    public JPanel output;

    public  MyCourse()
    {
        init();
    }


    public void init() {
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(320, 350);
        setLayout(new BorderLayout());


        jPanelTop = new JPanel();
        jPanelBottom = new JPanel();
        output = new JPanel();

        jPanelTop.setVisible(true);
        jPanelTop.setLayout(new FlowLayout());

        jPanelBottom.setVisible(true);
        jPanelBottom.setLayout(new FlowLayout());

        output.setVisible(true);
        output.setLayout(new BorderLayout());


/** ---------------------------------------------------------*/
        JButton back = new JButton("返回");
        back.setSize(10, 25);
        jPanelTop.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new QueryInterface_Student();
                removeNotify();
            }
        });

        JLabel LabelSearch = new JLabel("请输入名字");
        LabelSearch.setSize(80, 25);
        jPanelTop.add(LabelSearch);


        JTextField Search = new JTextField(10);
        Search.setSize(165, 25);
        jPanelTop.add(Search);


        JButton SearchBtn = new JButton("查询");
        SearchBtn.setSize(10, 25);
        jPanelTop.add(SearchBtn);


/** ---------------------------------------------------------*/

        JLabel OutPutLabel = new JLabel("显示框:   当前已选择的课程：");
        OutPutLabel.setSize(80, 25);

        output.add(OutPutLabel, BorderLayout.NORTH);

        //显示文本
        JTextArea jTextArea = new JTextArea(10, 10);
        jTextArea.setBounds(100, 20, 165, 25);
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);//如果内容过长，自动换行，在文本域加上滚动条，水平和垂直滚动条始终出现。


/** ---------------------------------------------------------*/

        JLabel OutputUser = new JLabel("欢迎进入!");

        jPanelBottom.add(OutputUser, BorderLayout.SOUTH);

/** ---------------------------------------------------------*/
        add(jPanelTop, BorderLayout.NORTH);
        add(output, BorderLayout.CENTER);
        add(jPanelBottom, BorderLayout.SOUTH);


        //监听查询按钮
        SearchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //点击前先初始化
                jTextArea.setText("");
                //获取按输入内容
                String input = Search.getText();


                ArrayList<QuaryCountAccordingCourse> list = null;
                try {

                    list = new QuaryCountAccordingCourse().SQLForSelectedStudentName(input);
                    jTextArea.append("课程ID" + "\t" + "课程名称:" + "\t" + "学生姓名:" + "\t" + "\n\r");
                    for (QuaryCountAccordingCourse i : list) {
                        jTextArea.append(i.courseID + "\t");
                        jTextArea.append(i.CourseName + "\t");
                        jTextArea.append(i.SelectedName + "\t" + "\n\r");
                    }
                    OutPutLabel.setText("显示框:      "+input + "当前已选择的课程：");

                    output.add(jTextArea, BorderLayout.CENTER);


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        new MyCourse();
    }
}
