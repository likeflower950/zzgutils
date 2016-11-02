package com.zzgproject.mmmorder;

import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONObject;

import com.zzgproject.file.ReadFile;
import com.zzgproject.file.WriteFile;

public class ParseMmmOrder3 {
	
	private static final String orderPre = "订单";
	private static final String amountPre = "MMM参与者";
	private static final String timesPre = "用这些指定的资料发件人直到";
	private static final String timesSuf = "莫斯科时间可以帮助：";
	
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
		
		List<String> list = read.readFile("D:\\mmm\\重要汇总-20160723.txt", "UTF-8");
		int id = 1;
		for(String str : list){
			JSONObject json = JSONObject.fromObject(str);
			
			String orderno = json.getString("orderno").replace("订单: ", "");
			String amount = json.getString("amount").replace(",00 CNY", "").replace(" ", "");
			String times = json.getString("times");
			
			String takerName = json.getString("takerName");
			String takerPhone = json.getString("takerPhone");
			String takerInfo = json.getString("takerInfo");
			
			String takerLeaderName = json.getString("takerLeaderName");
			String takerLeaderPhone = json.getString("takerLeaderPhone");
			String takerLeaderInfo = json.getString("takerLeaderInfo");
			
			String payerName = json.getString("payerName");
			String payerPhone = json.getString("payerPhone");
			String payerInfo = json.getString("payerInfo");
			
			String payerLeaderName = json.getString("payerLeaderName");
			String payerLeaderPhone = json.getString("payerLeaderPhone");
			String payerLeaderInfo = json.getString("payerLeaderInfo");
			
			String name = json.getString("name");
			String bankname = json.getString("bankname");
			String bankno = json.getString("bankno");
			
			str = id+"\t"+orderno+"\t"+amount+"\t"+times+"\t"
					+takerName+"\t"+takerPhone+"\t"+takerInfo+"\t"
					+takerLeaderName+"\t"+takerLeaderPhone+"\t"+takerLeaderInfo+"\t"
					+payerName+"\t"+payerPhone+"\t"+payerInfo+"\t"
					+payerLeaderName+"\t"+payerLeaderPhone+"\t"+payerLeaderInfo+"\t"
					+name+"\t"+bankname+"\t"+bankno;
			System.out.println(str);
			write.writeHosts("D:\\mmm\\汇总\\汇总-database-20160723.txt", str, true);
			id++;
		}
		System.out.println(list.size());
		
	}
}











