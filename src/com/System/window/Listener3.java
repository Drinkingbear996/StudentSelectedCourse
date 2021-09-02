package com.System.window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//启动单独一个类，其他代码写一个类
public class Listener3 {
    public static void main(String[] args) {

        //启动
        new MyFrame();


    }
}

//类继承Frame
class MyFrame extends Frame
{

    public MyFrame()
    {
        TextField textField=new TextField();
        add(textField);
        pack();
        setVisible(true);

        //创建监听器的实现类
        MyListener3 myListener3 = new MyListener3();

        //放入监听器 按下enter就触发这个输入框事件
        textField.addActionListener(myListener3);

        //设置替换编码
        //比如输入密码都为****
        textField.setEchoChar('*');

    }

}
//ActionListener 监听器实现类

class MyListener3 implements ActionListener
{
    //单行文本域被enter之后发生的事

    @Override
    public void actionPerformed(ActionEvent e) {

        //所以，我们只要向下转型就可以获取文本域的内容
        TextField textField=( TextField)e.getSource();  /*  获得一些资源，返回一个Object对象*/

        System.out.println(textField.getText());/*  获取输入的文本*/

        //按完enter后就输入为空
        textField.setText("");

    }
}
