package com.zzgproject.commitfile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrzxCommitFiles {
	
	static Set<String> result ;
	static List<String> fileName ;
	static{
		result = new HashSet<>();
		fileName = new ArrayList<>();
		fileName.add("CollectDAOJDBC.java");
		fileName.add("CollectController.java");
		
	}
	
	public static void main(String[] args){
		GrzxCommitFiles cf = new GrzxCommitFiles();
		File file = new File("E:\\firstResource\\workspace\\ht_grzx");
		cf.getClassFiles(file);
		file = new File("E:\\workspace\\resources\\WebContent");
		cf.getClassFiles(file);
		for(String str : result){
			System.out.println(str);
		}
	}
	
	public List<String> getClassFiles(File file){
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
						str = str.replace("E:/firstResource/workspace/ht_grzx/src/", "/app/grzx/WEB-INF/classes/");
						str = str.replace(".java", ".class");
						result.add(str);
					} else if(str.contains(s) && s!=""){
						str = str.replace("E:/workspace/resources/WebContent/", "/www/");
						result.add(str);
					} 
				}
			}
		}
		return null;
	}
}
