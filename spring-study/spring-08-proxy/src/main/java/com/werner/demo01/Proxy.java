package com.werner.demo01;

public class Proxy implements Rent{
	
	private Host host;  //用繼承只能拿一個類，所以用組合的方式拿房東類進來

	public Proxy() {
	}
	public Proxy(Host host) {
		this.host = host;
	}
	
	public void rent() {
		seeHouse();
		
		//代理房東出租房子
		host.rent();
		
		contract();
		fare();
	}
	
	//看房
	public void seeHouse() {
		System.out.println("仲介帶房客看房");
	}
	//簽契約
	public void contract() {
		System.out.println("簽租賃契約");
	}
	
	//收仲介費
	public void fare() {
		System.out.println("收仲介費");
	}
	
	
}
