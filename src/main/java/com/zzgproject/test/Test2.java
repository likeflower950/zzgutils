package com.zzgproject.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
	
	public static void main(String[] args) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long sd = sdf.parse("2015-11-12").getTime();
		long ed = sdf.parse("2015-11-12").getTime();
		System.out.println(sd);
		System.out.println(ed);
		System.out.println(sd > ed);
		
		
		File file = new File("D:\\mm\\mmmjing.txt");
		System.out.println(file.exists());
		System.out.println(file.getParent());
		System.out.println(new File(file.getParent()).exists());
		System.out.println( new File(file.getParent()).mkdirs() );
		
		String url = "http://tu.joy3g.com/newpic/1.jpg";
		String[] arr = url.split("/.");
		System.out.println(arr[arr.length-1]);
		System.out.println(arr[arr.length-1].startsWith("."));
		System.out.println(url.split("/."));
		System.out.println(url.split("/.").length);
	}
	
	
}
