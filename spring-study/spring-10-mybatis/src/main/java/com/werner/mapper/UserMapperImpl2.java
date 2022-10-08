package com.werner.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.werner.pojo.User;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{

	public List<User> selectUser() {
//		SqlSession sqlSession = getSqlSession();
//		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//		return mapper.selectUser();
		
		//上面可以簡化成一句
		return getSqlSession().getMapper(UserMapper.class).selectUser();

	}
	
	 
	
	
}
