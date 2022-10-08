package com.werner.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//統計網站在線人數: 統計session
public class OnlineCountListener implements HttpSessionListener{

	//創建session監聽: 看你的一舉一動
	//一旦創建一個session，就會觸發一次這個事件
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//HttpSessionEvent 代表session事件的監聽對象
		ServletContext ctx = se.getSession().getServletContext(); //拿到session後可以拿到網站的上下文，這裡提高到最高作用域，讓所有人都能訪問
		
		System.out.println(se.getSession().getId());
		
		Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount"); //先獲取"OnlineCount"這個對象
		
		if(onlineCount == null) {
			onlineCount = new Integer(1);
		}else {
			int count = onlineCount.intValue();  //把Integer轉成int
			onlineCount = new Integer(count+1); 
		}		
		ctx.setAttribute("OnlineCount", onlineCount);
	}

	//銷毀session監聽
	//一旦銷毀一個session，就會觸發一次這個事件
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext(); //拿到session後可以拿到網站的上下文，這裡提高到最高作用域，讓所有人都能訪問
				
		Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
		
		if(onlineCount == null) {
			onlineCount = new Integer(0);
		}else {
			int count = onlineCount.intValue();
			onlineCount = new Integer(count-1); 
		}
		ctx.setAttribute("OnlineCount", onlineCount);
	}	
	/*
	 * Session 銷毀:
	 * 1. 手動銷毀   se.getSession().invalidate();  //手動銷毀，關閉瀏覽器時銷毀
	 * 2. 自動銷毀   到web.xml中配置session過期時間 <session-config>
	 */	
}
