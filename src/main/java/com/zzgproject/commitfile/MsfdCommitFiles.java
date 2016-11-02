package com.zzgproject.commitfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author zzg 
 * @功能: 选择需要提交的文件，根据指定的格式打印出来，用于发布工程
 *
 */
public class MsfdCommitFiles {
	static List<String> result ;
	static List<String> fileName ;
	static{
		result = new ArrayList<>();
		fileName = new ArrayList<>();
		
		fileName.add("video.html");
		fileName.add("");
		fileName.add("");
	}
	
	public static void main(String[] args){
		MsfdCommitFiles cf = new MsfdCommitFiles();
		
		File file = new File("D:\\workspace\\dd_msfd_web");
		cf.getClassFiles(file);
		
		file = new File("D:\\workspace\\dd_webresources_web\\WebContent");
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
						str = str.replace("D:/workspace/dd_msfd_web/src/", "/app/msfd/WEB-INF/classes/");
						str = str.replace(".java", ".class");
						result.add(str);
					} else if(str.contains(s) && s!=""){
						str = str.replace("D:/workspace/dd_webresources_web/WebContent/", "/webresources/");
						result.add(str);
					} 
				}
			}
		}
		return null;
	}

}
