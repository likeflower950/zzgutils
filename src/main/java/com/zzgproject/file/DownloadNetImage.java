package com.zzgproject.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadNetImage {
	
	/**
	 * @author 张志刚     2015-12-31 下午2:35:47 
	 * @param args
	 * @throws Exception
	 * 将URL内的东西下载保存到本地指定地址，可以是html，可以是图片
	 */
	public static void main(String[] args) throws Exception {  
//		download("http://pic1.mofang.com/2015/1231/20151231010759566.png", "20151231010759566.png","D:\\image\\");
//		download("http://www.mofang.com/gonglue_www/1019-587247-1.html", "1234.html","D:\\image\\");
		download("http://game.mofang.com/download/48292-0.html", "12345.html","D:\\image\\");
    } 
	
	public static void download(String urlString, String filename,String savePath) throws Exception {
		URL url = new URL(urlString);
		URLConnection con = url.openConnection();
		con.setConnectTimeout(5*1000);
		InputStream is = con.getInputStream();
		File sf = new File(savePath);
		OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
		byte[] bs = new byte[1024];
		int len;
		if(!sf.exists()){
			sf.mkdirs();
		}
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		os.close();  
		is.close();  
	}
}
