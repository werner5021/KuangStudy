import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.pojo.User;


public class MyTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = context.getBean("user", User.class);  //雖然xml裡沒有給id名字，但Component默認為類的名字小寫
		
		System.out.println(user.name);
	}
}
