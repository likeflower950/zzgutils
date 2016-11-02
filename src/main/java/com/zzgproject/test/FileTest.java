package com.zzgproject.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;


public class FileTest {
	public static void main(String[] args){
		FileTest test = new FileTest();
		File s = new File("D:\\abc333333.txt");
		File t1 = new File("/web/a/123.txt");
//		File t2 = new File("D:\\Documents\\Pictures\\20141115CS_2.rar");
//		test.deleteFile(s);
//		long start = System.currentTimeMillis();
		test.copyFile(s, t1);
//		long end = System.currentTimeMillis();
//		System.out.println("copyFile���ƣ���ʱ" + (end - start));
//		
//		start = System.currentTimeMillis();
//		test.copyChannel(s, t2);
//		end = System.currentTimeMillis();
//		System.out.println("copyChannel���ƣ���ʱ" + (end - start));
		
		File ff = new File("/web/a/b/c/d");
		System.out.println(ff.exists());
		ff.mkdirs();
		
	}
	
	public void deleteFile(File f){
		f.deleteOnExit();
	}
	
	public void copyChannel(File s, File t){
		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();//�õ���Ӧ���ļ�ͨ��
            out = fo.getChannel();//�õ���Ӧ���ļ�ͨ��
            in.transferTo(0, in.size(), out);//��������ͨ�������Ҵ�inͨ����ȡ��Ȼ��д��outͨ��
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
	}
	
	public void copyFile(File s, File t){
		InputStream in = null;
		OutputStream out = null;
		try{
			in = new BufferedInputStream(new FileInputStream(s));
			out = new BufferedOutputStream(new FileOutputStream(t));
			byte[] b = new byte[2048];
			int len = in.read(b);
			while(len > 0){
				out.write(b, 0, len);
				len = in.read(b);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				in.close();
				out.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
