package com.werner;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendImageEmail {
	public static void main(String[] args) throws Exception {
		
		String host = "smtp.gmail.com";
		String user = "werner5021@gmail.com";
		String pw = "rvoqourbrmicjaur";  //gmail

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
				
				//設置郵件的基本訊息
				//寄件人
				message.setFrom(new InternetAddress(user));
				//收件人
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(user));
				//郵件的標題
				message.setSubject("帶圖片的郵件");
				
				/*=======================================*/
				//準備郵件數據				
				//準備圖片數據
				MimeBodyPart image = new MimeBodyPart();  //MimeBodyPart代表內部一個的資源
				//圖片需要經過數據處理 → DataHandler: 數據處理
				DataHandler dh = new DataHandler(new FileDataSource("src/main/resources/IU09.jpg"));
				image.setDataHandler(dh);  //在我們的主體Body中，放入這個處理的圖片數據
				image.setContentID("IU09.jpg");  //給圖片設置一個ID，為了在後面使用
				
				//準備正文數據
				MimeBodyPart text = new MimeBodyPart();
				text.setContent("這是一封正文帶圖片<img src='cid:IU09.jpg'>的郵件","text/html;charset=UTF-8");
				
				//描述數據關係
				MimeMultipart nm = new MimeMultipart();
				nm.addBodyPart(text);
				nm.addBodyPart(image);
				nm.setSubType("related");  //內嵌用related
				
				//設置到消息中，保存修改
				message.setContent(nm);  //把最後編輯好的郵件放到消息當中
				message.saveChanges();  //保存修改
				
				/*=======================================*/
				
				//5.發送郵件
				ts.sendMessage(message, message.getAllRecipients());
				
				//6.關閉連接
				ts.close();					
				
				
		
	}
}
