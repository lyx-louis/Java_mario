package com.sxt;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BackGround {
    // the image to show in now situation
    private BufferedImage bgImage = null;

    // which background
    private int sort;

    // to judge is the images is the last one or not
    private boolean flag;


    // to save all the obstacle
    private List<Obstacle> obstacleList = new ArrayList<>();

    // 用于显示旗杆
    private  BufferedImage gan = null;

    // 用于显示城堡
    private BufferedImage tower = null;
    public BackGround(){

    }

    public BackGround(int sort, boolean flag) {
        this.sort = sort;
        this.flag = flag;

        if(flag) {
            bgImage = StaticValue.bg2;
        }else{
            bgImage = StaticValue.bg;
        }
        // 判断是否是第一关
        if(sort == 1){
            // 绘制第一关的地面， 上地面type为1 下地面type为2
            // 窗口长800， 地面长30 循环27次
            for(int i =0; i<27;i++){
                obstacleList.add(new Obstacle(i*30,420,1,this));
            }
            for (int j = 0; j<=120;j+=30){
                for (int i = 0;i<27;i++){
                    obstacleList.add(new Obstacle(i*30,570-j,2,this));
                }
            }

            // 绘制砖块
            for(int i = 120;i<=150;i+=30){
                obstacleList.add(new Obstacle(i,300,7,this));
            }

            //
            for(int i =300;i<=570;i+=30){
                if(i==360||i==390||i==480||i==510||i==540){
                    obstacleList.add(new Obstacle(i,300,7,this));
                }else{
                    obstacleList.add(new Obstacle(i,300,0,this));
                }
            }


            //
            for(int i = 420;i<=450;i+=30){
                obstacleList.add(new Obstacle(i,240,7,this));
            }


            // 绘制水管
            for(int i = 360;i<=600;i+=25){
                if(i==360){
                    obstacleList.add(new Obstacle(620,i,3,this));
                    obstacleList.add(new Obstacle(645,i,4,this));
                }else{
                    obstacleList.add(new Obstacle(620,i,5,this));
                    obstacleList.add(new Obstacle(645,i,6,this));
                }
            }
        }

        // 判断是否为第二关

        if(sort == 2){
            for(int i =0; i<27;i++){
                obstacleList.add(new Obstacle(i*30,420,1,this));
            }
            for (int j = 0; j<=120;j+=30){
                for (int i = 0;i<27;i++){
                    obstacleList.add(new Obstacle(i*30,570-j,2,this));
                }
            }
            // 绘制第一个水管
            for(int i = 360;i<=600;i+=25){
                if(i==360){
                    obstacleList.add(new Obstacle(60,i,3,this));
                    obstacleList.add(new Obstacle(85,i,4,this));
                }else{
                    obstacleList.add(new Obstacle(60,i,5,this));
                    obstacleList.add(new Obstacle(85,i,6,this));
                }
            }
            //绘制第二个水管
            for(int i = 330;i<=600;i+=25){
                if(i==330){
                    obstacleList.add(new Obstacle(620,i,3,this));
                    obstacleList.add(new Obstacle(645,i,4,this));
                }else{
                    obstacleList.add(new Obstacle(620,i,5,this));
                    obstacleList.add(new Obstacle(645,i,6,this));
                }
            }

            // 绘制砖块

            obstacleList.add(new Obstacle(300,330,0,this));

            for(int i =270;i<=330;i+=30){
                if(i==270||i==330){
                    obstacleList.add(new Obstacle(i,360,0,this));
                }else{
                    obstacleList.add(new Obstacle(i,360,7,this));
                }
            }

            // 绘制砖块
            for(int i =240;i<=360;i+=30){
                if(i==240||i==360){
                    obstacleList.add(new Obstacle(i,390,0,this));
                }else{
                    obstacleList.add(new Obstacle(i,390,7,this));
                }
            }

            // 绘制妨碍砖块一
            obstacleList.add(new Obstacle(240,300,0,this));

            //绘制滞空砖块
            for(int i = 360;i<=540;i+=60){
                obstacleList.add(new Obstacle(i,270,7,this));
            }

        }

        if(sort == 3){
            for(int i =0; i<27;i++){
                obstacleList.add(new Obstacle(i*30,420,1,this));
            }
            for (int j = 0; j<=120;j+=30){
                for (int i = 0;i<27;i++){
                    obstacleList.add(new Obstacle(i*30,570-j,2,this));
                }
            }

            //
            int temp = 290;
            for(int i = 390;i>=270;i-=30){
                for(int j = temp;j<=410;j+=30){
                    obstacleList.add(new Obstacle(j,i,7,this));
                }
                temp += 30;
            }

            temp = 60;
            for(int i = 390;i>=360;i-=30){
                for(int j = temp;j<=90;j+=30){
                    obstacleList.add(new Obstacle(j,i,7,this));
                }
                temp += 30;
            }
            //绘制旗杆
            gan = StaticValue.flags;
            tower = StaticValue.tower;

            obstacleList.add(new Obstacle(515,220,8,this));

        }


    }

    public BufferedImage getBgImage() {
        return bgImage;
    }

    public int getSort() {
        return sort;
    }

    public boolean isFlag() {
        return flag;
    }

    public List<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public BufferedImage getGan() {
        return gan;
    }

    public BufferedImage getTower() {
        return tower;
    }
}
