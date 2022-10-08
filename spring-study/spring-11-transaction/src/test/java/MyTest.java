import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.mapper.UserMapper;
import com.werner.pojo.User;

public class MyTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
		
		//執行selectUser()時，UserMapperImpl有add會插入數據
		//但若selectUser()裡的deleteUser有錯時，addUser先插入數據就不符合ACID原則
		List<User> userList = userMapper.selectUser();
				
		for(User user :userList) {
			System.out.println(user);
		}
		
		
		
		
		
		
	}
}
