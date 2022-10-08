import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.pojo.Student;
import com.werner.pojo.User;

public class MyTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student yeQiu = context.getBean("student", Student.class);
		System.out.println(yeQiu.toString());
		
		
		ApplicationContext context1 = new ClassPathXmlApplicationContext("userbeans.xml");

//		User jisoo = context1.getBean("user_p", User.class);
//		System.out.println(jisoo.getAge());
		
		User suzy = context1.getBean("user_c", User.class);
		System.out.println(suzy.toString());
		User someone = context1.getBean("user_p", User.class);
		System.out.println(someone.toString());
	}
	
	
}
