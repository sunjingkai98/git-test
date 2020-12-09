package com.intouch.util;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ValidatacodeUtil {
    //定义图片的高度和宽度
    private static final int HEIGHT = 80;
    private static final int WIDTH = 200;

    //定义验证码的个数 由五个字符构成
    private static final int NUM = 5;

    //定义验证码的字符源由26个英文单词和数字0-9组成
    private static char[] seq =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                    'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                    'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    //通过Random对象，随机产生一个颜色对象
    private static Color randomColor(Random r) {
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public static String getCode() {
        //创建字符串缓冲区
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < NUM; i++) {//NUM=5;
            //获取一个随机字符
            String ch = String.valueOf(seq[new Random().nextInt(seq.length)]);
            //添加到字符串缓冲区中
            sb.append(ch);
        }
        //将字符串缓冲区转换为字符串返回
        return sb.toString();
    }

    public static void showcodeImage(String code, HttpServletRequest request,
                                     HttpServletResponse response) throws IOException {

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        Random r = new Random();//随机数对象
        //内存图像
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //通过内存图像获取绘图对象
        Graphics g = image.getGraphics();
        //设置颜色
        g.setColor(randomColor(r));
        //画一个实心的矩形
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //遍历验证码字符串
        for (int i = 0; i < code.length(); i++) {
            g.setColor(randomColor(r));
            int h = (int) (HEIGHT * 60 / 100 * r.nextDouble() +
                    (HEIGHT * 30 / 100));
            //设置字体风格样式及大小
            g.setFont(new Font(null, Font.BOLD | Font.ITALIC, h));
            //画出具体字符
            String ch = "" + code.charAt(i);
            g.drawString(ch, i * WIDTH / NUM, h);
        }
        /* ④绘制干扰线 */
        for (int i = 0; i <= 12; i++) {
            g.setColor(randomColor(r));
            g.drawLine(r.nextInt(WIDTH),
                    r.nextInt(HEIGHT),
                    r.nextInt(WIDTH),
                    r.nextInt(HEIGHT));
        }
        //将验证码字符存入session域中，用来校验
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        /* ⑤创建输出流*/
        ServletOutputStream sos = response.getOutputStream();
        //利用ImageIO类，将缓存图像写入输出流中
        ImageIO.write(image, "JPEG", sos);
        System.out.println("code:" + code);
        sos.close();
}
}
