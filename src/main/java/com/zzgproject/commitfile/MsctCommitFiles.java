package com.zzgproject.commitfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MsctCommitFiles {
	
	static List<String> result ;
	static List<String> fileName ;
	static{
		result = new ArrayList<>();
		fileName = new ArrayList<>();
		
		//名师辅导——新版
		fileName.add("");
	}
	
	public static void main(String[] args){
		MsctCommitFiles cf = new MsctCommitFiles();
		
		File file = new File("D:\\workspace\\ht_msct");
		cf.getClassFiles(file);

		file = new File("D:\\workspace\\resources\\WebContent\\html\\msct");
		cf.getClassFiles(file);

		file = new File("D:\\workspace\\resources\\WebContent\\js");
		cf.getClassFiles(file);

		file = new File("D:\\workspace\\resources\\WebContent\\css");
		cf.getClassFiles(file);

		file = new File("D:\\workspace\\resources\\WebContent\\image");
		cf.getClassFiles(file);
		file = new File("D:\\workspace\\resources\\WebContent\\images");
		cf.getClassFiles(file);
		
		for(String str : result){
			System.out.println(str);
		}
		System.out.println("应该找到文件数："+fileName.size());
		System.out.println("实际找到文件数："+result.size());
	}
	
	private List<String> getClassFiles(File file){
		File[] fs = file.listFiles();
		for(File f : fs){
			if(f.isDirectory()){
				this.getClassFiles(f);
			} else {
				String str = f.getPath();
				if(str.contains("$")) continue;
				str = str.replace("\\", "/");
				for(String s : fileName){
					if(str.contains(s) && s.endsWith(".java")){
						str = str.replace("D:/workspace/ht_msct/src/", "/app/msct/WEB-INF/classes/");
						str = str.replace(".java", ".class");
						result.add(str);
					} else if(str.contains(s) && s!=""){
						str = str.replace("D:/workspace/resources/WebContent/", "/www/");
						result.add(str);
					} 
				}
			}
		}
		return null;
	}
}
