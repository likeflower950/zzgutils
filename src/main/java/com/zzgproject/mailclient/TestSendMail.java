package com.zzgproject.mailclient;

public class TestSendMail {
	
	public static void main(String[] args){
		TestSendMail tm = new TestSendMail();
		tm.sendTextMail();
	}
	
	
	public void sendTextMail(){
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("likeflower950@163.com");
		mailInfo.setPassword("zzg2795110");
		mailInfo.setFromAddress("likeflower950@163.com");
		mailInfo.setToAddress("517257386@qq.com"); 
		mailInfo.setSubject("欢迎注册MMM系统——获取邮件验证码");
		mailInfo.setContent("欢迎注册MMM系统，邮件中为验证码。/n这是另外一行了");
		
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);
	}
}
