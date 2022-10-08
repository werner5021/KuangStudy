package com.oop.demo08;

//abstract 抽象類
public abstract class Action {
	
	//約束，有人幫忙實現即可
	//abstract 抽象方法，只有方法名字，沒有方法的實現
	public abstract void doSomething(); 
	
	//1.不能new抽象類，只能靠子類實現: 約束
	//2.抽象類中可以寫普通方法
	//3.抽象方法必須存在抽象類中
	
}
