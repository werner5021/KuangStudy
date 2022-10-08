package com.oop.demo06;

//多態
public class Application {
	public static void main(String[] args) {
		
		
		//一個物件的實際對象(實體化)是確定的
		//new Student();
		//new Person();
		
		//可是指向的引用類型就不確定了: 父類的引用指向子類		
		
		//Student 能呼叫的方法，都是自己的或繼承父類的
		Student s1 = new Student();
		//Person 父類型，可以指向子類，但是不能呼叫子類獨有的方法
		Person s2 = new Student();
		Object s3 = new Student();
		
		
		s2.run();  //子類重寫了父類的方法，執行子類方法
		s1.run();
		
		//物件能執行些方法，主要看物件左邊的類型，和右邊關係不大
		s1.eat();
		((Student) s2).eat();  
		
		System.out.println("===============");
		
		
		//System.out.println(X instanceof Y);  
		//能不能編譯通過，取決於X與Y之間是否存在父子關係。
		//X是物件，Y是類，當物件是Y的類或子類所創建的物件時，回傳true，否則false
		
		//Object > String
		//Object > Person > Teacher
		//Object > Person > Student
		Object object = new Student();
		System.out.println(object instanceof Student);
		System.out.println(object instanceof Person);		
		System.out.println(object instanceof Object);		
		System.out.println(object instanceof Teacher);
		System.out.println(object instanceof String);
		
		System.out.println("===============");
		
		Person person = new Student();
		System.out.println(person instanceof Student);
		System.out.println(person instanceof Person);		
		System.out.println(person instanceof Object);		
		System.out.println(person instanceof Teacher);
		//System.out.println(person instanceof String);  //編譯報錯
		
		System.out.println("===============");
		
		Student student = new Student();
		System.out.println(student instanceof Student);
		System.out.println(student instanceof Person);		
		System.out.println(student instanceof Object);		
		//System.out.println(student instanceof Teacher); //編譯報錯
		//System.out.println(student instanceof String);  //編譯報錯
		
		System.out.println("===============");
		
		//類型之間的轉換: 父 子
		
		//高                     低       → 低轉高不用強轉，直接轉
		Person obj = new Student();
		//obj.go();  //Person類裡面沒有go方法
		
		//將obj物件轉換為Student類型，就能使用Student類型裡的方法
		Student student1 = (Student) obj;  
		student1.go();        //也能這樣寫((Student)obj).go();
		
		System.out.println("===============");
		
		//子類轉換為父類，可能丟失自己本來的一些方法
		Student student2 = new Student();
		student2.go();
		Person person2 = student2;    //student2對Person類低轉高直接轉
		//person2.go();               //student2被轉成Person也無法用Student類獨有的go方法
		
	}
}

/*
多態注意事項:
1. 多態是方法的多態，屬性沒有多態
2. 父類和子類，必須有關係(繼承關係)才能轉換，不然會類型轉換異常 ClassCastException
3. 存在條件: 繼承關係，方法要重寫，父類引用指向子類物件 Father f1 = new Son();

不能被重寫的方法:
1. static 方法，屬於類，不屬於實例
2. final 常量
3. private 方法
*/

/*
 
 1. 父類引用指向子類對象
 2. 子類轉換為父類(向上轉型)，可直接轉，但可能會丟失方法
 3. 父類轉換為子類(向下轉型)，要強制轉換
 4. 方便方法的呼叫，不用重新new一個類，減少重複的代碼
 
 
 */