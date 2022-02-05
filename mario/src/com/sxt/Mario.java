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

    //表示马里奥上升的时间
    private int upTime = 0;

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

    public void jump() {
        if(status.indexOf("jump") == -1) {
            if(status.indexOf("left")!= -1) {
                // 方向向左
                status = "jump--left";
            }else{
                // 方向向右
                status = "jump--right";
            }
            ySpeed = -10;
            upTime = 7;
        }
    }

    // 马里奥下落
    public void fall() {
        if (status.indexOf("left") != -1){
            status = "jump--left";
        }else{
            status = "jump--right";
        }
        ySpeed = 10;
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

    public void setBackGround(BackGround backGround) {
        this.backGround = backGround;
    }

    @Override
    public void run() {
        while(true){
            //判断是否处在障碍物上
            boolean onObstacle = false;

            // 遍历当前场景里所有的障碍物
            for(int i =0;i<backGround.getObstacleList().size();i++){
                Obstacle ob = backGround.getObstacleList().get(i);
                //判断是否位于障碍物上
                if(ob.getY()==this.y+25 && (ob.getX() > this.x -30 && ob.getX() < this.x + 25)) {
                    onObstacle = true;
                }
            }
            //进行跳跃的操作
            if(onObstacle && upTime == 0){
                if(status.indexOf("left") != -1) {
                    if(xSpeed!=0) {
                        // 状态为向左移动
                        status = "move--left";
                    }else{
                        status = "stop--left";
                    }
                }else{
                    if(xSpeed!=0) {
                        // 状态为向右移动
                        status = "move--right";
                    }else{
                        status = "stop--right";
                    }
                }
            }else{
                if(upTime!=0){
                    upTime --;
                }else{
                    fall();
                }
                y += ySpeed;
            }


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

            //判断是否向左跳跃
            if("jump--left".equals(status)){
                show = StaticValue.stand_L;
            }
            //判断是否向右跳跃
            if("jump--right".equals(status)){
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
