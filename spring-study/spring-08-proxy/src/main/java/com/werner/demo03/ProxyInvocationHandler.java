package com.werner.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//我們會用這個類，自動生成代理
public class ProxyInvocationHandler implements InvocationHandler{
	
	//被代理的介面
	private Rent rent;
	
	public void setRent(Rent rent) {
		this.rent = rent;
	}
	
//	Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), 
//			new Class<?>[] {Foo.class}, 
//			handler);	
	
	//真正生成代理類，得到生成代理對象
	public Object getProxy() {
		return Proxy.newProxyInstance(             //用new生成一個代理對象
				this.getClass().getClassLoader(),  //加載的類在哪個位置
				rent.getClass().getInterfaces(),   //表示要代理的介面是哪一個介面
				this);							   //代表自己的InvocationHandler
	}
	
	//處理代理實例，並返回結果
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//動態代理的本質，就是使用反射機制實現
		seeHouse();   //調用invoke之前去執行seeHouse()處理程序，也會被執行到
		Object result = method.invoke(rent, args);  //用invoke來執行介面上的方法		
		fare();		
		return result;
	}
	//這裡是處理程序，不是真正的代理類
	public void seeHouse() {
		System.out.println("仲介帶看房");
	}
	public void fare() {
		System.out.println("收仲介費");
	}
	
	
	
}
