package com.werner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//如果使用 @RestController，則該類不會被視圖解析，而會返回一個字符串
@Controller  // 自動被Spring掃描+裝配
@RequestMapping("/HelloController")  //在類上寫 @RequestMapping，則底下所有方法的RequestMapping都要先寫類的RequestMapping
public class HelloController {

	//真实访问地址 : 项目名/HelloController/hello
	@RequestMapping("/hello")  //URL請求過來
	public String hello(Model model) {
		//封裝數據 → 向模型中添加属性msg与值，可以在JSP页面中取出并渲染
		model.addAttribute("msg","Hello, SpringMVC Annotation");
		//web-inf/jsp/hello.jsp
		return "hello";  //會被視圖解析器處理，用來拼接
	}	
}
