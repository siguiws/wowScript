import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.net.URL;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import static org.opencv.imgproc.Imgproc.COLOR_RGB2GRAY;
import static org.opencv.imgproc.Imgproc.cvtColor;

public class oneTest {
    public static void main(String[] args) throws Exception {
        // 解决awt报错问题
        System.setProperty("java.awt.headless", "false");
        System.out.println(System.getProperty("java.library.path"));
        // 加载动态库
        URL url = ClassLoader.getSystemResource("lib/opencv/opencv_java460.dll");
        System.load(url.getPath());
        // 读取图像

        Mat image = imread("D:\\SoreceCode\\wowScript\\java_code\\wow_opencv\\src\\main\\resources\\head.jpg");
        if (image.empty()) {
            throw new Exception("image is empty");
        }
//        imshow("Original Image", image);

        // 创建输出单通道图像
        Mat grayImage = new Mat(image.rows(), image.cols(), CvType.CV_8SC1);
        // 进行图像色彩空间转换
        cvtColor(image, grayImage, COLOR_RGB2GRAY);

//        imshow("Processed Image", grayImage);
        imwrite("D:\\SoreceCode\\wowScript\\java_code\\wow_opencv\\src\\main\\resources\\head2.jpg", grayImage);
//        waitKey();

//
//
//        Mat faceImag = imread("D:\\SoreceCode\\wowScript\\java_code\\wow_opencv\\src\\main\\resources\\head.jpg");
//        // 人脸识别器
//        CascadeClassifier faceDetector = new CascadeClassifier("D:\\OpenCV\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
//        // 在图片中检测人脸
//        MatOfRect faceDetections = new MatOfRect();
//        faceDetector.detectMultiScale(faceImag,faceDetections);
//        Rect[] rects = faceDetections.toArray();
//        if(rects != null && rects.length >= 1){
//            for (Rect rect : rects) {
//
//                Imgproc.rectangle(faceImag,rect, Scalar.all(1));
//            }
//        }
//        imshow("人脸检测图片",faceImag);
//        waitKey();
    }
}
