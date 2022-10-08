import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.werner.config.MyConfig;
import com.werner.pojo.User;

public class MyTest {
	public static void main(String[] args) {
	
		ApplicationContext context =  new AnnotationConfigApplicationContext(MyConfig.class);
		User user= context.getBean("getUser", User.class);
		System.out.println(user.getName());
	}
}
