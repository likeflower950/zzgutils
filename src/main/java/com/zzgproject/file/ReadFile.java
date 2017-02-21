package com.zzgproject.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.zzgproject.utils.StringHelper;

public class ReadFile {
	public static void main(String[] args) throws Exception{
//		File file = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");
		File file = new File("E:\\test.txt");
		ReadFile rf = new ReadFile();
//		rf.readHosts(file);
		List<String> list = rf.readFile(file);
		
		file = new File("E:\\test2.txt");
		List<String> list2 = rf.readFile(file);
		
		Set<String> set = new HashSet<>();
		for(String str : list2){
		    set.add(str);
		}
		
		System.out.println(set.size());
		StringHelper.printList(set);
		
		
		for(int i=0; i<list.size(); i++){
//		    if(StringUtils.isBlank(list.get(i))){
//                System.out.println("贷方"+ "\t" + list2.get(i).trim().replace(",", ""));
//            } else {
//                System.out.println("借方"+ "\t" + list2.get(i).trim().replace(",", ""));
//            }
		}
		
		String[] strArr = null;
		for(String str : list){
		    //科目和科目名称
//		    strArr = str.split(" ");
//		    System.out.println(strArr[0] + "\t" + strArr[1]);
		    
//		    if(StringUtils.isBlank(str)){
//		        System.out.println("贷方");
//		    } else {
//		        System.out.println("借方");
//		    }
		    
		    
		}
		
		
		
		
//		StringHelper.printList(list);
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
		return this.readFile(new File(path));
	}
	
	public List<String> readFile(String path, String encode) throws Exception{
		return this.readFile(new File(path), encode);
	}

	
}
