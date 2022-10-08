package com.oop.demo10;

public class Outer {
	
	private int id=10;
	public void out() {
		System.out.println("這是外部類別的方法");
	}
	/*========================================*/
	//成員內部類別
	public class Inner{
		public void in() {
			System.out.println("這是內部類別的方法");
		}	
		
		//內部類直接訪問外部變量
		//獲得外部類的私有屬性
		public void getID() {
			System.out.println(id);
		}		
	}
	/*=============================================*/
	//靜態內部類別
		public static class Inner1{
			public void in() {
				System.out.println("這是內部類別的方法");
			}	
		}
	
	/*===============================================*/
	//局部內部類別
		public void method() {
			class Inner{
				
			}
		}
		
}

//一個java類中可以有多了class類，但只能有一個 public class
class A{
	
}
