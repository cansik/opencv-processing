import processing.core.PApplet;
import processing.core.PImage;

import gab.opencv.*;
import org.opencv.core.*;

public class AlphaChannelTest extends PApplet {

    public static void main(String... args) {
        AlphaChannelTest sketch = new AlphaChannelTest();
        sketch.runSketch();
    }

    public void settings() {
        size(800, 300);
    }

    OpenCV opencv;

    PImage input, output;

    public void setup() {
        opencv = new OpenCV(this, 0, 0);
        input = createImage(400, 300, ARGB);

        // fill red
        for (int y = 0; y < input.height; y++) {
            for (int x = 0; x < input.width; x++) {
                input.set(x, y, color(255, 0, 0));
            }
        }

        input = loadImage("https://github.com/pjreddie/darknet/raw/master/data/dog.jpg");
        input.resize(400, 300);

        Mat mat = new Mat(input.height, input.width, CvType.CV_8UC4);
        OpenCV.toCv(input, mat);

        output = createImage(input.width, input.height, RGB);
        opencv.toPImage(mat, output);

        println("first pixel of input:  " + binary(input.pixels[0]));
        println("first pixel of mat:");
        println(mat.get(0, 0));
        println("first pixel of output :" + binary(output.pixels[0]));
    }

    public void draw() {
        image(input, 0, 0);
        image(output, input.width, 0);
    }
}