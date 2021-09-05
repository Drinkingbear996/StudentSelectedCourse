package com.System.window;

import com.System.Backstage.DataBaseStorageInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.JarURLConnection;

public class RegisterUser extends JFrame  {




    public RegisterUser()
    {
        JFrame jframe =new JFrame("注册界面");

        jframe.setVisible(true);


        jframe.setSize(400,300);
        jframe.setBackground(Color.white);

        //窗口可以设置默认关闭
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //创建面板
        JPanel jPanel=new JPanel();
        jPanel.setLayout(null);

        jframe.add(jPanel);

        //登录面板
      PanelContent(jPanel);

    }

    public static  void PanelContent(JPanel jPanel)
    {
        //用户
        JLabel jLabelUser=new JLabel("用户名:");
        jLabelUser.setBounds(50,20,80,25);
        jPanel.add(jLabelUser);


        JTextField juser=new JTextField(20);
        juser.setBounds(140,20,165,25);
        jPanel.add(juser);


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

        //姓名
        JLabel jLabelName=new JLabel("姓名:");
        jLabelName.setBounds(50,110,80,25);
        jPanel.add(jLabelName);


        JTextField jName=new JTextField(20);
        jName.setBounds(140,110,165,25);
        jPanel.add(jName);

        //部门
        JLabel jLabelDepartment=new JLabel("部门:");
        jLabelDepartment.setBounds(50,140,80,25);
        jPanel.add(jLabelDepartment);

        ButtonGroup buttonGroup=new ButtonGroup();
        JCheckBox jCheckBox1=new JCheckBox("学生");
        JCheckBox jCheckBox2=new JCheckBox("老师");

        jCheckBox1.setBounds(140,140,80,25);
        jCheckBox2.setBounds(200,140,80,25);

        buttonGroup.add(jCheckBox1);
        buttonGroup.add(jCheckBox2);





        jPanel.add(jCheckBox1);
        jPanel.add(jCheckBox2);



        //注册按钮
        JButton jButton=new JButton("注册");
        jButton.setBounds(140,170,80,25);
        jPanel.add(jButton);


      //获取账号和密码信息
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //获取账号
                String User=juser.getText();

                //获取密码
                String Password=String.valueOf(jPasswordField.getPassword());
                String RepeatPassword=String.valueOf(jPasswordField.getPassword());

                //获取姓名和部门
                String  name=jName.getText();

                String Department;
                if (jCheckBox1.isSelected()==true)
                {
                    Department=jCheckBox1.getText();
                    System.out.println(Department);
                }
                else
                {
                    Department=jCheckBox2.getText();
                    System.out.println(Department);
                }


                System.out.println("user:"+juser.getText());
                System.out.println("name:"+jName.getText());
                System.out.println("password:"+Password);
                System.out.println( "RepeatPassword:"+RepeatPassword);
                System.out.println(Password.equals(RepeatPassword));
                //判断非空逻辑
                 if (User!=null&&Password.equals(RepeatPassword))
                 {
                     JOptionPane.showMessageDialog(null,"注册成功!");

                     //传入数据到数据库后台
                     try {
                         //传入
                         new  DataBaseStorageInformation(User,Password,name,Department);
                     } catch (Exception exception) {
                         exception.printStackTrace();
                     }
                     //设置为空
                     juser.setText("");
                     jPasswordField.setText("");
                     RepeatJPasswordField.setText("");
                     jName.setText("");


                 }
                 else  if (User==null)
                 {
                     JOptionPane.showMessageDialog(null,"用户名为空!");
                 }

                 else if (Password==null||RepeatPassword==null)
                 {
                     JOptionPane.showMessageDialog(null,"请输入密码!");
                 }

                 else if (!Password.equals(RepeatPassword))
                 {
                     JOptionPane.showMessageDialog(null,"两次密码不一致!");
                 }
                 else if (name==null)
                 {
                     JOptionPane.showMessageDialog(null,"姓名为空!");
                 }

                 else
                 {
                     JOptionPane.showMessageDialog(null,"请填写信息");
                 }

            }
        });
    }
}
