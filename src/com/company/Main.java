package com.company;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws WriterException, IOException {
	// write your code here
        final String text=args.length>0?args[0]:"Shiva";
        final int size=args.length>1?Integer.parseInt(args[1]):100;
        final BitMatrix result=new MultiFormatWriter().encode(text,BarcodeFormat.QR_CODE,size,size,null);
        final BufferedImage image= MatrixToImageWriter.toBufferedImage(result);
        final File outputfile=new File(text+".jpg");
        ImageIO.write(image,"jpg",outputfile);
    }
}
