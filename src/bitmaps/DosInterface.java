package bitmaps;

import com.swetake.util.Qrcode;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class DosInterface {
    public static void main(String []agrs)throws Exception{
        QroceImg("https://github.com/CasterWx","out.png");
    }
    public static void QroceImg(String content,String imgPath) throws IOException {
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');
        qrcode.setQrcodeEncodeMode('B');
        qrcode.setQrcodeVersion(7);
        BufferedImage writeImg = ImageIO.read(new File("1.jpg"));
        BufferedImage bf = new BufferedImage(writeImg.getWidth(),writeImg.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D gs = bf.createGraphics() ;
        gs.setBackground(Color.white);
        gs.clearRect(0,0,bf.getWidth(),bf.getHeight());
        gs.drawImage(writeImg,0,0,bf.getWidth(),bf.getHeight(),null);
        gs.setColor(Color.black);

        byte []contentByte = content.getBytes("utf-8");
        boolean [][]cidesOut = qrcode.calQrcode(contentByte) ;
        int mini = bf.getHeight()/cidesOut.length ;
        int begin = (bf.getHeight() - mini*cidesOut.length )/2;
        for(int i=0;i<cidesOut.length;i++){
            for(int j=0;j<cidesOut.length;j++){
                if(cidesOut[j][i]){
                    gs.fillRect(j*mini+begin,i*mini+begin,mini,mini );
                }
            }
        }
        File imagefile = new File(imgPath);
        ImageIO.write(bf,"png",imagefile);
    }
}
