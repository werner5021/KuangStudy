package com.werner.lambda;

/*
 * 推導 lambda 表達式
 */
public class TestLambda {
	
	//4.靜態內部類(類在外面很麻煩)
	static class Like2 implements ILike{
		@Override
		public void lambda() {
			System.out.println("i like lambda2");		
		}	
	}
	
	
	//3.寫main方法，創建物件
	public static void main(String[] args) {
		ILike like = new Like();  //3.
		like.lambda();
		
		like = new Like2();  //4.
		like.lambda();
		
		//5.局部內部類(放靜態內部類還是會繁瑣)
		class Like3 implements ILike {
			@Override
			public void lambda() {
				System.out.println("i like lambda3");
			}
		}
		
		like = new Like3();  //5.
		like.lambda();
		
		//6.匿名內部類，沒有類的名稱，必須借助介面或者父類
		like = new ILike() {
			@Override
			public void lambda() {
				System.out.println("i like lambda4");
			}			
		};
		like.lambda();
		
		//7.用lambda簡化，去除介面、方法名稱
		//  介面只有一個類，且也只有一個方法，都是固定寫法可以省略
		like = () -> {
			System.out.println("i like lambda5");
		};
		like.lambda();
		
		
	}
}

//1.定義一個函數式介面
interface ILike{
	void lambda();
}

//2.實現類
class Like implements ILike{
	@Override
	public void lambda() {
		System.out.println("i like lambda");		
	}	
}
