package com.zzgproject.mailclient;


public class TestSimpleMailSender {

	public void testSendHtmlMail(){
		 MailSenderInfo mailInfo = new MailSenderInfo();
		  mailInfo.setMailServerHost("smtp.163.com"); 
		  mailInfo.setMailServerPort("25"); 
		  mailInfo.setValidate(true); 
		  mailInfo.setUserName("likeflower950@163.com"); 
		  mailInfo.setPassword("zzg2795110");//您的邮箱密码 

//		  mailInfo.setUserName("username"); 
//		  mailInfo.setPassword("********");//您的邮箱密码 
		  mailInfo.setFromAddress("likeflower950@163.com"); 
		  mailInfo.setToAddress("517257386@qq.com"); 
		  mailInfo.setSubject("元旦快乐"); 
		  mailInfo.setContent("<a href='http://www.hao123.com/'>元旦快乐，感谢2012,走好2013.</a>"); 
	         //这个类主要来发送邮件
		  SimpleMailSender sms = new SimpleMailSender();
	      sms.sendHtmlMail(mailInfo);//发送html格式
	}
	
	public void testSendTextMail(){
		//这个类主要是设置邮件
		  MailSenderInfo mailInfo = new MailSenderInfo(); 
		  mailInfo.setMailServerHost("smtp.163.com"); 
		  mailInfo.setMailServerPort("25"); 
		  mailInfo.setValidate(true); 
		  mailInfo.setUserName("likeflower950@163.com"); 
		  mailInfo.setPassword("zzg2795110");//您的邮箱密码 
		  mailInfo.setFromAddress("likeflower950@163.com"); 
		  mailInfo.setToAddress("517257386@qq.com"); 
		  mailInfo.setSubject("元旦快乐"); 
		  mailInfo.setContent("元旦快乐，感谢2012,走好2013."); 
	         //这个类主要来发送邮件
		  SimpleMailSender sms = new SimpleMailSender();
	       sms.sendTextMail(mailInfo);//发送文体格式 
//	          sms.sendHtmlMail(mailInfo);//发送html格式
	}
}
