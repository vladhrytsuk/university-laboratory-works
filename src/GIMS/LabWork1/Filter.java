package GIMS.LabWork1;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Filter {

    public static int inputNoiseLevel() throws IOException {
        System.out.println("Введите уровень зашумления (0-100): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    public static int inputThreshold() throws IOException {
        System.out.println("Введите пороговое значение: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    public static void main(String[] args) throws IOException {

        Image image = new Image();

        BufferedImage sourceImage = image.loadImage("D:\\panda.bmp");

        BufferedImage sourceImage1 = image.loadImage("D:\\panda.bmp");
        image.addNoiseToImage(sourceImage1, inputNoiseLevel());
        image.saveImage(sourceImage1, "D:\\panda_noise.bmp");

        /*for (int i = 1; i <= 50; ++i) {
            BufferedImage noiseImage = image.loadImage("D:\\bear_noise.bmp");
            image.filteringImage(sourceImage, noiseImage, i);
            image.saveImage(noiseImage, "D:\\bear_filter.bmp");
            System.out.println("Modify pixel (iteration " + i + ") - " + image.getCount());
            image.setCount();
        }*/

        BufferedImage noiseImage = image.loadImage("D:\\panda_noise.bmp");
        image.filteringImage(sourceImage, noiseImage, inputThreshold());
        image.saveImage(noiseImage, "D:\\panda_filter.bmp");
        image.setCount();
    }
}
