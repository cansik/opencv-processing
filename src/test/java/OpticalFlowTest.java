import gab.opencv.OpenCV;
import processing.core.PApplet;
import processing.core.PImage;

public class OpticalFlowTest extends PApplet {

    public static void main(String... args) {
        OpticalFlowTest sketch = new OpticalFlowTest();
        sketch.runSketch();
    }

    public void settings() {
        size(640, 480);
    }

    PImage testImage;
    OpenCV opencv;

    public void setup() {
        testImage = loadImage(sketchPath("data/robot_light.jpg"));
        opencv = new OpenCV(this, testImage.width, testImage.height);
    }

    public void draw() {
        opencv.loadImage(testImage);
        opencv.calculateOpticalFlow();
        println("Optical Flow was running");
    }
}