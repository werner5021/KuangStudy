import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.mapper.UserMapper;
import com.werner.pojo.User;


public class MyTest {

//	@Test
//	public void test() throws IOException {
//		String resources = "mybatis-config.xml";
//		InputStream in= Resources.getResourceAsStream(resources);		
//		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
//		SqlSession sqlSession = sessionFactory.openSession(true);
//		
//		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//		List<User> userList = mapper.selectUser();
//		
//		for(User user :userList) {
//			System.out.println(user);
//		}
//	}
	
	@Test
	public void test2() throws IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		
		UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
		for(User user :userMapper.selectUser()) {
			System.out.println(user);
		}
		
		
		
	}
	
	
	
	
	
}
