package com.werner.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.werner.pojo.User;

public class UserMapperImpl implements UserMapper{

	//原來的所有的操作，都使用 sqlSession 來執行	
	//現在都改使用 SqlSessionTemplate
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}



	public List<User> selectUser() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.selectUser();
	}
	
}
