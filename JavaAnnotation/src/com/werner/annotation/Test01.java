package com.werner.annotation;

import java.util.ArrayList;
import java.util.List;

//甚麼是註解

public class Test01 extends Object {

	//@Override 重寫的註解
	//註解有檢查跟約束的作用 toString 改成 tostring 就會報錯
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	//Deprecated  不推薦工程師使用，但可以使用，或存在更好的方式
	@Deprecated 
	public static void test() {
		System.out.println("Deprecated");
	}
	
	//SuppressWarnings 鎮壓警告
	@SuppressWarnings("all")  
	public void test02() {
		List list = new ArrayList();
	}
	
	
	public static void main(String[] args) {
		test();
	}
	
	
	
	
	
}
