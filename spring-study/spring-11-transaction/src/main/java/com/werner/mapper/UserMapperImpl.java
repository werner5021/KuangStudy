package com.werner.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.werner.pojo.User;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{
	
	public List<User> selectUser() {
		
		User user = new User(5, "Jennie", "jnjn");
				
		UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
		
		mapper.addUser(user);
		mapper.deleteUser(5);
		
		return mapper.selectUser();
	}

	public int addUser(User user) {
		return getSqlSession().getMapper(UserMapper.class).addUser(user);
	}

	public int deleteUser(int id) {
		return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
	}
	
}
