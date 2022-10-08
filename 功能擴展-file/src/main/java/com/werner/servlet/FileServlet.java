package com.werner.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//判斷上傳文件是普通表單，還是帶文件的表單
		if(!ServletFileUpload.isMultipartContent(request)) {
			return ; //終止方法運行，說明這是一個普通表單，直接返回
		}  //如果通過這個if，說明我們的表單是帶文件上傳的

		//創建上傳文件的保存路徑，建議保存在WEB-INF目錄下，用戶無法直接訪問上傳的文件
		String uploadPath= this.getServletContext().getRealPath("/WEB-INF/upload");		
		
		File uploadfile = new File(uploadPath);
		if(!uploadfile.exists()) {
			uploadfile.mkdir();  //第一次上傳時，創建這個目錄
		}

		//緩存，臨時文件
		//臨時路徑，假設文件大小超過預期，我們把它放到一個臨時文件中，過幾天自動刪除，或者提醒用戶轉存為永久
		String tmpPath= this.getServletContext().getRealPath("/WEB-INF/tmp");
		File file = new File(tmpPath);
		if(!file.exists()) {
			file.mkdir();  //第一次上傳時，創建這個臨時目錄
		}				

		//處理上傳文件，一般通過流來獲取，我們可以使用request.getInputStream()，這樣的原生態的文件上傳獲取，十分麻煩
		//但是我們都建議使用 Apache 的文件上傳組件來實現，common-fileupload，他需要依賴於commons-io組件:

	try {
		//1.創建DiskFileItemFactory對象，處理文件上傳路徑或者大小限制的:
		DiskFileItemFactory factory = getDiskFileItemFactory(file);
		//2.獲取ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory);
		//3.處理上傳的文件，需要從ServletFileUpload對象中獲取
		String msg = uploadParseRequest(upload, request, uploadPath);		
		
		//servlet請求轉發消息
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("info.jsp").forward(request, response);
					
	}  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	//自己進行封裝方法
	public static DiskFileItemFactory getDiskFileItemFactory(File file) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//通過這個工廠設置一個緩衝區，當上傳的文件大於這個緩衝區的時候，將他放到臨時文件中
		//以下兩項可以不設定，源代碼有默認值
		factory.setSizeThreshold(1024 * 1024);  //緩衝區大小為1MB
		factory.setRepository(file);  //臨時目錄的保存目錄，需要一個File
		return factory;
	}

	//自己進行封裝方法
	public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory) {
		ServletFileUpload upload = new ServletFileUpload(factory);
		//監聽上傳文件進度
		upload.setProgressListener(new ProgressListener() {

			//pBytesRead: 已經讀取的文件大小
			//pContentLength: 文件大小
			public void update(long pBytesRead, long pContentLength, int pItems) {
				System.out.println("總大小: "+ pContentLength + "已上傳:" + pBytesRead);
			}
		});

		//處理亂碼問題
		upload.setHeaderEncoding("UTF-8");  //不設置則為Java預設的ISO-8859-1
		//設置單個文件的最大值
		upload.setFileSizeMax(1024 * 1024 * 10);
		//設置總共能夠上傳文件的大小
		//1024 = 1KB * 1024 = 1MB * 10 = 10MB
		upload.setSizeMax(1024 * 1024 * 10);

		return upload;		
	}

	//自己進行封裝方法
	public static String uploadParseRequest(ServletFileUpload upload, HttpServletRequest request, String uploadPath) throws IOException, FileUploadException {
		String msg = "";

		//把前端請求解析，封裝成一個FileItem對象
		List<FileItem> fileItems = upload.parseRequest(request);
		for(FileItem fileItem : fileItems) {  //每一個fileItem就是一個輸入項input，代表上傳的控件
			//fileItem 每一個表單對象
			if(fileItem.isFormField()) {  //判斷上傳的文件是普通表單還是帶文件的表單，看是不是input="file"
				//getFileName 指的是前端表單控件的name
				String name = fileItem.getFieldName();	
				String value = fileItem.getString("UTF-8");  //處理亂碼
				System.out.println(name + ":" + value);
			}else {  //判斷是上傳的文件，是文件表單

				//===============step1 處理文件===============//
				
				//拿到文件名字
				String uploadFieldName = fileItem.getName();
				//可能存在文件名不合法的情況
				System.out.println("上傳文件名: " + uploadFieldName);

				if(uploadFieldName.trim().equals("") || uploadFieldName==null) {
					continue;
				}

				//獲得上傳的文件名  /images/girl/paojie.png
				String fileName = uploadFieldName.substring(uploadFieldName.lastIndexOf("\\")+1);				
				//獲得文件的後綴名
				String fileExtName = uploadFieldName.substring(uploadFieldName.lastIndexOf(".")+1);				
				
				/*
				 * 如果文件後綴名 fileExtName 不是我們所需要的
				 * 就直接return，不處理，告訴用戶文件類型不對
				 */
				System.out.println("文件資訊 [ 件名: " + fileName + "---文件類型" + fileExtName + "]");
		
				
				/*
				 * 網路傳輸中的東西，都需要序列化
				 * POJO、實體類，如果想要在多個電腦上運行，傳輸就需要把對象都序列化，
				 * 因此，寫POJO實體類時，一律都先序列化implements Serializable
				 */
				
				/*
				 * implements Serializable:標記接口(介面裡面沒有方法)，
				 * JVM識別到標記接口時，會幫你做一些事情
				 * JNI = Java Native Interface -> Java本地化接口
				 * Java中有Java棧(平常寫代碼在這裡運行)、本地方法棧(C++執行)
				 * 在有native的關鍵詞的地方，交給操作系統做，而非由Java執行，故Java無法預控，也是Java無解決多線程的操作時間的原因
				 */
				
				//可以使用UUID(唯一識別的通用碼)，保證文件名稱唯一
				//UUID.randomUUID()，隨機生成一個為一是別的通用碼
				//UUID有序列化
				String uuidPath = UUID.randomUUID().toString();				

				//===============處理文件完畢===============//
				
				//===============step2 存放地址===============//				
				//存到哪? uploadPath
				//文件真實存在的路徑 realPath
				String realPath = uploadPath + "/" + uuidPath;
				
				//給每個文件創建一個對應的文件夾 (使用uuid，所以一定唯一)
				File realPathFile = new File(realPath);
				if(!realPathFile.exists()) {
					realPathFile.mkdir();
				}
				//===============存放地址完畢===============//
				
				//===============step3 文件傳輸===============//
				//獲得文件上傳的流
				InputStream inputStream = fileItem.getInputStream();

				//創建一個文件輸出流
				//realPath = 真實的文件夾
				//差了一個文件，加上輸出文件的名字 + "/" + uuidFileName
				FileOutputStream fos = new FileOutputStream(realPath + "/" + fileName);

				//創建一個緩衝區
				byte[] buffer = new byte[1024*1024];

				//判斷是否讀取完畢
				int len = 0;
				//如果大於0說明還存在數據
				while((len=inputStream.read(buffer))>0) {
					fos.write(buffer, 0, len);
				}
				
				//關閉流
				fos.close();
				inputStream.close();
				
				msg = "文件上傳成功";
				fileItem.delete();  //上傳成功後，清除臨時文件
				//===============文件傳輸完畢===============//
			}
		}
		return msg;
	}

}
