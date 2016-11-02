package com.zzgproject.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CreateHtml {
	
	public static void main(String[] args) throws Exception {
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("user", "123123");
		CreateHtml.crateHTML(data, "abc.html", "D:\\123\\abc\\!@#\\123.html");
	}
	

//	public static void crateHTML(ServletContext context,Map<String,Object> data,String templatePath,String targetHtmlPath){ 
//		  Configuration freemarkerCfg = new Configuration(); 
//		  freemarkerCfg.setServletContextForTemplateLoading(context, "/"); 
//		  freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8"); 
//		  try { 
//		   Template template = freemarkerCfg.getTemplate(templatePath,"UTF-8"); 
//		   template.setEncoding("UTF-8"); 
//		   String htmlPath = context.getRealPath("/html")+"/"+targetHtmlPath; 
//		   File htmlFile = new File(htmlPath); 
//            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8")); 
//            template.process(data, out); 
//            out.flush(); 
//            out.close(); 
//		  } catch (Exception e) { 
//		   e.printStackTrace(); 
//		  } 
//		} 
	
	public static void crateHTML(Map<String,Object> data,String templatePath,String targetHtmlPath) throws Exception{
		  Configuration freemarkerCfg = new Configuration(); 
//		  freemarkerCfg.setDirectoryForTemplateLoading(new File("E:/workspace/freemarkerHtml/WebContent"));
		  freemarkerCfg.setDirectoryForTemplateLoading(new File("E:\\"));
		  freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8"); 
		  try { 
			  Template template = freemarkerCfg.getTemplate(templatePath,"UTF-8"); 
			  template.setEncoding("UTF-8"); 
			  String htmlPath = targetHtmlPath; 
			  File htmlFile = new File(htmlPath);
			  System.out.println(htmlFile.getPath());
			  System.out.println(htmlFile.getParent());
			  
			  if(htmlFile.exists()) {
				  System.out.println("存在");
			  } else {
				  System.out.println("不存在");
				  System.out.println(htmlFile.getParentFile()+"========dddd");
				  if(!htmlFile.exists()){
					  htmlFile.getParentFile().mkdirs();
				  }
			  }
			  Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
			  template.process(data, out);
			  out.flush(); 
			  out.close(); 
		  } catch (Exception e) { 
			  e.printStackTrace(); 
		  } 
		} 
	
}
