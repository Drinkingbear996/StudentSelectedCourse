package com.System.window;


import com.System.Backstage.DataBaseVerification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 批注：
 规定：教师是(纯英文) 名字拼音，学生是学号(纯数字)
 */

/**
 * 登录
 * */

public class LoginListener  implements ActionListener {

    //传入部门和用户名 和窗口
    private String User_Verification;

    private  String Department_Verification;

    JFrame jFrame;
    public LoginListener(String User_Verification,String Department_Verification,JFrame jFrame) throws Exception {


        this.User_Verification=User_Verification;
        this.Department_Verification=Department_Verification;
        this.jFrame=jFrame;

    }



    public LoginListener() {

    }



    @Override
    public void actionPerformed(ActionEvent e) {


        /**
         * 跳转到学生界面
         * */
        if ("学生".equals(Department_Verification))
        {
            //则判定为学生


            //再调用DataBase中的构造方法实现SQL语句的查询
            boolean result= false;

            try {
                //调用VerificationLogin()方法判断数据库密码是否正确
                result = new DataBaseVerification("select password from Student where user="+User_Verification).VerificationLogin();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            //数据库判定密码是否正确
            if (result==true)
            {
                //跳转学生界面
                new QueryInterface_Student();
                jFrame.removeNotify();
            }
            else
            {

                JOptionPane.showMessageDialog(null,"密码不正确");
            }
        }
        else  if ("老师".equals(Department_Verification))
        {
            //则判定为老师

            boolean result = false;

            try {
                result = new DataBaseVerification("select password from teacher where user="+"'"+User_Verification+"'").VerificationLogin();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            //数据库判定密码是否正确
            if (result==true)
            {
                //跳转老师界面

                 new QueryInterface_Teacher();
                 //关闭原窗口,跳转
                jFrame.removeNotify();
            }

            else
            {
                JOptionPane.showMessageDialog(null,"密码不正确");
            }

        }

        /**
         * 跳转到老师界面
         * */

    }

    public static void main(String[] args) {





    }
}
