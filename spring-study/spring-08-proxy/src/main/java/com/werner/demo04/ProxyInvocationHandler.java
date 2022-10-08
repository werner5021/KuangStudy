package com.werner.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//我們會用這個類，自動生成代理
public class ProxyInvocationHandler implements InvocationHandler{
	//Proxy 生成動態代理實例
	//InvocationHandler 調用處裡程序，並返回結果
	
	//被代理的介面(代理誰)
	private Object target;
	
	public void setTarget(Object target) {
		this.target = target;
	}

	// 生成得到代理對象
	public Object getProxy() {
		return Proxy.newProxyInstance(this.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
	
	//處理代理實例，並返回結果(要被代理的人)
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		log("add");  //寫死的方法
		log(method.getName());  //萬能的反射，通過反射對象得到名字
		//動態代理的本質，就是使用反射機制實現
		Object result = method.invoke(target, args);  //用invoke來執行方法
		return result;
	}
	
	public void log(String msg) {
		System.out.println("執行了"+msg+"方法");
	}
	
	
}
