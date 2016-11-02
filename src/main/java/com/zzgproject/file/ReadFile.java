package com.zzgproject.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	public static void main(String[] args) throws Exception{
//		File file = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");
		File file = new File("D:\\tt\\member_10000_100000.txt");
		ReadFile rf = new ReadFile();
//		rf.readHosts(file);
		rf.readFile(file);
	}
	
	public void readHosts(File file) throws Exception{
		InputStream is = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		String str = br.readLine();
		int i = 0;
		while(str!=null && str!=""){
			System.out.println(str);
			str = br.readLine();
			i++;
		}
		System.out.println("总共行数：" + i);
		br.close();
		reader.close();
	}
	
	
	public List<String> readFile(File file) throws Exception{
		return this.readFile(file, "GBK");
	}
	
	public List<String> readFile(File file, String encode) throws Exception{
		List<String> list = new ArrayList<>();
		InputStream is = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(is, encode);
		BufferedReader br = new BufferedReader(reader);
		String str = br.readLine();
		while(str!=null && str!=""){
			list.add(str);
			str = br.readLine();
		}
		br.close();
		reader.close();
		return list;
	}

	
	public List<String> readFile(String path) throws Exception{
		File file = new File(path);
		return this.readFile(file);
	}
	
	public List<String> readFile(String path, String encode) throws Exception{
		File file = new File(path);
		return this.readFile(file, encode);
	}

	
}
