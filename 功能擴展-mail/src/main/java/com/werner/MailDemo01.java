package com.werner;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

//發送一封簡單的郵件
public class MailDemo01 {
	public static void main(String[] args) throws Exception {
		
		String host = "smtp.gmail.com";
		String user = "werner5021@gmail.com";
		String pw = "rvoqourbrmicjaur";  //gmail 授權碼
//      final String Password = "fvnfnekzkxnjdebw"; // Insert Your gmail password

		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", host);  //設置hotmail郵件服務器
		prop.setProperty("mail.transport.protocol", "smtp");  //郵件發送協議，設定傳輸協定
		prop.setProperty("mail.smtp.auth", "true");  //需要驗證用戶名密碼
		
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.port", "465");	
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		//關於QQ郵箱，還要設置SSL加密，加上以下代碼即可
//		MailSSLSocketFactory sf = new MailSSLSocketFactory();
//		sf.setTrustAllHosts(true);
//		prop.put("mail.smtp.ssl.enable", "true");
//		prop.put("mail.smtp.ssl.socketFactory", sf);
		
		//使用JavaMail發送郵件的5個步驟		
		//1.創建定義整個應用程序所需的環境信息的Session對象		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			//這段代碼只有QQ有
			protected PasswordAuthentication getPasswordAuthentication() {
				//寄件人郵件用戶名、授權碼
				return new PasswordAuthentication(user,pw);
			}		
		});	
		
		//開啟session的debug模式，這樣就可以看到程序發送email的運行狀態
		session.setDebug(true);		
		
		//2.通過session得到transport對象
		Transport ts = session.getTransport();  //用來連接跟發送郵件
		
		//3.使用郵箱的用戶名和授權碼連上郵件服務器
		//ts.connect(host,user,"授權碼");
		ts.connect(host, user, pw);
		
		//4.創建郵件
		//注意需要傳遞session
		//創建郵件對象
		MimeMessage message = new MimeMessage(session);
		
		//指名郵件的寄件人
		message.setFrom(new InternetAddress(user));
		
		//指名郵件的收件人，現在的寄件人和收件人是一樣的，就是自己發給自己
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(user));
		
		//郵件的標題
		message.setSubject("只包含文本的簡單郵件");
		
		// 郵件的文本內容
		message.setContent("<h1 style='color:red'>你好阿</h1>","text/html;charset=UTF-8");
		//5.發送郵件
		ts.sendMessage(message, message.getAllRecipients());
		
		//6.關閉連接
		ts.close();		
	}
}

