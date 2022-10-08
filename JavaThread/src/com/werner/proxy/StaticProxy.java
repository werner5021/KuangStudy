package com.werner.proxy;

/*
  靜態代理模式總結
  真實對象和代理對象都要實現同一個介面
  代理對象要代理真實角色 

 優點:
 	代理物件可以做很多真實物件做不了的事情
 	真實物件專注做自己的事情
*/

public class StaticProxy {
	public static void main(String[] args) {
		You you = new You();  //你要結婚
		
		/*
		   比較一下線程與靜態代理: 
		   Runnable介面 和 Thread類代理 都有 run()方法，最後呼叫的是 Thread 裡面的 start()方法，但實際執行的還是 Runnable 中的 run()方法 的方法體
		   Marry介面 和 WeddingCompany類代理 都有 HappyMarry()方法，最後呼叫的是 WeddingCompany 裡面的 HappyMarry()方法，但實際執行的還是 Marry 中的 HappyMarry() 方法的方法體  
		 */
		
		//Thread類代理Runnable介面(真實物件)，再呼叫start()方法
		new Thread( ()->System.out.println("lamda表達式")).start();
		//HappyMarry()就是Marry介面裡的，start()
		new WeddingCompany(new You()).HappyMarry();
		
		
		/*可以簡化成上面那行
		WeddingCompany weddingCompany = new WeddingCompany(you);  //把你丟給婚慶公司
		weddingCompany.HappyMarry();
		*/
	
	}
}

interface Marry{
	void HappyMarry();
}

//真實角色，你去結婚
class You implements Marry{

	@Override
	public void HappyMarry() {
		System.out.println("你要結婚");
		
	}	
}

//代理角色，幫助你結婚
class WeddingCompany implements Marry{
	
	//代理誰? --> 真實目標角色
	private Marry target;
	
	public WeddingCompany(Marry target) {
		this.target = target;
	}


	@Override
	public void HappyMarry() {
		
		before();
		this.target.HappyMarry();  //真實對象
		after();
		
	}

	private void before() {
		System.out.println("結婚之前布置現場");		
	}
		
	private void after() {
		System.out.println("結婚之後收尾款");		
	}


	
	
	
	
}
