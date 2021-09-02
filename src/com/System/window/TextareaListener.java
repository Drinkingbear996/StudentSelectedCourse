package com.System.window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TextareaListener  implements ActionListener {


    @Override
    public  void actionPerformed(ActionEvent e) {
        /*  获得一些资源，返回一个Object对象*/
        //所以，我们只要向下转型就可以获取文本域的内容

           JTextField jTextFieldFinish=(JTextField)e.getSource();
           System.out.println(jTextFieldFinish.getText());/*  获取输入的文本*/
        //按完enter后就输入为空
        jTextFieldFinish.setText("");
    }
}
