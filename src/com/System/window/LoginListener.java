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

    private String User_Verification;

    private  String Password_Verification;

    public LoginListener(String User_Verification,String Password_Verification) throws Exception {


        this.User_Verification=User_Verification;
        this.Password_Verification=Password_Verification;

        //调用验证方法
        verification();

    }



    public LoginListener() {

    }

    public  void verification() throws Exception {

        String regexStudent="20\\d{10}";

        String regexTeacher="^[A-Za-z]$";

        /**
         * 跳转到学生界面
         * */
        if (User_Verification.matches(regexStudent))
        {
            //则判定为学生


            //再调用DataBase中的构造方法实现SQL语句的查询
         boolean result=  new DataBaseVerification("select password from Student where user="+User_Verification).VerificationLogin();
            //数据库判定密码是否正确
            if (result==true)
            {
                //跳转学生界面

            }
           else
            {

                JOptionPane.showMessageDialog(null,"密码不正确");
            }
        }
        else  if (User_Verification.matches(regexTeacher))
        {
            //则判定为老师

            boolean result=  new DataBaseVerification("select password from Teacher where user="+User_Verification).VerificationLogin();
            //数据库判定密码是否正确
            if (result==true)
            {
                //跳转老师界面

            }
            else
            {
                JOptionPane.showMessageDialog(null,"密码不正确");
            }



        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       String user="202010139066";

       String regex="20\\d{10}";












        /**
         * 跳转到老师界面
         * */

    }

    public static void main(String[] args) {





    }
}
