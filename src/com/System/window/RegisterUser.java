package com.System.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUser extends JFrame {


    public RegisterUser()
    {
        JFrame jframe =new JFrame("注册界面");

        jframe.setVisible(true);


        jframe.setSize(400,400);
        jframe.setBackground(Color.white);

        //窗口可以设置默认关闭
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //创建面板
        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);

        jframe.add(jPanel);

        //登录面板
        RegisterPanelContent(jPanel);
    }


    public static  void RegisterPanelContent(JPanel jPanel)
    {
        //用户
        JLabel jLabelUser=new JLabel("用户名:");
        jLabelUser.setBounds(50,20,80,25);
        jPanel.add(jLabelUser);


        JTextField JTextFieldUser=new JTextField(20);
        JTextFieldUser.setBounds(140,20,165,25);
        jPanel.add(JTextFieldUser);


        //密码 JPasswordField可用*号


        JLabel  JLabelPassword=new JLabel("密码:");
        JLabelPassword.setBounds(50,50,80,25);
        jPanel.add(JLabelPassword);

        JPasswordField jPasswordField=new JPasswordField(20);
        jPasswordField.setBounds(140,50,165,25);
        jPanel.add(jPasswordField);

        JLabel  RepeatJLabelPassword =new JLabel("确认密码:");
        RepeatJLabelPassword.setBounds(50,80,80,25);
        jPanel.add(RepeatJLabelPassword);

        JPasswordField RepeatJPasswordField=new JPasswordField(20);
        RepeatJPasswordField.setBounds(140,80,165,25);
        jPanel.add( RepeatJPasswordField);


        //注册按钮
        JButton jButton=new JButton("注册");
        jButton.setBounds(150,140,80,25);
        jPanel.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SuccessDialog("注册成功");
                TextareaListener textareaListener=new TextareaListener();

                JTextFieldUser.addActionListener(textareaListener);
                jPasswordField.addActionListener(textareaListener);

            }
        });


    }

}
