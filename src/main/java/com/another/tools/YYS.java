package com.another.tools;

import javafx.scene.control.ButtonType;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class YYS {
    public static void main(String[] args) throws InterruptedException, AWTException {
//
        int d=0;
        while(d<10){
            Point p = MouseInfo.getPointerInfo().getLocation();
            System.out.println(p.getX() + "            " + p.getY());
            TimeUnit.SECONDS.sleep(1);
            d++;
        }
        int x=2249,y=685;

        Robot robot = new Robot();
        Random rd = new Random();
        System.out.println("开始");;
        while (true) {


            robot.mouseMove(x+rd.nextInt(70),y+rd.nextInt(70));
            TimeUnit.SECONDS.sleep(4);
            robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robot.delay(rd.nextInt(2000));
            robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("完成一轮");

//
        }
    }
}
