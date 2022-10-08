package com.werner.servlet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//如何讓瀏覽器5秒自動刷新一次
		resp.setHeader("refresh", "3");
		
		//在記憶體中，創建一個圖片
		BufferedImage image= new BufferedImage(80,20, BufferedImage.TYPE_INT_RGB);
		//得到圖片
		Graphics2D graphics = (Graphics2D) image.getGraphics();  //graphics相當於畫筆
		//設置圖片的背景顏色
		graphics.setColor(Color.white);
		graphics.fillRect(0,0,80,80);
		//給圖片寫數據
		graphics.setColor(Color.BLUE);
		graphics.setFont(new Font(null, Font.BOLD, 20));
		graphics.drawString(makeNum(), 0, 20);
		
		//告訴瀏覽器，這個請求用圖片的方式打開
		resp.setContentType("image/jpg");
		//網站存在緩存，不讓瀏覽器緩存
		resp.setDateHeader("expires", -1);
		resp.setHeader("Cache-Control", "no-chche");
		resp.setHeader("Program", "no-cache");
		
		//把圖片寫給瀏覽器
		ImageIO.write(image, "jpg", resp.getOutputStream());
		
	}
	//生成隨機數
	private String makeNum(){
		Random random = new Random();
		String num = random.nextInt(99999999) + "";
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<7-num.length() ;i++) {
			sb.append("0");
		}
		String s = sb.toString() + num;
		return num;
	}
	
	
	
}
