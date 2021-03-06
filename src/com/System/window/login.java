package com.System.window;

import com.System.Backstage.DataBaseVerification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 规范：上下间隔30
**/
public class login extends JFrame  {

    JFrame jframe =new JFrame("学生选课系统");

    public static void main(String[] args) throws Exception {

    //登录
    new login().init();
    }

    public void init() throws Exception {


        jframe.setVisible(true);


        jframe.setSize(320,350);
        jframe.setBackground(Color.white);

        //窗口可以关闭
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       //创建面板
        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);

        jframe.add(jPanel);

        PanelContent(jPanel,jframe);

   //打开注册，隐藏窗口


    }

    private    void PanelContent(JPanel jPanel,JFrame jFrame) throws Exception {
        //用户
        JLabel jLabelUser=new JLabel("用户名:");
        jLabelUser.setBounds(50,20,80,25);
        jPanel.add(jLabelUser);


        JTextField JTextFieldUser=new JTextField(20);
        JTextFieldUser.setBounds(100,20,165,25);
        jPanel.add(JTextFieldUser);


        //密码 JPasswordField可用*号
        JLabel  JLabelPassword=new JLabel("密码:");
        JLabelPassword.setBounds(50,50,80,25);
        jPanel.add(JLabelPassword);


        JPasswordField jPasswordField=new JPasswordField(20);
        jPasswordField.setBounds(100,50,165,25);
        jPanel.add(jPasswordField);

        //登录按钮
        JButton jButton=new JButton("登录");
        jButton.setBounds(100,100,80,25);
        jPanel.add(jButton);






        //调用登录监听
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //获取输入的用户名和密码
                String InputUser = JTextFieldUser.getText();
                String InputPassword = String.valueOf(jPasswordField.getPassword());

                System.out.println("获取账号:" + InputUser);
                System.out.println("获取密码:" + InputPassword);

                if (InputPassword.isEmpty() || InputUser.isEmpty()) {
                    JOptionPane.showMessageDialog(jframe, "用户名或密码未完全填写");

                    new login();
                } else {

                try {
                    //验证账号密码
                    new DataBaseVerification(InputUser, InputPassword,jFrame).VerificationLogin();

                } catch (Exception exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "登录错误");
                    //返回登录界面
                    new login();
                    jFrame.removeNotify();
                }
            }
            }
        });


        //注册
        JButton JRegisterButton=new JButton("没有账户？点击注册");
        JRegisterButton.setBounds(100,150,200,25);
        jPanel.add(JRegisterButton);


        //监听注册按钮
       JRegisterButton.addActionListener(new RegisterListener());


    }



}

