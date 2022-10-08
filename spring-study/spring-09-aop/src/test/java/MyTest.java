import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.service.UserService;

public class MyTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//動態代理的是介面，所以下面這樣寫會錯
		//UserServiceImpl userService= context.getBean("userService", UserServiceImpl.class);
		UserService userService= context.getBean("userService", UserService.class);

		userService.select();		
	}
}
