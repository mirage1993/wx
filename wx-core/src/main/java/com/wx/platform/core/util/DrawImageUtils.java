package com.wx.platform.core.util;

import com.sun.media.jai.codec.ImageDecodeParam;
import com.sun.media.jai.codec.ImageEncodeParam;
import com.sun.media.jai.codec.PNGDecodeParam;
import com.sun.media.jai.codec.PNGEncodeParam;
import com.sun.media.jai.codecimpl.PNGCodec;
import com.sun.media.jai.codecimpl.PNGImageEncoder;
import sun.awt.image.PNGImageDecoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class DrawImageUtils {

    public static void main(String[] args) throws IOException {
        String bkimage = "C:\\opts\\hybris6.6\\hybris\\bin\\custom\\samsonite\\samsonitestorefront\\web\\webroot\\_ui\\desktop\\samsonite\\build\\images\\custom-made-product.png";
//        InputStream is = null;
//        try {
//            is = new FileInputStream(bkimage);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        ImageDecodeParam imageDecodeParam = new PNGDecodeParam();
//        PNGImageDecoder imageDecoder = (PNGImageDecoder) PNGCodec.createImageDecoder("product.png", is, imageDecodeParam);
//        int width = 358;
//        int height = 217;
        BufferedImage image = ImageIO.read(new File(bkimage));
        Graphics graphics = image.getGraphics();
        String icon = "C:\\opts\\hybris6.6\\hybris\\bin\\custom\\samsonite\\samsonitestorefront\\web\\webroot\\_ui\\shared\\images\\letter\\P.png";
        ImageIcon imageIcon = new ImageIcon(icon);
        Image img = imageIcon.getImage();
        graphics.drawImage(img, (180 + 45), 88, 50, 50, null);
        graphics.dispose();
        try {

            ImageIO.write(image, "PNG", new File("D:/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}
