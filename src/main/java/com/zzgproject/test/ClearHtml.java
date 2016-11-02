package com.zzgproject.test;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClearHtml {
	//过滤特殊字符和html
	public static String clearHtmlToStr(String str){
		 String regEx="[`~!(A-Za-z0-9)@#$%^&*()+-=_|{}':;\"',\\s\\n\\?\\[\\].<>/?~！@#￥%……&*（）——+|{}＿《》【】‘；：”“’。，、？☆]"; 
		 Pattern   p   =   Pattern.compile(regEx);     
	     Matcher   m   =   p.matcher(str); 
	     return m.replaceAll(" ").trim();
	 }
	//获取索引路径
	public static String getRootPath() {
		Map<Object,Object> pathMap = new HashMap<Object,Object>();
		try  
        {  
			String filePath = "xt.properties";
			Properties ps = new Properties();
			InputStream	in =ClearHtml.class.getClassLoader().getResourceAsStream(filePath);
			ps.load(in);
			pathMap = ps;
			File dir = new File(pathMap.get("quesIndex").toString());
			if (!dir.exists()) {
				dir.mkdir();
			}
        }catch(Exception e){   
            e.printStackTrace(); 
            return null;
        } 
		return pathMap.get("quesIndex").toString();
	}
	
	 public static String filterHtml(String str) {  
		 	if(str==null)str="";
		 	String regxpForHtml = "<([^>]*)>|(&nbsp;)|(&nbsp)|(&ldquo;)|(&ldquo)|(&rdquo;)|(&rdquo)|(&quot;)"; // 过滤所有以<开头以>结尾的标签 空格中英文双引号
	        Pattern pattern = Pattern.compile(regxpForHtml);   
	        Matcher matcher = pattern.matcher(str);   
	        StringBuffer sb = new StringBuffer();   
	        boolean result1 = matcher.find();   
	        while (result1) {   
	            matcher.appendReplacement(sb, "");   
	            result1 = matcher.find();   
	        }   
	        matcher.appendTail(sb);   
	        return sb.toString().replace("　", "");   
	    }  
	 public static String clearPunctuation(String str){
		 String regEx="[`~!(A-Za-z0-9)@#$%^&*()+-=_|{}':;\"',\\s\\n\\?\\[\\].<>/?~！@#￥%……&*（）——+|{}＿《》【】‘；：”“’。，、？☆]"; 
		 Pattern   p   =   Pattern.compile(regEx);     
	     Matcher   m   =   p.matcher(str); 
	     return m.replaceAll("").trim();
	 }
	 public static String getChinese(String str){
		 String regEx="[^(\\u4e00-\\u9fa5)|(\\d+)]";
		 Pattern   p   =   Pattern.compile(regEx);     
	     Matcher   m   =   p.matcher(str); 
	     str=str.replaceAll("\\(|\\)", "");
	     while (m.find()) {
	    	str= str.replace(m.group(), "");
		}
	     return str;
	 }
//	 public static String getEnglish(String str){
//		 String regEx="[^(A-Za-zＡ-Ｚ)|(\\u4e00-\\u9fa5)|(\\d+)]";
//		 Pattern   p   =   Pattern.compile(regEx);     
//	     Matcher   m   =   p.matcher(str); 
//	     str=str.replaceAll("\\(|\\)", "");
//	     while (m.find()) {
//		    	str= str.replace(m.group(), "");
//		}
//		return HandlerStringForQueses.toDBC(str);
//	 }
	 public static String getNumber(String str){
		 String regEx="[^(\\d+)]";
		 Pattern   p   =   Pattern.compile(regEx);     
	     Matcher   m   =   p.matcher(str); 
	     str=str.replaceAll("\\(|\\)", "");
	     while (m.find()) {
		    	str= str.replace(m.group(), "");
		}
		return str;
	 }
	 public static String clearBeginTag(String comeStr){
			if(comeStr!=null){
				String targetStr=comeStr;
				Pattern pattern2 = Pattern.compile("^(</p>).*?");
				Matcher matcher2 = pattern2.matcher(targetStr);
				if (matcher2.matches()) {
					targetStr=targetStr.substring(4);
				}
				Pattern pattern = Pattern.compile("^(<p class='retract'>.*?</p>).*?");
				Matcher matcher1 = pattern.matcher(targetStr);
				if (matcher1.matches()) {
			     String newString=matcher1.group(1).replace("<p class='retract'>", "<span class='retract1'>").replace("</p>", "</span>");
			     targetStr=targetStr.replace(matcher1.group(1), newString);
				}
				
				Pattern pattern3 = Pattern.compile(".*?(.*?</p>).*?");
				Matcher matcher3 = pattern3.matcher(targetStr);
				if(matcher3.matches()){
					String tempString=matcher3.group(1);
					if(!tempString.contains("<p class='retract'>")){
						tempString="<span class='retract1'>"+tempString.replace("</p>", "</span>");
						targetStr=targetStr.replace(matcher3.group(1), tempString);
					}
					return targetStr;
				}else{
					return targetStr;
				}
			}else{
				return "";
			}
		}
	 
//	 public static int subStrToHashCode(String str,String subject){
//			int k=30;//截取字符长度 生成hashcode
//			if(!subject.equals("YY")){
//				str=getChinese(filterHtml(str));
//			}else{
//				str=getEnglish(filterHtml(str));
//				k=3*k;
//			}
//			int num=(str.length()-k)<0?0:(str.length()-k);
//			str=str.substring(num);
//			return str.hashCode();
//		}
	 public static void main(String[] args) {
		System.out.println(filterHtml("　“高考出分之后，有些学生表现出难受、焦虑、着急，这时候家长该怎么办?北京宏志中学心理教师孙治英表示，家长要给孩子减压，表示出对孩子的理解与支持，但更重要的是应该用行动帮助孩子缓解心理压力，在交流过程中少些说教，多讲道理，绝不能指责、谩骂。”  案")); 
	}
}
