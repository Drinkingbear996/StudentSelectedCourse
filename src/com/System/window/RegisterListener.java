package com.System.window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterListener implements  ActionListener   {



    @Override
    public void actionPerformed(ActionEvent e) {

        //创建对象，调用注册器方法
     new RegisterUser();

    }
}
