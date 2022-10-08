package com.werner.lambda;

public class TestLambda2 {

	static class Love2 implements ILove{
		@Override
		public void love(int a) {
			System.out.println("i love you "+a);		
		}	
	}
	
	
	
	public static void main(String[] args) {
		ILove love = new Love();
		love.love(1);
		ILove love2 = new Love2();
		love2.love(2);

		class Love3 implements ILove{
			@Override
			public void love(int a) {
				System.out.println("i love you "+a);		
			}	
		}
		
		ILove love3 = new Love3();
		love3.love(3);

		
		ILove love4 = new ILove() {
			@Override
			public void love(int a) {
				System.out.println("i love you "+a);		
			}
		};
		love4.love(4);
		
		
		ILove love5 = (int a)->{
			System.out.println("i love you "+a);
		};
		love5.love(5);
		
		
		ILove love61 = null;
		ILove love62 = null;
		ILove love63 = null;
		
		//簡化1:去掉參數類型
		love61 = (a)->{
			System.out.println("i love you "+a);
		};
		love61.love(61);
		
		//簡化2:去掉括號
		love62 = a->{
			System.out.println("i love you "+a);
		};
		love62.love(62);
		//多個參數 love62 = (a,b)->{System.out.println("i love you "+a+b);};
		
		
		//簡化3:去掉大括號
		love63 = a -> System.out.println("i love you "+a);
		love63.love(63);

		
		/*總結:
			1. lambda表達式只有一行的時候能去掉大括號，有多行時還是要用代碼塊包裹
			2. 介面必須為函數式介面
			3. 多個參數也可以去除類型，要去除必須全部參數類型一起去除
		*/
		
		
	}
}

interface ILove{
	void love(int a);
}

class Love implements ILove{
	@Override
	public void love(int a) {
		System.out.println("i love you "+a);		
	}	
}