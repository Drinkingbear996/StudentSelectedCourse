package com.System.window;

import com.System.Backstage.DataBaseVerification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 批注：

 */

/**
 * 登录
 * */

public class LoginListener  implements ActionListener   {

    private String User_Verification;
    private String password_Verification;

    JFrame jFrame;
    public LoginListener(String User_Verification,String password_Verification)
    {
        this.User_Verification=User_Verification;
        this.password_Verification=password_Verification;

    }




    @Override
    public void actionPerformed(ActionEvent e)   {

        new DataBaseVerification(User_Verification,password_Verification).VerificationLogin();




        JOptionPane.showMessageDialog(jFrame,"登录成功！");

    }

}
