package com.werner.syn;

//不安全的領錢
//兩個人去銀行領錢
public class UnsafeBank {
	
	public static void main(String[] args) {
		//帳戶
		Account account = new Account(1000,"結婚基金");
		
		Drawing you = new Drawing(account, 50, "你");
		Drawing girlFriend = new Drawing(account, 100, "女友");
		
		you.start();
		girlFriend.start();
	}	
}

//帳戶
class Account{
	int money; //餘額
	String cardName; //卡名
	
	public Account(int money,String name) {
		this.money = money;
		this.cardName = name;
	}	
}

//銀行:模擬取款
class Drawing extends Thread{
	  
	Account account;  //帳戶
	//領了多少錢
	int drawingMoney;
	//現在手上有多少錢
	int nowMoney;
	
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	//領錢的操作
	@Override	
//	public synchronized void run() {  //synchronized默認鎖方法的this，而這裡的this是Drawing，不是我們要操作的對象，鎖這裡沒用
	public void run() {
		//鎖的對象，就是變化的量，需要增刪改的
		synchronized (account) {  //synchronized同步塊，鎖要進行增刪改的對象
			//判斷有沒有錢
			if(account.money - drawingMoney<0) {
				System.out.println(Thread.currentThread().getName()+"錢不夠");
				return;
			}
			//sleep可以放大問題的發生性
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//卡內餘額 = 餘額-你領的錢
			account.money -= drawingMoney;
			//手上的錢
			nowMoney += drawingMoney;
			
			System.out.println(account.cardName+"餘額為: "+account.money);
			//Thread.currentThread().getName() = this.getName()
			System.out.println(this.getName()+"手裡的錢:"+nowMoney);
			
		}
		
		
	}
	
	
	
	
	
}