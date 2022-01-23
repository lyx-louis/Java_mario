package com.sxt;

import java.awt.image.BufferedImage;

public class Obstacle {
    // 用于坐标
    private int x;
    private int y;
    // 用于记录障碍物类型
    private int type;
    // 显示图像
    private BufferedImage show = null;
    //定义当前的场景对象
    private BackGround bg = null;

    public Obstacle(int x,int y,int type,BackGround bg){
        this.x = x;
        this.y = y;
        this.type = type;
        this.bg = bg;
        show = StaticValue.obstacle.get(type); // StaticValue 根据obstacle的值来选择


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

    public BufferedImage getShow() {
        return show;
    }
}
