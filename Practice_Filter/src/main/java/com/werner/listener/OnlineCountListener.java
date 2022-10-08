package com.werner.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class OnlineCountListener implements HttpSessionListener{


	public void sessionCreated(HttpSessionEvent se) {
		ServletContext ctx = se.getSession().getServletContext();
		Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
		
		if(onlineCount == null) {
			onlineCount = new Integer(1);
		}else {
			int count = onlineCount.intValue();
			onlineCount = new Integer(count+1);
		}		
		ctx.setAttribute("OnlineCount", onlineCount);
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		
	}	
	
}
