package com.another.tools;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class ImageUtils {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());

        Mat mat2 = Imgcodecs.imread("D:/pack.png");

        HighGui.imshow("lc",mat2);
        HighGui.waitKey(0);
    }
}
