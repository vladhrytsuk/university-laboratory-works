package GIMS.LabWork1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Image {

    private int width; //ширина изображения
    private int height; //высота изображения

    private int count;

    /*Загрузка изображения*/
    public BufferedImage loadImage(String fileName) throws IOException
    {
        BufferedImage image = null;
        /*Пробуем загрузить изображение*/
        try {
            image = ImageIO.read(new File(fileName)); //загружаем изображение
            width = image.getWidth(); // записываем ширину изображения
            height = image.getHeight(); // записываем высоту изображения
        }
        /*Если не получается загрузить изображение, выпадает исключение*/
        catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /*Сохраняем наше изображение*/
    public void saveImage(BufferedImage image, String newFileName) throws IOException
    {
        /*Пробуем сохранить файл*/
        try {
            File outputFile = new File(newFileName); //Указываем путь сохранния файла
            ImageIO.write(image, "bmp", outputFile); //Сохраняем наше изображение, в формате bmp
        }
        /*Если не получается сохранить изображение, выпадает исключение*/
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Добавляем шум в наше изображение*/
    public void addNoiseToImage(BufferedImage image, int noiseLevel)
    {
        Random random = new Random(); //Создаём объект для того что создавать рандомные числа
        /*Получаем количество пикселей которые надо зашумить,
         по формуле ширину * высоту * уровень зашумления / 100
          */
        int pointCount = (width * height * noiseLevel) / 100;

        /*Проходим по циклу от 0 до количества пискселей которые надо зашумить*/
        for (int i = 0; i < pointCount; ++i) {
            /*Получаем рандомный цвет, random.nextInt(256) указывает на то получим рандомное значение от 0 до 255*/
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); //RGB
            int x = random.nextInt(width + 1) % width; // получаем координаты x нашего пикселя
            int y = random.nextInt(height + 1) % height; // получаем координаты y нашего пикселя
            image.setRGB(x, y, color.getRGB()); // устанавливаем новый цвет, для нашего пикселя, по координатам x и y
        }
    }

    /*Функция определяет надо ли нам заменять цвет нашего пикселя на среднее значение 8 пикелей вокруг него или нет*/
    public Color calcucateColor(int e, Color currentPixelColor, Color[] color)
    {
        int red = 0, green = 0, blue = 0;
        for (int i = 0; i < color.length; ++i) {
            red += color[i].getRed(); // сумма красного спектра для 8 пикселей
            green += color[i].getGreen(); // сумма зеленого спектра для 8 пикселей
            blue += color[i].getBlue(); // сумма синего спектра для 8 пикселей
        }
        /*Проверяем следующее условие, если по модулю красный спектр нашего
        * текущего пикселя - среднего значение красного спектра 8 пикселей больше прогового значения,
        * или если по модулю зеленый спектр нашего
        * текущего пикселя - среднего значение зеленогд спектра 8 пикселей больше прогового значения,
        * или если по модулю синий спектр нашего
        * текущего пикселя - среднего значение синиго спектра 8 пикселей больше прогового значения, то
        * мы заменяем цвет нашего пикселя на цвет среднего значения 8 пикселей*/
        if (Math.abs(currentPixelColor.getRed() - red / 8) > e || Math.abs(currentPixelColor.getGreen() - green / 8) > e ||
                Math.abs(currentPixelColor.getBlue() - blue / 8) > e) {
            count++;
            return new Color(red / 8, green / 8, blue / 8);
        }
        return currentPixelColor;
    }

    //копируем пиксели по краям исходного изображения в отфильтрованное изображение
    public void setColorOnTheEdges(BufferedImage image, BufferedImage noiseImage)
    {
        for (int i = 0; i < height; ++i) {
            if (i == 0 || i == height - 1) {
                for (int j = 0; j < width; ++j) {
                    noiseImage.setRGB(j, i, image.getRGB(j, i));
                }
            }
            else {
                noiseImage.setRGB(0, i, image.getRGB(0, i));
                noiseImage.setRGB(width - 1, i, image.getRGB(width - 1, i));
            }
        }
    }

    //e - пороговое значение
    public void filteringImage(BufferedImage image, BufferedImage noiseImage, int e)
    {
        /*Вызываем функцию для копирования пикселей по краям исходного изображения в отфильтрованное изображение*/
       setColorOnTheEdges(image, noiseImage);
        /*Проходим по ширине и высоте нашего изображения*/
       for (int i = 1; i < width - 1; ++i) {
            for (int j = 1; j < height - 1; ++j) {
                /*Получаем цвет всех 8 пикселей вокруг пикселя с которым мы работаем*/
                int color1 = noiseImage.getRGB(i - 1, j - 1);
                int color2 = noiseImage.getRGB(i - 1, j);
                int color3 = noiseImage.getRGB(i - 1, j + 1);
                int color4 = noiseImage.getRGB(i, j + 1);
                int color5 = noiseImage.getRGB(i + 1, j + 1);
                int color6 = noiseImage.getRGB(i + 1, j);
                int color7 = noiseImage.getRGB(i + 1, j - 1);
                int color8 = noiseImage.getRGB(i, j - 1);
                /*получаем наш текущий пикслей*/
                int x = noiseImage.getRGB(i, j);
                /*Устанавливаем новый цвет пикселя по координатам i и j, на основе нашего метода, передав в нашу функцию
                *calcucateColor цвет текущего пикселя и все цвета пикселей вокруг него*/
                noiseImage.setRGB(i, j, this.calcucateColor(e, new Color(x), new Color[]
                        {new Color(color1), new Color(color2), new Color(color3),
                         new Color(color4), new Color(color5), new Color(color6),
                         new Color(color7), new Color(color8)}).getRGB());
            }
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        count = 0;
    }
}
