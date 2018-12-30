package bitmaps;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2018-12-30-22:23
 */
public class PngToGif {
    public static void main(String[] args) {
        String[] pic = {"img\\1.jpg","img\\out.png","img\\out1.png"};
        String newwPic = "img\\1.gif";
        int playTime = 200;
        jpgToGif(pic,newwPic,playTime);
    }
    private synchronized static void jpgToGif(String pic[], String newPic, int playTime) {
        try {
            AnimatedGifEncoder e = new AnimatedGifEncoder();
            e.setRepeat(0);
            e.start(newPic);
            BufferedImage src[] = new BufferedImage[pic.length];
            for (int i = 0; i < src.length; i++) {
                e.setDelay(playTime); //设置播放的延迟时间
                src[i] = ImageIO.read(new File(pic[i])); // 读入需要播放的jpg文件
                e.addFrame(src[i]);  //添加到帧中
            }
            e.finish();
        } catch (Exception e) {
            System.out.println( "jpgToGif Failed:");
            e.printStackTrace();
        }
    }
}
