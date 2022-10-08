package com.werner.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		1. 要獲取下載文件的路徑
//		String realPath = this.getServletContext().getRealPath("/IU01.jpg");
//		String realPath = "D:\\2_Workspace\\javaweb-02-servlet\\response\\target\\classes\\IU01.jpg";
		String realPath = "D:\\2_Workspace\\javaweb-02-servlet\\response\\src\\main\\resources\\IU01.jpg";
		System.out.println("下載文件的路徑: "+ realPath);
//		2. 下載的文件名是甚麼 ?
		String fileName = realPath.substring(realPath.lastIndexOf("//")+1);		
//		3. 想辦法讓瀏覽器能夠支援(Content-Disposition)下載我們需要的東西
		resp.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));	
//		4. 獲取下載文件的輸入流
		FileInputStream in = new FileInputStream(realPath);		
//		5. 創建緩衝區
		byte[] buffer = new byte[1024];
		int len = 0;		
//		6. 獲取 OutputStream 對象
		ServletOutputStream out = resp.getOutputStream();		
//		7. 將 FileOutPutStream 流寫入到緩衝區，使用 OutputStream 將緩衝區中的數據輸出到客戶端
		while((len = in.read(buffer))>0) {
			out.write(buffer,0,len);
		}
		
		out.close();
		in.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}





}
