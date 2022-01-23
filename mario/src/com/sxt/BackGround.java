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
}
