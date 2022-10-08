package com.exception;

public class Test {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		
		//假設要抓取多個異常，從小到大
		
		try {   //try監控區域
			new Test().a();
			System.out.println(a/b);
		}catch(ArithmeticException e){  //catch(想要捕獲的異常類型) 捕獲異常
			System.out.println("程序出現異常，變量b不能為0");
		}catch(Error e){  
			System.out.println("Error");
		}catch(Exception e) {
			System.out.println("Exception");
		}catch(Throwable t) {
			System.out.println("Throwable");
		}finally {  //處理善後工作
			System.out.println("finally");
		}
				
		//finally 可以不要
	}
	
	public void a() {b();}
	public void b() {a();}
}
