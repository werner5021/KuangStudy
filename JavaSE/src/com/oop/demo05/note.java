package com.oop.demo05;

public class note {


}
/*
super 注意點:
	1. super 呼叫父類的構造方法，必須在構造方法的第一行
	2. super 必須只能出現在子類的方法或者構造方法中
	3. super 和 this 不能同時呼叫構造方法

vs this:
	代表的對象不同
		this : 本身呼叫的物件
		super: 代表父類物件的引用
	前提
		this : 沒有繼承也可以使用
		super: 只能在繼承條件才可以使用
	構造方法
		this() : 本類的構造
		super(): 父類的構造
		
			
		
重寫: 需要有繼承關係，子類重寫父類的方法
	1. 方法名必須相同
	2. 參數列表必須相同
	3. 修飾詞: 範圍可以擴大，不能縮小  public > protected > default > private
	4. 拋出的異常: 範圍可以被縮小，但不能擴大   ClassNotFoundException(小) --> Exception(大)

重寫，子類的方法必須和父類的一致，方法體不同

為什麼需要重寫?
	父類的功能，子類不一定需要or滿足

*/