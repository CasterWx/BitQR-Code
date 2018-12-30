package bitmaps;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2018-12-30-22:39
 */
public class GifToPng {
    public static void main(String[] args) {
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');
        qrcode.setQrcodeEncodeMode('B');
        qrcode.setQrcodeVersion(3);
        long startTime=System.currentTimeMillis();
        try{
            GifDecoder gd = new GifDecoder();
            //要处理的图片
            int status = gd.read(new FileInputStream(new File("img\\gif3.gif")));
            if (status != GifDecoder.STATUS_OK) {
                return;
            }
            AnimatedGifEncoder ge = new AnimatedGifEncoder();

            //这里是关键，设置要替换成透明的颜色
            ge.setTransparent(Color.WHITE);
            //
            ge.start(new FileOutputStream(new File("img\\gif3-get.gif")));
            ge.setRepeat(0);
            String content = "https://github.com/CasterWx" ;
            byte []contentByte = content.getBytes("utf-8");
            boolean [][]cidesOut = qrcode.calQrcode(contentByte) ;

            for (int i = 0; i < gd.getFrameCount(); i++) {
                //取得gif的每一帧
                BufferedImage frame = gd.getFrame(i);

                Graphics2D gs = frame.createGraphics() ;
                gs.drawImage(frame,0,0,frame.getWidth(),frame.getHeight(),null);

                int qrLength = frame.getHeight()-2*frame.getHeight()/10 ;
                int mini = qrLength/cidesOut.length ;
                int xbegin = (frame.getWidth() - mini*cidesOut.length)/2 ;
                int ybegin = (frame.getHeight() - mini*cidesOut.length)/2 ;
                for(int k=0;k<cidesOut.length;k++){
                    for(int j=0;j<cidesOut.length;j++){
                        if(cidesOut[j][k]){
                            gs.setColor(Color.BLACK);
                            gs.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,1.0f));
                            gs.fillRect(j*mini+xbegin,k*mini+ybegin,mini,mini );
                        }
                    }
                }
                //File imagefile = new File("P"+i+".png");
                //ImageIO.write(frame,"png",imagefile);
                //你可以对每一帧做点什么，比如缩放什么的，这里就什么都不做了
                int delay = gd.getDelay(i);
                ge.setDelay(delay);
                ge.addFrame(frame);

            }
            //输出图片
            ge.finish();

            System.out.println(System.currentTimeMillis()-startTime);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
