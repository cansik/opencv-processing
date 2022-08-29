import gab.opencv.OpenCV;
import processing.core.PApplet;
import processing.core.PImage;

public class GrabImageTest extends PApplet {

    public static void main(String... args) {
        GrabImageTest sketch = new GrabImageTest();
        sketch.runSketch();
    }

    public void settings() {
        size(640, 480);
    }

    PImage testImage;
    OpenCV opencv;

    public void setup() {
        testImage = loadImage(sketchPath("examples/BrightestPoint/robot_light.jpg"));
        opencv = new OpenCV(this, testImage.width, testImage.height);
        noLoop();
    }

    public void draw() {
        opencv.useColor();
        opencv.loadImage(testImage);
        PImage result = opencv.getSnapshot();
        image(result, 0, 0);
    }
}