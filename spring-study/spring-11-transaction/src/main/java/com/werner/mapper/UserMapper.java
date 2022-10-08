package com.werner.mapper;

import java.util.List;

import com.werner.pojo.User;

public interface UserMapper {
	public List<User> selectUser();
	
	//增加一個用戶
	public int addUser(User user);
	
	//刪除一個用戶
	public int deleteUser(int id);
}
