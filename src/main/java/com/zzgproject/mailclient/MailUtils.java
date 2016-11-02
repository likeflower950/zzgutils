package com.zzgproject.mailclient;

import java.util.Properties;

import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class MailUtils {

	/****
	 * 通过JNDI 查找给定域的邮件服务器。
	 * @param host 	主机名 如：163.com,qq.com,126.com ....
	 * @throws Exception
	 */
	public static String getSMTPServerByJNDI(String host) throws Exception {
		Properties jndiEnvironmentProperties = new Properties();
		jndiEnvironmentProperties.put("java.naming.factory.initial","com.sun.jndi.dns.DnsContextFactory");
		DirContext initialDirContext = new InitialDirContext(jndiEnvironmentProperties);
		Attributes attributes = initialDirContext.getAttributes(host,new String[] { "MX" });
		Attribute attribute = attributes.get("MX");
		String[] servers = new String[attribute.size()];
		for (int i = 0; i < attribute.size(); i++) {
			servers[i] = attribute.get(i).toString();
		}
		String server = servers[0];
		server = server.substring(server.indexOf(" ") + 1, servers[0].length() - 1);
		return server;
	}
}









