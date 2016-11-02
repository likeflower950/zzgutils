package com.zzgproject.mmmorder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.zzgproject.file.ReadFile;
import com.zzgproject.file.WriteFile;
import com.zzgproject.utils.StringHelper;


public class ParseMmmOrder2 {
	
	private static final String orderPre = "订单";
	private static final String amountPre = "MMM参与者";
	private static final String timesPre = "用这些指定的资料发件人直到";
	private static final String timesSuf = "莫斯科时间可以帮助：";
	
	private static final String timesPre2 = "您应该用这些资料直到";
	private static final String timesSuf2 = "莫斯科时间帮助。";
	
	private static final String banknamePre = "银行名称";
	private static final String banknoPre = "人名帐户号码";
	private static final String namePre = "姓名";
	
	private static final String takerPre = "收款人:";
	private static final String takerLeaderPre = "收款人的领导人:";
	private static final String payerPre = "发款人:";
	private static final String payerLeaderPre = "发款人的领导人:";
	
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm dd.MM.yyyy");
	private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final ReadFile read = new ReadFile();
	private static final WriteFile write = new WriteFile();
	
	public static void main(String[] args) throws Exception{
		
		File dir = new File("D:\\mmm");
		File[] files = dir.listFiles();
		System.out.println(files.length);
		
//		for(File file : files){
		for(int m=0; m<=0; m++){
//			if(file.isDirectory()) continue;
			List<String> list = read.readFile("D:\\mmm\\汇总\\汇总-native-20160723.txt", "UTF-8");
//			List<String> list = read.readFile(file);
			StringHelper.printList(list);
//			write.writeHosts("D:\\mmm\\汇总\\汇总-native-20160723.txt", list, true);
//			int i = 0;
//			if(i==0) continue;
			
			Map<String, String> map = new HashMap<>();
			for(String str : list){
				str = str.trim();
				if(StringHelper.isEmpty(str)) continue;
				if(str.startsWith(orderPre)){
					map.put("orderno", str);
	//				System.out.println(map);
					continue;
				}
				if(str.startsWith(amountPre)){
					map.put("amount", str.split("：")[1]);
	//				System.out.println(map);
					continue;
				}
				if(str.startsWith(timesPre)){
					str = str.replace(timesPre, "").replace(timesSuf, "").trim();
					map.put("times", sdf2.format(sdf1.parse(str)));
	//				System.out.println(map);
					continue;
				}
				if(str.startsWith(timesPre2)){
					str = str.replace(timesPre2, "").replace(timesSuf2, "").trim();
					map.put("times", sdf2.format(sdf1.parse(str)));
	//				System.out.println(map);
					continue;
				}
				if(str.startsWith(banknamePre)) {
					map.put("bankname", str.split(":")[1]);
	//				System.out.println(map);
					continue;
				}
				if(str.startsWith(banknoPre)){
					map.put("bankno", str.split(":")[1]);
	//				System.out.println(map);
					continue;
				}
				if(str.startsWith(namePre)){
					map.put("name", str.split(":")[1]);
	//				System.out.println(map);
					continue;
				}
				if(str.startsWith(takerPre)){
					map.put("takerInfo", str.trim());
					str = str.replace(takerPre, "").replace("(*****)", "").trim();
					str = str.replace("电话号码:", "").replace("+86", "");
					map.put("takerName", str.split(",")[0].trim());
					map.put("takerPhone", str.split(",")[1].trim());
	//				System.out.println(map);
					continue;
				}
				
				if(str.startsWith(takerLeaderPre)){
					map.put("takerLeaderInfo", str.trim());
					str = str.replace(takerLeaderPre, "").replace("(*****)", "").trim();
					str = str.replace("电话号码:", "").replace("+86", "");
					map.put("takerLeaderName", str.split(",")[0].trim());
					map.put("takerLeaderPhone", str.split(",")[1].trim());
	//				System.out.println(map);
					continue;
				}
				if(str.startsWith(payerPre)){
					map.put("payerInfo", str.trim());
					str = str.replace(payerPre, "").replace("(*****)", "").trim();
					str = str.replace("电话号码:", "").replace("+86", "");
					map.put("payerName", str.split(",")[0].trim());
					map.put("payerPhone", str.split(",")[1].trim());
	//				System.out.println(map);
					continue;
				}
				if(str.startsWith(payerLeaderPre)){
					map.put("payerLeaderInfo", str.trim());
					str = str.replace(payerLeaderPre, "").replace("(*****)", "").trim();
					str = str.replace("电话号码:", "").replace("+86", "");
					map.put("payerLeaderName", str.split(",")[0].trim());
					map.put("payerLeaderPhone", str.split(",")[1].trim());
					System.out.println(JSONObject.fromObject(map));
					write.writeHosts("D:\\mmm\\重要汇总-20160723.txt", JSONObject.fromObject(map).toString(), true);
					map.clear();
					continue;
				}
			}
		}
	}
}
