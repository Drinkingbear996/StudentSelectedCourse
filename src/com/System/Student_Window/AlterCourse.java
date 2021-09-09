package com.System.Student_Window;

import com.System.window.QueryInterface_Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AlterCourse extends JFrame {

    private   JPanel jPanelTop;
    private   JPanel jPanelBottom;
    private JPanel output;

    public  AlterCourse()
    {
        init();
    }


    public void init()
    {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(320,350);
        setLayout( new BorderLayout());
        setVisible(true);

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


        JLabel LabelSearch=new JLabel("搜索课程");
        LabelSearch.setSize(80,25);
        jPanelTop.add(LabelSearch);


        JTextField Search=new JTextField(10);
        Search.setSize(165,25);
        jPanelTop.add(Search);

        //获取内容
        String input=Search.getText();



        JButton addCourse=new JButton("添加课程");
        addCourse.setSize(5,25);
        jPanelTop.add(addCourse);


/** ---------------------------------------------------------*/

        JLabel OutPutLabel=new JLabel("显示框");
        OutPutLabel.setSize(80,25);

        output.add(OutPutLabel,BorderLayout.NORTH);

        JTextArea jTextArea=new JTextArea(10,10);
        jTextArea.setBounds(100,20,165,25);
        jTextArea.setEditable(false);
        output.add(jTextArea,BorderLayout.CENTER);

/** ---------------------------------------------------------*/

        JLabel OutputUser=new JLabel("欢迎进入!");

        jPanelBottom.add(OutputUser,BorderLayout.SOUTH);

/** ---------------------------------------------------------*/
        add(jPanelTop,BorderLayout.NORTH);
        add(output,BorderLayout.CENTER);
        add(jPanelBottom,BorderLayout.SOUTH);


        pack();


    }

}
