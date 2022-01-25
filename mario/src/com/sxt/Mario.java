package com.sxt;

import java.awt.image.BufferedImage;

public class Mario implements Runnable{
    // 坐标
    private int x;
    private  int y;

    // 当前状态
    private  String status;

    // 用于显示当前状态对应的图像
    private BufferedImage show = null;

    // 定义一个Background 对象， 用来获取障碍物信息
    private BackGround backGround = new BackGround();

    //用来实现马里奥的动作
    private Thread thread = null;

    //移动速度
    private int xSpeed;

    //跳跃速度
    private int ySpeed;

    //定义一个变量用于取得马里奥的运动图像
    private int index;

    //向左移动给
    public void leftMove(){
        xSpeed = -5;
        if(status.indexOf("jump")!= -1) {
            status = "jump--left";
        }else{
            status = "move--left";
        }
    }

    //向右移动
    public void rightMove(){
        xSpeed = 5;
        if(status.indexOf("jump")!= -1) {
            status = "jump--right";
        }else{
            status = "move--right";
        }
    }

    // 向左停止
    public void leftStop(){
        xSpeed = 0;
        if(status.indexOf("jump")!= -1) { // 不等于-1 即出于空中
            status = "jump--left";
        }else{ // 向左移动的时候
            status = "stop--left";
        }
    }

    //向右停止
    public void rightStop(){
        xSpeed = 0;
        if(status.indexOf("jump")!= -1) {
            status = "jump--right";
        }else{
            status = "stop--right";
        }
    }



    public  Mario(){

    }

    public Mario(int x, int y){
        this.x = x;
        this.y = y;
        show = StaticValue.stand_R; // "初始化时向右站"
        this.status = "stand--right";
        thread = new Thread( this);
        thread.start();

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getShow() {
        return show;
    }

    public void setShow(BufferedImage show) {
        this.show = show;
    }

    @Override
    public void run() {
        while(true){
            if(xSpeed  <0 || xSpeed >0) {
                x += xSpeed;
                //判断是否运动打动了最左
                if(x <0){
                    x = 0;
                }
            }
            // 判断是否是移动状态
            if(status.contains("move")){
                index = index == 0 ? 1 : 0;  // index 是否为0 为0 的话变为1 否则为0
            }

            // 判断是否向左移动
            if("move--left".equals(status)){
                show = StaticValue.run_L.get(index);
            }

            //判断是否向右移动

            if("move--right".equals(status)){
                show = StaticValue.run_R.get(index);
            }

            //判断是否向左停止
            if("stop--left".equals(status)){
                show = StaticValue.stand_L;
            }

            //判断时否向右停止
            if("stop--right".equals(status)){
                show = StaticValue.stand_R;
            }

            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
