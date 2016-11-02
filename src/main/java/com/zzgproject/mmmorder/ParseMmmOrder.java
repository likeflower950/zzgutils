package com.zzgproject.mmmorder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zzgproject.file.ReadFile;
import com.zzgproject.utils.StringHelper;

public class ParseMmmOrder {
	
	private static final String orderPre = "订单";
	private static final String amountPre = "MMM参与者";
	private static final String timesPre = "用这些指定的资料发件人直到";
	private static final String timesSuf = "莫斯科时间可以帮助：";
	
	private static final String banknamePre = "银行名称";
	private static final String banknoPre = "人名帐户号码";
	private static final String namePre = "姓名";
	
	private static final String takerPre = "收款人";
	private static final String takerLeaderPre = "收款人的领导人";
	private static final String payerPre = "发款人";
	private static final String payerLeaderPre = "发款人的领导人";
	
	
	public static void main(String[] args) throws Exception{
		
		ReadFile read = new ReadFile();
		List<String> list = read.readFile("D:\\mmm\\2016mmm-gang.txt");
		StringHelper.printList(list);
		
		Map<String, String> map = new HashMap<>();
		for(String str : list){
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
				map.put("times", str.replace(timesPre, "").replace(timesSuf, ""));
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
			if(str.startsWith(takerLeaderPre)){
				map.put("takerLeader", str.split(":")[1]);
				map.put("takerLeaderPhone", str.split(":")[2]);
//				System.out.println(map);
				continue;
			}
			if(str.startsWith(takerPre)){
				map.put("taker", str.split(":")[1]);
				map.put("takerPhone", str.split(":")[2]);
//				System.out.println(map);
				continue;
			}
			if(str.startsWith(payerLeaderPre)){
				map.put("payerLeader", str.split(":")[1]);
				map.put("payerLeaderPhone", str.split(":")[1]);
				System.out.println(map);
				map.clear();
				continue;
			}
			if(str.startsWith(payerPre)){
				map.put("payer", str.split(":")[1]);
				map.put("payerPhone", str.split(":")[2]);
//				System.out.println(map);
				continue;
			}
		}
		
	}
}
