package com.werner.state;

//測試守護線程
//上帝守護你
public class TestDeamon {
	public static void main(String[] args) {
		God god = new God();
		You you = new You();
		
		Thread thread = new Thread(god);
		thread.setDaemon(true);  //莫認為false，表示為用戶線程，正常的線程都是用戶線程
		thread.start();  //上帝 守護線程啟動
		
		 new Thread(you).start();  //你 用戶線程啟動
		
	}
}

//上帝
class God implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("上帝保佑著你");
		}
	}	
}

//你
class You implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<36500;i++) {
			System.out.println("你開心的活著");
		}
		System.out.println("=== 離開這世界 ===");
	}
	
}