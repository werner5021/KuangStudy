package com.werner.demo01;

public class Proxy implements Rent{

	private Host host;
	
	public Proxy() {}
	
	public Proxy(Host host) {
		this.host = host;
	}
	
	public void rent() {
		host.rent();
		seeHouse();
		
	}


	public void seeHouse() {
		System.out.println("帶看");
	}
	
}
