package com.System.window;

import javax.swing.*;

public class SuccessDialog  extends JFrame{

    //提示信息可以变化
    public  SuccessDialog(String tips)
    {
        //关闭窗口
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int result = JOptionPane.showConfirmDialog(this, tips, "确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if(result == JOptionPane.OK_OPTION){


            new login().init();
            this.dispose();

        }

       else if (result==JOptionPane.CANCEL_OPTION) {
           new login().init();
           this.dispose();

        }
    }



}
