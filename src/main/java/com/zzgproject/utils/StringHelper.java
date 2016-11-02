package com.zzgproject.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 张志刚	2014-08-05
 * String 工具类
 * 简化其他方法中对string的一些操作
 */
public class StringHelper {
	/**
	 * @author 张志刚	
	 * 功能：判断参数是否合法
	 */
	public static boolean isValid(String param){
		if(null == param) return false;
		if("".equals(param)) return false;
		if("null".equals(param)) return false;
		if("undefined".equals(param)) return false;
		return true;
	}
	
	/**
	 * @author 张志刚	2014-08-05
	 * 功能：判断字符串是否为空
	 */
	public static boolean isEmpty(String str){
		if(null == str) return true;
		if("".equals(str)) return true;
		if("null".equals(str)) return true;
		if("undefined".equals(str)) return true;
		return false;
	}
	
	/**
	 * @author 张志刚	2014-08-05
	 * 功能：判断字符串是否为空
	 */
	public static boolean isNotEmpty(String str){
		if(null == str) return false;
		return StringHelper.isValid(str.toString());
//		if("".equals(str)) return false;
//		return true;
	}
	
	/**
	 * @author 张志刚	2014-08-05
	 * 功能：判断对象是否为空
	 */
	public static boolean isNotEmpty(Object str){
		if(null == str) return false;
		return StringHelper.isValid(str.toString());
//		if("".equals(str.toString())) return false;
//		if("null".equals(str.toString())) return false;
//		return true;
	}
	
	public static void printList(List<String> list){
		if(list==null || list.size()==0) {
			System.out.println("集合为空");
			return ;
		}
		for(Object obj : list){
			System.out.println(obj.toString());
		}
	}

	public static void printList(Collection<String> coll){
		if(coll==null || coll.size()==0) {
			System.out.println("集合为空");
			return ;
		}
		for(String obj : coll){
			System.out.println(obj.toString());
		}
	}

	/**
	 * @author 张志刚	2014-08-05
	 * @param subject
	 * 功能：判断一个参数是否是正确的科目
	 */
	public static boolean isSubject(String subject){
		String[] subjects = new String[]{"YW","SX","YY","WL","HX","SW","DL","LS","ZZ","KX","SP","XJ"}; 
		subject = subject.toUpperCase();
		for(String str : subjects){
			if(str.equals(subject)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @author 张志刚  2015年4月8日
	 * 获取科目列表
	 */
	public static List<String> getSubjects(int currentEdu){
		List<String> list = new ArrayList<String>();
		list.add("YW");
		list.add("SX");
		list.add("YY");
		list.add("WL");
		list.add("HX");
		list.add("SW");
		list.add("DL");
		list.add("LS");
		if(currentEdu==1){
			list.add("SP");
			list.add("KX");
		} else {
			list.add("ZZ");
		}
		list.add("XJ");
		return list;
	}
	
	/**
	 * @author 张志刚  2015年4月10日
	 */
	public static String getSubjectName(String subject){
		if("YW".equalsIgnoreCase(subject)) return "语文";
		if("SX".equalsIgnoreCase(subject)) return "数学";
		if("YY".equalsIgnoreCase(subject)) return "英语";
		if("DL".equalsIgnoreCase(subject)) return "地理";
		if("LS".equalsIgnoreCase(subject)) return "历史";
		if("ZZ".equalsIgnoreCase(subject)) return "政治";
		if("WL".equalsIgnoreCase(subject)) return "物理";
		if("HX".equalsIgnoreCase(subject)) return "化学";
		if("SW".equalsIgnoreCase(subject)) return "生物";
		if("KX".equalsIgnoreCase(subject)) return "科学";
		if("SP".equalsIgnoreCase(subject)) return "思想品德";
		if("XJ".equalsIgnoreCase(subject)) return "信息技术";
		return "";
	}
	
	/**
	 * 
	 * @author lvcb  2015年6月8日
	 */
	public static List<String> getSubjectZhcnName(){
		List<String> l= new ArrayList<String>();
		l.add("数学");
		l.add("语文");
		l.add("英语");
		l.add("物理");
		l.add("化学");
		l.add("生物");
		l.add("地理");
		l.add("历史");
		l.add("政治");
		l.add("科学");
		l.add("思想品德");
		l.add("信息技术");
		return l;
	}
	
	
	
	/**
	 * @author 张志刚  2015年5月12日
	 * @return 获取有效的用户名
	 * @author 张志刚  2015年6月4日
	 * 根据文件路径或者文件名称获取文件后缀
	 */
	public static String getFileSuffix(String filename){
		return filename.substring( filename.lastIndexOf(".") );
	}
	
	/**
	 * @author 张志刚  2015年8月7日
	 * 功能：获取数值
	 * 一万一下原样输出
	 * 一万以上按约数  1.1万格式，向上取整
	 * 十万以上按约数  12万格式，向上取整
	 */
	public static String getProbablyNum(int num){
		if(num<10000) return num+"";
		
		if(num<100000) {
			if(num%10000==0) return num/10000+"万";
			if(num%1000==0) return num/10000.0+"万";
			//不是整数向上取整
			int i = (num+1000)/1000;
			if(i%10==0) return i/10+"万";
			else return i/10.0+"万";
		}
		
		if(num>=100000){
			if(num%10000==0) return num/10000+"万";
			else return (num+10000)/10000+"万";
		}
		
		return "";
	}
	
}





