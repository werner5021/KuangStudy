package com.werner.advanced;

//測試生產者消費者模型-->利用緩衝區解決: 管程法
//生產者 ，消費者，產品，緩衝區
public class TestPC {
	
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		
		new Productor(container).start();
		new Consumer(container).start();		
	}
}

//生產者
class Productor extends Thread{
	SynContainer container;
	
	public Productor(SynContainer container) {
		this.container = container;
	}	
	
	//生產方法
	@Override
	public void run() {
		for(int i=0; i<100; i++) {			
			container.push(new Chicken(i));
			System.out.println("生產了"+i+"隻雞");	
		}
	}
}

//消費者
class Consumer extends Thread{
	SynContainer container;

	public Consumer(SynContainer container) {
		this.container = container;
	}	
	//消費方法
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("消費了" + container.pop().id + "隻雞");
		}
	}	
	
}

//產品
class Chicken {
	int id;  //產品編號

	public Chicken(int id) {
		super();
		this.id = id;
	}	
}

//緩衝區
class SynContainer{
	
	//需要一個容器大小
	Chicken[] chickens = new Chicken[10];
	//容器計數器
	int count = 0;
	
	//生產者放入產品
	public synchronized void push(Chicken chicken) {
		//如果容器滿了，就等待消費者消費
		while(count==chickens.length) {
			//通知消費者消費，生產等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		//如果沒有滿，我們要丟入產品
		chickens[count] = chicken;
		count++;
		
		//可以通知消費主消費了
		this.notifyAll();
	}	
	
	//消費者消費產品
	public synchronized Chicken pop() {
		//判斷能否消費
		while(count==0) {
			//不能消費時(實際數量為0)，等待生產者生產，消費者等待			
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//如果可以消費
		count--;
		Chicken chicken = chickens[count];
		this.notifyAll();
		
		//通知生產者生產
		return chicken;
	}	
}