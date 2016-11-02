package com.zzgproject.watermark;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class MyWaterMark {
	
	public static final String MARK_NAME = "大眼网";
	
	public static final String FONT_NAME = "微软雅黑";
	public static final int FONT_STYLE = Font.BOLD;
	public static final int FONT_SIZE = 120;
	public static final Color FONT_COLOR = Color.RED;
	
	public static final int X = 10;
	public static final int Y = 10;
	
	public static final float ALPHA = 0.5f;
	
	public static void main(String[] args) throws IOException{
		/**
		 * 创建图片缓存对象
		 * 获取图片资源、图片宽度、高度
		 * 整数像素的8位RGB颜色
		 */
		File image = new File("D:\\marry\\image\\800\\a3.jpg");
		Image image2 = ImageIO.read(image);
		int width = image2.getWidth(null);
		int height = image2.getHeight(null);
		System.out.println(width);
		System.out.println(height);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		/**
		 * 创建java绘图工具对象
		 */
		Graphics2D graphics2d = bufferedImage.createGraphics();
		/**
		 * 使用绘图工具将原图绘制到缓存图片对象中
		 * 设置绘图工具的字体信息，将文字写到绘制的图片中
		 * 设置文字样式——字体、大小、颜色、透明度
		 * 设置水印大小
		 */
//		graphics2d.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
		graphics2d.drawImage(image2, 0, 0, width, height, null);
		
		Font font = new Font(MyWaterMark.FONT_NAME,  MyWaterMark.FONT_STYLE,  MyWaterMark.FONT_SIZE);
		graphics2d.setFont(font);
		graphics2d.setColor(MyWaterMark.FONT_COLOR);
		graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, MyWaterMark.ALPHA));
		
		int waterWidth = MyWaterMark.FONT_SIZE * MyWaterMark.MARK_NAME.length();
		int waterHeight = MyWaterMark.FONT_SIZE;
		
		graphics2d.drawString(MARK_NAME, width-360, height-20);
		graphics2d.dispose();
		
		OutputStream out = new FileOutputStream("D:\\marry\\image\\800\\a3_water.jpg");
		JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(out);
		en.encode(bufferedImage);
		
		out.flush();
		out.close();
	}
	
	/**
	 * @param text
	 * @return
	 * 功能：获取文本的长度，中文一个相当于2个字符，英文相当于1个字符
	 */
	public static int getTextLength(String text){
		System.out.println(text.length());
		int len = 0;
		for(int i=0; i<text.length(); i++){
//			char c = text.charAt(i);
//			int m = (int)c;
//			String s = String.valueOf(c);
//			System.out.println(m + "=" + c + "=" + s.getBytes().length);
			String s = String.valueOf(text.charAt(i));
			if(s.getBytes().length > 1){
				len += 2;
			} else {
				len += 1;
			}
		}
		return len;
	}
}
