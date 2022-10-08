package com.werner.listener;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
	public static void main(String[] args) {
		Frame frame = new Frame("中秋節快樂"); //新建一個窗體
		Panel panel = new Panel();  //面板
		frame.setLayout(null);  //設置窗體布局
		
		frame.setBounds(300,300,500,500);
		frame.setBackground(new Color(255,255,255));  //設置背景顏色
		
		panel.setBounds(50,50,300,300);
		panel.setBackground(new Color(150,150,150));  //設置背景顏色
		
		frame.add(panel);
		
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("打開");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("關閉ing");
				System.out.println(0);
			}
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("關閉ed");
			}
			@Override
			public void windowIconified(WindowEvent e) {				
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("激活");
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println("未激活");
			}			
		});
		
//		frame.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				super.windowClosing(e);
//			}
//		});
		
	}
}
