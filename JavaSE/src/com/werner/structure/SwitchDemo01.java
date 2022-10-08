package com.werner.structure;

public class SwitchDemo01 {
	public static void main(String[] args) {
		//case穿透 (如果沒寫break)
		//switch 匹配一個具體的值
		char grade = 'C';
		
		switch (grade) {
		case 'A':
			System.out.println("優秀");
			break;
		case 'B':
			System.out.println("良好");
			break;
		case 'C':
			System.out.println("及格");
			break;
		case 'D':
			System.out.println("再加油");
			break;
		case 'E':
			System.out.println("掛科");
			break;
		default:
			System.out.println("未知等級");
			break;
		}
		
	}
}
