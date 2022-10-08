package com.werner.structure;

public class SwitchDemo02 {
	public static void main(String[] args) {
		String name = "尼瑪";
		
		//JDK7的新特性，表達式結果可以是字串
		//字符的本質是數字
		
		//反編譯: java --> class(字節碼文件) ---反編譯(IDEA)
		
		switch(name) {
			case "哈哈":
				System.out.println("哈哈");
				break;
			case "尼瑪":
				System.out.println("尼瑪");
				break;
			default:
				System.out.println("錯了");
				break;
		}
		
	}
}
