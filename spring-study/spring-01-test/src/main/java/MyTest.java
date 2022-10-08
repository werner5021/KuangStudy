import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.service.UserServiceImpl;

public class MyTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		UserServiceImpl userServiceImpl = context.getBean("UserService", UserServiceImpl.class);
		userServiceImpl.getUser();
	}
}