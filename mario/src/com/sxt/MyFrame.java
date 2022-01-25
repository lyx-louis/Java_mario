package com.sxt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
//1. 初始化窗口
//2. 静态初始所有的图像文件
//3.创建background 类， 并在窗口上打印






public class MyFrame extends JFrame implements KeyListener {
    // 存储所有的背景
    private List<BackGround> allBg = new ArrayList<>();
    // 用于存储当前的背景
    private BackGround nowBg = new BackGround();
    //双缓存 ?
    private Image offScreenImage = null;

    //马里奥对象
    private Mario mario = new Mario();


    public MyFrame(){
        // 设置窗口的大小
        this.setSize(800,600);
        // 窗口居中显示
        this.setLocationRelativeTo(null);
        // 窗口的可见性
        this.setVisible(true);
        //点击关闭就结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //窗口大小不可变
        this.setResizable(false);
        // 添加键盘监听
        this.addKeyListener(this);
        // set title
        this.setTitle("SuperMario");

        // init images
        StaticValue.init();

        //初始化马里奥
        mario = new Mario(10,395);

        // 创建全部场景
        for(int i=1;i<=3;i++){
            allBg.add(new BackGround(i,i== 3 ? true : false));
            // i 是不是最后一张？
        }
        // 初始化场景
        nowBg = allBg.get(0);
        //绘制图像
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if(offScreenImage == null){
            offScreenImage = createImage(800,600);
        }

        Graphics graphics = offScreenImage.getGraphics();
        graphics.fillRect(0,0,800,600);

        //绘制背景  绘制了nowBg的值
        graphics.drawImage(nowBg.getBgImage(),0,0,this);

        // 绘制障碍物
        for(Obstacle ob:nowBg.getObstacleList()){
            graphics.drawImage(ob.getShow(),ob.getX(),ob.getY(),this);
        }
        // 绘制城堡
        graphics.drawImage(nowBg.getTower(),620,270,this);
        //绘制旗杆
        graphics.drawImage(nowBg.getGan(),500,220,this);

        //绘制马里奥
        graphics.drawImage(mario.getShow(),mario.getX(),mario.getY(),this);


        //绘制到窗口中
        g.drawImage(offScreenImage,0,0,this);
    }

    public static void main(String[] args) {
        MyFrame s = new MyFrame();
        for(int i = 1;i<2;i++){
            System.out.println("hello");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
