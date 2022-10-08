package com.werner.demo03;

public class Client {
	public static void main(String[] args) {
		
		//真實角色
		Host host = new Host();
		
		//代理角色: 現在沒有 (要通過處理程序生成代理角色)
		ProxyInvocationHandler pih = new ProxyInvocationHandler();
		//通過調用程序處理角色，來處理我們要調用的介面對象
		pih.setRent(host);  //我生成的代理類pih要去實現setRent()這個介面，類還沒被創建
		
		//在這裡才創建類，獲得代理類
		Rent proxy = (Rent) pih.getProxy();  //這裡的proxy就是動態生成的，我們並沒有寫  
		proxy.rent();
		
	}
}
 