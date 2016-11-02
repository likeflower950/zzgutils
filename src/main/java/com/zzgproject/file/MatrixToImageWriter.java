package com.zzgproject.file;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.awt.image.BufferedImage;

/**
 * @author 张志刚  2015年9月14日 下午4:02:26
 * 生成二维码图片
 */
public final class MatrixToImageWriter {
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	private MatrixToImageWriter() {
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}
	/**
	 * 写文件
	 * @param matrix
	 * @param format
	 * @param file
	 * @throws IOException
	 */
	public static void writeToFile(BitMatrix matrix, String format, File file)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format "
					+ format + " to " + file);
		}
	}

	public static void writeToStream(BitMatrix matrix, String format,
			OutputStream stream)throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format "
					+ format);
		}

	}
	/**
	 * 去白边,四周分别保留4个像素的白边，压缩时保持二维码完整性。
	 * @param matrix
	 * @param edg 边框留多大的白边
	 * @return
	 */
	
	public static BitMatrix deleteWhite(BitMatrix matrix,int edg){
		int[] rec = MatrixToImageWriter.getEnclosingRectangle(matrix,edg);
		int resWidth = rec[2] + edg*2;
		int resHeight = rec[3] + edg*2;
		BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
		resMatrix.clear();
		for (int i = 0; i < resWidth; i++) {
			for (int j = 0; j < resHeight; j++) {
				if (matrix.get(i + rec[0], j + rec[1]))
					resMatrix.set(i, j);
			}
		}
		return resMatrix;
	}
	/**
	 * 计算尺寸
	 * @param matrix
	 * @return
	 */
	public static int[] getEnclosingRectangle(BitMatrix matrix,int edg){
		int[] rec = new int[4];
		rec[0]=matrix.getTopLeftOnBit()[0]-edg;
		rec[1]=matrix.getTopLeftOnBit()[1]-edg;
		rec[2]=matrix.getWidth()-matrix.getTopLeftOnBit()[0]*2;
		rec[3]=matrix.getHeight()-matrix.getTopLeftOnBit()[0]*2;
		return rec;
	}
	/**
	 * @生成二维码图片
	 * @param content 	二维码内容
	 * @param fileName	生成文件的存放地址
	 * @param format	生成二维码图片的后缀
	 * @param width		宽度，按像素
	 * @param height	高度，按像素
	 * @param edg		边框白边大小
	 * @throws Exception
	 */
	public static void createCodeFile(String content,String fileName,String format,int width,int height,int edg) throws Exception {
		String text = content;
		// 二维码的图片格式
		Hashtable<EncodeHintType,Object> hints = new Hashtable<EncodeHintType,Object>();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		//指定纠错级别(L--7%,M--15%,Q--25%,H--30%)
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
				BarcodeFormat.QR_CODE, width, height, hints);
		// 生成二维码
		File outputFile = new File(fileName+"."+format);
		BitMatrix matrix = MatrixToImageWriter.deleteWhite(bitMatrix,edg);
		MatrixToImageWriter.writeToFile(matrix, format, outputFile);
	}
	
}
