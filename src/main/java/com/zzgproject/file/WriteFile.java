package com.zzgproject.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
	public static void main(String[] args) throws Exception{
		
		List<String> list = new ArrayList<String>();
		File file = new File("D:\\abc.html");
		WriteFile wr = new WriteFile();
		wr.writeHosts(file, list, false);
	}
	
	public void writeHosts(File file, List<String> list, boolean b){
		try{
			PrintStream p = new PrintStream(new BufferedOutputStream(new FileOutputStream(file, b)));
//			FileWriter fw = new FileWriter(file);
//			BufferedWriter writer = new BufferedWriter(fw);
			for(String str : list){
//				writer.write(str);
//				writer.newLine();
				p.print(str);
				p.println();
			}
			p.flush();
			p.close();
//			writer.flush();
//			writer.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void writeHosts(String filepath , List<String> list, boolean b){
		File file = new File(filepath);
		this.writeHosts(file, list, b);
	}
	
	public void writeHosts(File file, String str, boolean b){
		try{
			PrintStream p = new PrintStream(new BufferedOutputStream(new FileOutputStream(file, b)));
			p.print(str);
			p.println();
			p.flush();
			p.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeHosts(String filepath , String str, boolean b){
			File file = new File(filepath);
			this.writeHosts(file, str, b);
	}

	
}
