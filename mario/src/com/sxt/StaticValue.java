package com.sxt;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StaticValue {
    // background
    public static BufferedImage bg = null;
    public static BufferedImage bg2 = null;

    // left jump
    public static BufferedImage jump_L = null;

    // right jump
    public static BufferedImage jump_R = null;

    // stand left
    public static BufferedImage stand_L = null;

    // right stand
    public static BufferedImage stand_R = null;

    // tower
    public static BufferedImage tower = null;

    // flag
    public static BufferedImage flags = null;

    // obstacle
    public static List<BufferedImage> obstacle = new ArrayList<>();

    // run left
    public static List<BufferedImage> run_L = new ArrayList<>();

    // run right
    public static List<BufferedImage> run_R = new ArrayList<>();

    //mushroom
    public static List<BufferedImage> mushroom = new ArrayList<>();

    //flower
    public static List<BufferedImage> flower = new ArrayList<>();

    // path variable
    public static String path = System.getProperty("user.dir") +File.separator+"mario" +File.separator+"src"+File.separator+"images"+File.separator;
    // 区分windows 和 linux 的分隔符 Windows \ linux /
    // intitiate
    public static void init(){
        System.out.println(path);
        try {
            bg = ImageIO.read(new File(path + "bg.png"));
            bg2 = ImageIO.read(new File(path+"bg2.png"));
            stand_L = ImageIO.read(new File(path+"s_mario_stand_L.png"));
            stand_R = ImageIO.read(new File(path+"s_mario_stand_R.png"));
            tower = ImageIO.read(new File(path+"tower.png"));
            flags =  ImageIO.read(new File(path+"gan.png"));
            jump_L =  ImageIO.read(new File(path+"s_mario_jump1_L.png"));
            jump_R =  ImageIO.read(new File(path+"s_mario_jump1_R.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // run left init
        for(int i = 1;i<=2;i++){
            try {
                run_L.add(ImageIO.read(new File(path+"s_mario_run"+i+"_L.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // run right init
        for(int i = 1;i<=2;i++){
            try {
                run_R.add(ImageIO.read(new File(path+"s_mario_run"+i+"_R.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //init obstacle
        try {
            obstacle.add(ImageIO.read(new File(path+"brick.png")));
            obstacle.add(ImageIO.read(new File(path+"soil_up.png")));
            obstacle.add(ImageIO.read(new File(path+"soil_base.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // init tube
        for(int i = 1;i<=4;i++){
            try {
                obstacle.add(ImageIO.read(new File(path+"pipe"+i+".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // init unbreakable block and flag

        try {
            obstacle.add(ImageIO.read(new File(path+"brick2.png")));
            obstacle.add(ImageIO.read(new File(path+"flag.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // init mushroom

        for(int i = 1;i<=3;i++){
            try {
                mushroom.add(ImageIO.read(new File(path+"fungus"+i+".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // init flower

        for(int i = 1;i<=2;i++){
            try {
                flower.add(ImageIO.read(new File(path+"flower1."+i+".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
