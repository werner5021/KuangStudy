package com.werner.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.werner.pojo.User;
import com.werner.utils.JsonUtils;

@Controller        //走視圖解析器
//@RestController  //@RestController標註的類的底下的所有方法，只會返回字符串
public class UserController {

	//produces:指定响应体返回类型和编码
	//	@RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")	//原生態的解決方式，但SpringMVC不會這樣做
	@RequestMapping(value = "/j1")	
	@ResponseBody  //只要註解為@ResponseBody，就不會走視圖解析器，會直接返回一個字符串，配合@Controller使用
	public String json1() throws JsonProcessingException {

		//jackson包，裡面的ObjectMapper對象
		//创建一个jackson的对象映射器，用来解析数据
		ObjectMapper mapper = new ObjectMapper(); 

		//創建一個對象
		User user = new User("金智秀",27,"女");

		//将我们的对象解析成为json格式
		String str = mapper.writeValueAsString(user);

		//		return user.toString(); //如果沒有mapper轉的時候直接toString

		//由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
		return str;
	}

	@RequestMapping(value = "/j2")
	@ResponseBody
	public String json2() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper(); 

		List<User> userList = new ArrayList<User>();
		User user1 = new User("金智秀1",27,"女");
		User user2 = new User("金智秀2",27,"女");
		User user3 = new User("金智秀3",27,"女");
		User user4 = new User("金智秀4",27,"女");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);

		String str = mapper.writeValueAsString(userList);

		return str;  
		//更精簡為return new ObjectMapper().writeValueAsString(userList)
	}

	//套用我們自己寫好的工具
	@RequestMapping(value = "/j2_1")
	@ResponseBody
	public String json2_1() throws JsonProcessingException {

		List<User> userList = new ArrayList<User>();
		User user1 = new User("金智秀1",27,"女");
		User user2 = new User("金智秀2",27,"女");
		User user3 = new User("金智秀3",27,"女");
		User user4 = new User("金智秀4",27,"女");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);

		return JsonUtils.getJson(userList);  
	}

	@RequestMapping("/j3")
	@ResponseBody
	public String json3() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		//创建时间一个对象，java.util.Date
		Date date = new Date();
		//将我们的对象解析成为json格式
		//ObjectMapper，時間解析後的格式莫認為時間戳: Timestamp
		String str = mapper.writeValueAsString(date);
		return str;
	}

	@RequestMapping("/j4")
	@ResponseBody
	public String json4() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		//不使用時間戳的方式
		mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
		//自定義日期格式對象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//指定日期格式
		mapper.setDateFormat(sdf);

		Date date = new Date();
		String str = mapper.writeValueAsString(date);

		return str; 

		/* Java原生的寫法也可以 
		 * Date date = new Date();
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * return mapper.writeValueAsString(sdf.format(date));
		 */		
	}

	@RequestMapping("/j5")
	@ResponseBody
	public String json5() {		
		Date date= new Date();
		String json = JsonUtils.getJson(date);
		return json;
	}

	@RequestMapping("/j6")
	@ResponseBody
	public String json6() {		
		List<User> userList = new ArrayList<User>();
		User user1 = new User("全汝彬1",32,"女");
		User user2 = new User("全汝彬2",32,"女");
		User user3 = new User("全汝彬3",32,"女");
		User user4 = new User("全汝彬4",32,"女");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);

		System.out.println("*******Java对象 转 JSON字符串*******");
		String str1 = JSON.toJSONString(userList);
		System.out.println("JSON.toJSONString(list)==>"+str1);
		String str2 = JSON.toJSONString(user1);
		System.out.println("JSON.toJSONString(user1)==>"+str2);

		System.out.println("\n****** JSON字符串 转 Java对象*******");
		User jp_user1=JSON.parseObject(str2,User.class);
		System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

		System.out.println("\n****** Java对象 转 JSON对象 ******");
		JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
		System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

		System.out.println("\n****** JSON对象 转 Java对象 ******");
		User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
		System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

		String string = JSON.toJSONString(userList);
		return string;
	}

}