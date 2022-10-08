package com.werner;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendFileEmail {
	public static void main(String[] args) throws Exception {
		
		String host = "smtp.gmail.com";
		String user = "werner5021@gmail.com";
		String recipient = "werner5021@gmail.com";
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
				
				//4.連接上之後我們需要發送郵件，發送附件的方法
				MimeMessage mimeMessage = imagesMail(session, user, recipient);
				
				//5.發送郵件
				ts.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
				
				//6.關閉連接
				ts.close();	
	}
	
	public static MimeMessage imagesMail(Session session, String user,String recipient) throws AddressException, MessagingException {
		
		//消息的固定訊息
		MimeMessage mimeMessage = new MimeMessage(session);
		
		//郵件發送人
		mimeMessage.setFrom(new InternetAddress(user));
		//郵件接收人
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		mimeMessage.setSubject("測試發送有附件的信件");  //郵件主題
		
		/*
		 * 逼寫郵件內容
		 * 1.圖片
		 * 2.附件
		 * 文本
		 */
		
		//圖片
		MimeBodyPart body1 = new MimeBodyPart();
		body1.setDataHandler(new DataHandler(new FileDataSource("src/main/resources/IU09.jpg")));
		body1.setContentID("IU09.jpg");  //圖片設置ID
		
		//文本
		MimeBodyPart body2 = new MimeBodyPart();
		body2.setContent("這不是廣告<img src='cid:JISOO09.jpg'>","text/html;charset=UTF-8");
		
		//附件
		MimeBodyPart body3 = new MimeBodyPart();
		body3.setDataHandler(new DataHandler(new FileDataSource("src/main/resources/test.properties")));
		body3.setFileName("test.properties");  //附件設置名字
		
		MimeBodyPart body4 = new MimeBodyPart();
		body4.setDataHandler(new DataHandler(new FileDataSource("src/main/resources/test01.txt")));
		body4.setFileName("");  //附件設名字
		
		//拼裝郵件正文內容
		MimeMultipart multipart1 = new MimeMultipart(); 
		multipart1.addBodyPart(body1);
		multipart1.addBodyPart(body2);
		multipart1.setSubType("related");  //文本和圖片內嵌成功
		
		//new MimeBodyPart().setContent(multipart1);  將拼接好的正文內容設置為主體
		MimeBodyPart contentText = new MimeBodyPart();
		contentText.setContent(multipart1);
		
		//拼接附件
		MimeMultipart allFile = new MimeMultipart();
		allFile.addBodyPart(body3);  //附件
		allFile.addBodyPart(body4);  //附件
		allFile.addBodyPart(contentText);  //正文
		allFile.setSubType("mixed");  //正文和附件都存在郵件中，所有類型設置為mixed
		
		//收到Message消息中
		mimeMessage.setContent(allFile);
		mimeMessage.saveChanges();  //保存修改
		
		return mimeMessage;
	}
	
}
