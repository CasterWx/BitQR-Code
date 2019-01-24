package bitmaps;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-24-18:13
 */
public class GifReload {

    public static void main(String[] args) {
        GifRunBackward("gif\\1.gif","gif\\1-get.gif");
        GifRunBackward("gif\\2.gif","gif\\2-get.gif");
        GifRunBackward("gif\\3.gif","gif\\3-get.gif");
    }

    // GIF倒放
    public static void GifRunBackward(String inputFileName,String outFileName) {
        try{
            GifDecoder gd = new GifDecoder();
            //要处理的图片
            int status = gd.read(new FileInputStream(new File(inputFileName)));
            if (status != GifDecoder.STATUS_OK) {
                return;
            }
            AnimatedGifEncoder ge = new AnimatedGifEncoder();

            //这里是关键，设置要替换成透明的颜色
            ge.setTransparent(Color.WHITE);
            //
            ge.start(new FileOutputStream(new File(outFileName)));
            ge.setRepeat(0);

            for (int i = gd.getFrameCount()-1; i >=0 ; i--) {
                //取得gif的每一帧
                BufferedImage frame = gd.getFrame(i);

                Graphics2D gs = frame.createGraphics() ;
                gs.drawImage(frame,0,0,frame.getWidth(),frame.getHeight(),null);
                //File imagefile = new File("P"+i+".png");
                //ImageIO.write(frame,"png",imagefile);
                //你可以对每一帧做点什么，比如缩放什么的，这里就什么都不做了
                int delay = gd.getDelay(i);
                ge.setDelay(delay);
                ge.addFrame(frame);

            }
            //输出图片
            ge.finish();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
