package com.werner.syn;

//死鎖:多個線程互相抱著對方需要的資源，形成僵持
public class DeadLock {
	public static void main(String[] args) {
		Makeup g1 = new Makeup(0,"IU");
		Makeup g2 = new Makeup(1,"Jisoo");
		
		g1.start();
		g2.start();
	}
}

//口紅
class Lipstick{	
}

//鏡子
class Mirror{	
}

class Makeup extends Thread{

	//需要的資源只有一份，用static來保證只有一份
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	
	int choice;  //選擇
	String girlName;  //使用化妝品的人
	
	public Makeup(int choice, String girlName) {
		this.choice = choice;
		this.girlName = girlName;
	}	
	
	@Override
	public void run() {
		//化妝
		try {
			makeup();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//化妝，互相持有對方的鎖，也就是需要拿到對方的資源
	private void makeup() throws InterruptedException {
		if(choice==0) {
			synchronized(lipstick) {  //獲得口紅的鎖
				System.out.println(this.girlName+"獲得口紅的鎖");
				Thread.sleep(1000);				
				}
			//如果這裡拿鏡子的鎖放在拿口紅的鎖裡面，則形成死鎖
			synchronized(mirror) {  //一秒後獲得鏡子
				System.out.println(this.girlName+"獲得鏡子的鎖");
			}
		}else {
			synchronized(mirror) {  //獲得鏡子的鎖
				System.out.println(this.girlName+"獲得鏡子的鎖");
				Thread.sleep(2000);				
			}
			synchronized(lipstick) {  //一秒後獲得口紅
				System.out.println(this.girlName+"獲得口紅的鎖");
			}
		}
	}
	
}