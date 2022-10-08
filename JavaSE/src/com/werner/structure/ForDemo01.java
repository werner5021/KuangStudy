package com.werner.structure;

public class ForDemo01 {
	public static void main(String[] args) {
		int a = 1;  //初始化條件
		while(a<=100) {  //條件判斷
			System.out.println(a);  //循環體
			a+=2;     //迭代
		}
		
		System.out.println("while循環結束!");
		
		//初始化條件 //條件判斷 //循環體
		for(int i=1; i<=100;i++) {
			System.out.println(i);
		}
		
		System.out.println("for循環結束!");
		
		/*
		 * 關於for 循環有以下特性:
		 * 
		 * 最先執行初始化步驟，可以聲明一種類型，但可初始化一個或多個循環變控制變量，也可以是空語句，
		 * 檢測boolean值為true則循環執行，false循環終止，往下一句執行
		 * 執行一次循環後，更新循環控制變量(迭代因子控制循環變量的增減)
		 * 再次檢測boolean表達式，循環執行上面的過程
		 */
		//死循環
//		for(;;i++) {
//			
//		}
	}

}
