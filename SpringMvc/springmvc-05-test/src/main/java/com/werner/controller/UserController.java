package com.werner.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.werner.pojo.User;
import com.werner.utils.JsonUtils;

@Controller
public class UserController {
	
	@RequestMapping(value="/j1", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String json1() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		User user = new User("李知恩",29,"女");
		String str = mapper.writeValueAsString(user);
		return str;
	}
	
	@RequestMapping(value="/j2", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String json2() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		List<User> userList = new ArrayList<User>();
		
		User user1 = new User("汝彬1", 32, "女");
		User user2 = new User("汝彬2", 32, "女");
		User user3 = new User("汝彬3", 32, "女");
		User user4 = new User("汝彬4", 32, "女");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		String str = mapper.writeValueAsString(userList);
		return str;
	}
	
	@RequestMapping("/j3")
	@ResponseBody
	public String json3() throws JsonProcessingException {
	
		ObjectMapper mapper = new ObjectMapper();
		Date date = new Date();
		String str = mapper.writeValueAsString(date);
		return str;
	}
	
	@RequestMapping("/j4")
	@ResponseBody
	public String json4() throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return mapper.writeValueAsString(sdf.format(date));
	}
	
		
	@RequestMapping("/j5")
	@ResponseBody
	public String json5() {
		Date date = new Date();
		String dateStr= JsonUtils.getJson(date);
		return dateStr;
	}
	
	
	
}
