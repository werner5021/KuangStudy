import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.pojo.User;

public class MyTest {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		User user = context.getBean("user", User.class);
//		user.show();
//		
//		User user1 = context.getBean("user1", User.class);
//		user1.show();
//		
//		User user2 = context.getBean("user2", User.class);
//		user2.show();
//		User user3 = context.getBean("user3", User.class);
//		user3.show();
		
		ApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user5 = context.getBean("user3", User.class);
		user5.show();
	}
}
