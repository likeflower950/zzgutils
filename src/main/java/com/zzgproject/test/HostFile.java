package com.zzgproject.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HostFile {
	private static List<String> list127 = new ArrayList<>();
	private static List<String> list136 = new ArrayList<>();
	private static List<String> list137 = new ArrayList<>();
	private static List<String> list138 = new ArrayList<>();
	private static List<String> listgw = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		File file = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");
//		File file = new File("E:\\111.txt");
		HostFile hf = new HostFile();
		hf.writeHosts(file, list127);
//		hf.writeHosts(file, list137);
//		hf.writeHosts(file, list136);
//		hf.writeHosts(file, list138);
//		hf.writeHosts(file, listgw);
		hf.readHosts(file);
	}
	
	static {
		list127.add("127.0.0.1 	localhost");
		list127.add("127.0.0.1 	htzs.jiyoutang.com");
		list127.add("127.0.0.1 	js.jiyoutang.com");
		list127.add("127.0.0.1 	css.jiyoutang.com");
		list127.add("127.0.0.1 	img.jiyoutang.com");
//		list127.add("127.0.0.1 	v1.jiyoutang.com");
		list127.add("127.0.0.1 	crm.jiyoutang.com");
		list127.add("127.0.0.1 	up.jiyoutang.com");
		list127.add("127.0.0.1 	teach.jiyoutang.com");
		list127.add("127.0.0.1 	www.daydays.com");
		list127.add("127.0.0.1 	wzht.daydays.com");
		list127.add("127.0.0.1 	www.zzg.com");
		list127.add("172.16.32.2 	app.daydays.com");
		list127.add("172.16.32.2 	htgl.jiyoutang.com");
		list127.add("172.16.32.2 	mingshiruzhu.daydays.com");
		list127.add("172.16.32.2 	yiyuandinggou.daydays.com");
		list127.add("172.16.32.2 	tiantiansaoti.daydays.com");
		
		
		
		list136.add("127.0.0.1 	localhost");
		list136.add("192.168.1.136 	htzs.jiyoutang.com");
		list136.add("192.168.1.136 	js.jiyoutang.com");
		list136.add("192.168.1.136 	css.jiyoutang.com");
		list136.add("192.168.1.136 	img.jiyoutang.com");
//		list136.add("192.168.1.136 	v1.jiyoutang.com");
		list136.add("192.168.1.136 	crm.jiyoutang.com");
		list136.add("192.168.1.136 	up.jiyoutang.com");
		list136.add("192.168.1.136 	teach.jiyoutang.com");
		list136.add("192.168.1.136 	www.daydays.com");
		list136.add("192.168.1.136 	wzht.daydays.com");
		
		
		list137.add("127.0.0.1 	localhost");
		list137.add("172.16.32.2 	htzs.jiyoutang.com");
		list137.add("172.16.32.2 	js.jiyoutang.com");
		list137.add("172.16.32.2 	css.jiyoutang.com");
		list137.add("172.16.32.2 	img.jiyoutang.com");
//		list137.add("172.16.32.2 	v1.jiyoutang.com");
		list137.add("172.16.32.2 	crm.jiyoutang.com");
		list137.add("172.16.32.2 	up.jiyoutang.com");
		list137.add("172.16.32.2 	teach.jiyoutang.com");
		list137.add("172.16.32.2 	www.daydays.com");
		list137.add("172.16.32.2 	wzht.daydays.com");
		list137.add("172.16.32.2 	app.daydays.com");
		list137.add("172.16.32.2 	htgl.jiyoutang.com");
		list137.add("172.16.32.2 	mingshiruzhu.daydays.com");
		list137.add("172.16.32.2 	yiyuandinggou.daydays.com");
		list137.add("172.16.32.2 	tiantiansaoti.daydays.com");
		
		
		
		list138.add("127.0.0.1 	localhost");
		list138.add("192.168.1.138 	htzs.jiyoutang.com");
		list138.add("192.168.1.138 	js.jiyoutang.com");
		list138.add("192.168.1.138 	css.jiyoutang.com");
		list138.add("192.168.1.138 	img.jiyoutang.com");
//		list138.add("192.168.1.138 	v1.jiyoutang.com");
		list138.add("192.168.1.138 	crm.jiyoutang.com");
		list138.add("192.168.1.138 	up.jiyoutang.com");
		list138.add("192.168.1.138 	www.daydays.com");
		list138.add("192.168.1.138 	wzht.daydays.com");
		list138.add("192.168.1.138 	teach.jiyoutang.com");

		
		listgw.add("127.0.0.1 	localhost");
	}
	
	public void writeHosts(File file, List<String> list) throws Exception{
		FileWriter fw = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fw);
		for(String str : list){
			writer.write(str);
			writer.newLine();
		}
		writer.flush();
		writer.close();
	}
	
	public void readHosts(File file) throws Exception{
		InputStream is = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		String str = br.readLine();
		while(str!=null && str!=""){
			System.out.println(str);
			str = br.readLine();
		}
		br.close();
		reader.close();
	}
	
}
