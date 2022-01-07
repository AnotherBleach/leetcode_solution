package com.another.tools;

import javafx.scene.control.ButtonType;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class YYS {
    public static void main(String[] args) throws InterruptedException, AWTException {
        while (true) {
            Point p = MouseInfo.getPointerInfo().getLocation();
            System.out.println(p.getX() + ":" + p.getY());
            TimeUnit.SECONDS.sleep(5);
            Robot robot = new Robot();
            robot.mouseMove((int)(844*1.2), (int)(954*1.2));
            robot.mousePress(InputEvent.BUTTON1_MASK);
            TimeUnit.SECONDS.sleep(5);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            break;
        }
    }
}
