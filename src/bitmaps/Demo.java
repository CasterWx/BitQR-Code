//package 扩展.二维码;
//
//import com.swetake.util.Qrcode;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import javax.xml.soap.Text;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.image.BufferedImage;
//import java.io.*;
//
//public class Demo {
//    public static void main(String []agrs)throws Exception{
//        final Frame frame = new Frame("二维码生成器");
//        frame.setLayout(new FlowLayout());
//        frame.setBounds(200,200,500,300);
//        final TextArea a = new TextArea();
//        a.setBounds(100,40,370,140);
//        frame.add(a);
//        Button b = new Button("Get");
//        b.setBounds(100,240,160,80);
//        frame.add(b);
//        frame.setResizable(false);
//        frame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//        b.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String t = a.getText();
//                try {
//                    QroceImg(t,"D:\\xx.png");
//                    Frame newframe = new Frame();
//                    newframe.setLayout(new FlowLayout());
//                    newframe.setBounds(300,300,220,220);
//                    JLabel background = new JLabel(new ImageIcon("D:\\xx.png"));
//                    newframe.setVisible(true);
//                    newframe.setResizable(false);
//                    background.setBounds(0,0,200,200);
//                    newframe.addWindowListener(new WindowAdapter() {
//                        public void windowClosing(WindowEvent e) {
//                            System.exit(-1);
//                        }
//                    });
//                    newframe.add(background);
//                    newframe.setVisible(true);
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });
//        frame.setVisible(true);
//    }
//    public static void QroceImg(String content,String imgPath) throws Exception {
//        Qrcode qrcode = new Qrcode();
//        // 容错空间
//        qrcode.setQrcodeErrorCorrect('M');
//        // 编码
//        qrcode.setQrcodeEncodeMode('B');
//        // 版本
//        qrcode.setQrcodeVersion(7);
//        // 绘制
//        BufferedImage bf = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
//        // 绘制工具
//        Graphics2D gs = bf.createGraphics() ;
//        // 设置背景色
//        gs.setBackground(Color.white);
//        // 设置绘制区域
//        gs.clearRect(0,0,200,200);
//        // 设置画笔颜色
//        gs.setColor(Color.black);
//
//        // 正式绘制
//        byte []contentByte = content.getBytes("utf-8");
//        // 二维数组
//        boolean [][]cidesOut = qrcode.calQrcode(contentByte) ;
//        for(int i=0;i<cidesOut.length;i++){
//            for(int j=0;j<cidesOut.length;j++){
//                if(cidesOut[j][i]){
//                    gs.fillRect(j*3+2,i*3+2,3,3);
//                }
//            }
//        }
//        File imagefile = new File(imgPath);
//        ImageIO.write(bf,"png",imagefile);
//    }
//}
