package com.werner.base;

public class Demo03 {

	public static void main(String[] args) {
		//整數拓展:   進制   二進制0b   十進制   八進制0   十六進制0x
		
		int i = 10;
		int i2 = 010;   //八進制0
		int i3 = 0x10;  //十六進制0x   0-9 A-F 16

		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println("==================");
		//==========================================		
		//浮點數拓展   銀行怎麼表示?
		//BigDecimal   數學工具類
		//==========================================
		//float     有限  離散  捨入誤差  大約  接近但不等於
		//double
		//最好完全使用浮點數進行比較
		//最好完全使用浮點數進行比較
		//最好完全使用浮點數進行比較
		
		float f = 0.1f;
		double d = 1.0/10;
		
		System.out.println(f == d);
		System.out.println(f);
		System.out.println(d);
		
		float d1 = 22222222222f;
		float d2 = d1 + 1;
		
		System.out.println(d1 == d2);
		
		//==========================================		
		//字元拓展
		//==========================================
		
		char c1 = 'a';
		char c2 = '中';
		System.out.println(c1);
		System.out.println((int)c1);  //強制轉換
		
		System.out.println(c2);
		System.out.println((int)c2);  //強制轉換
		
		//所有的字元本質還是數字
		//編碼 Unicode表 (97=a  65=A) 2個字節  0-65536
		//U0000 到 UFFFF
		
		char c3 = '\u0061';
		System.out.println(c3);
		
		//跳脫字元
		// \t  制表符
		// \n  換行
		// ...
		
		System.out.println("Hello World");
		
		System.out.println("==================");
		String sa = new String("Hello World");
		String sb = new String("Hello World");
		System.out.println(sa == sb);
		
		String sc = "Hello World";
		String sd = "Hello World";
		System.out.println(sc == sd);
		
		//boolean拓展
		boolean flag = true;
		if (flag == true) {}
		if (flag) {}
	}

}
