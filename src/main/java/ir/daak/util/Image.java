package ir.daak.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;

public class Image {
    public static BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height){
        BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
        return croppedImage;
    }

    public static BufferedImage resize(BufferedImage img, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, java.awt.Image.SCALE_SMOOTH);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }

    public static BufferedImage toBufferedImage(char[] image, int width, int height) {
        BufferedImage hImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        DataBuffer db1 = hImage.getRaster().getDataBuffer();

        for( int i = 0; i < db1.getSize(); i++ )
        {
            db1.setElem( i, image[i] );
        }

        return hImage;
    }
}
