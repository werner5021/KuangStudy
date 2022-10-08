package com.werner.reflection;

public class Test07 {
	public static void main(String[] args) throws ClassNotFoundException {
		//獲取系統類加載器
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader);
		
		//獲取系統類加載器的父類 → 拓展類加載器
		ClassLoader parent = systemClassLoader.getParent();
		System.out.println(parent);
		
		//獲得拓展類加載器的父類 → 根加載器
		ClassLoader grandParent = parent.getParent();
		System.out.println(grandParent);  //根加載器是讀取核心內部，Java讀取不到
		
		
		//測試當前類是哪個加載器加載的
		ClassLoader classLoader = Class.forName("com.werner.reflection.Test07").getClassLoader();
		System.out.println(classLoader);  //自定義的類屬於用戶類加載器
	
		//測試JDK內置的類是哪個加載器加載的 
		classLoader = Class.forName("java.lang.Object").getClassLoader();
		System.out.println(classLoader);  //Object類屬於rt.jar包下的系統，屬於根加載器加載的，所以無法印出
		
		//如何獲得系統類加載器可以加載的路徑?		
		System.out.println(System.getProperty("java.class.path"));
		
		//雙親委派機制
			//多重檢測，以保證安全性
		    //如果自定義java.lang.String，會先去找系統類加載器、拓展類加載器、根加載器，發現根加載器裡有這個包，自定義就無效
		
	}
}
