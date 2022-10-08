package com.werner.structure;

public class LabelDemo {
	public static void main(String[] args) {
		//列出101-150之間所有質數
		
		int count = 0;
		
		//不建議使用
		outer:for(int i=101; i<150;i++) {
			for(int j=2;j<i/2;j++) {
				if(i % j == 0) {
					continue outer;
				}
			}
			System.out.print(i+" ");
		}
		
		
		
	}
}
