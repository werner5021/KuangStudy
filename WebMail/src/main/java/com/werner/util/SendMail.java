package com.werner.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.werner.pojo.User;

//網站3秒原則: 用戶體驗
//多線程實現用戶體驗 (異步處理)
public class SendMail extends Thread{
	
	//用於給用戶發送郵件的信箱
	private String from = "werner5021@gmail.com";
	//信箱的用戶名
	private String username = "werner5021@gmail.com";
	//信箱的密碼
	private String password= "rvoqourbrmicjaur";  //gmail 授權碼
	//發送郵件的服務器地址
	private String host = "smtp.gmail.com";
	
	//Servlet層調Service層、Service層調Dao層 都會使用的，導入一個類
	private User user;
	public SendMail(User user) {
		this.user = user;
	}
	
	@Override
	public void run() {
		try {

			Properties prop = new Properties();
			prop.setProperty("mail.smtp.host", host);  //設置hotmail郵件服務器
			prop.setProperty("mail.transport.protocol", "smtp");  //郵件發送協議，設定傳輸協定
			prop.setProperty("mail.smtp.auth", "true");  //需要驗證用戶名密碼

			prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
			prop.put("mail.smtp.port", "465");	
			prop.put("mail.smtp.starttls.enable", true);
			prop.put("mail.smtp.socketFactory.port", "465");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			//使用JavaMail發送郵件的5個步驟		
			//1.創建定義整個應用程序所需的環境信息的Session對象		
			Session session = Session.getDefaultInstance(prop, new Authenticator() {
				//這段代碼只有QQ有
				protected PasswordAuthentication getPasswordAuthentication() {
					//寄件人郵件用戶名、授權碼
					return new PasswordAuthentication(username,password);
				}		
			});	

			//開啟session的debug模式，這樣就可以看到程序發送email的運行狀態
			session.setDebug(true);		

			//2.通過session得到transport對象
			Transport ts = session.getTransport(); //用來連接跟發送郵件

			//3.使用郵箱的用戶名和授權碼連上郵件服務器
			//ts.connect(host,user,"授權碼");
			ts.connect(host, username, password);

			//4.創建郵件
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));  //寄件人
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));  //收件人
			message.setSubject("用戶註冊郵件");  //郵件的標題

			String info = "恭喜註冊成功，您的用戶名為: "+ user.getUsername()+"\n您的密碼為: "+user.getPassword();
			
			message.setContent(info, "text/html;charset=UTF-8");
			message.saveChanges();
			
			//發送郵件
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
