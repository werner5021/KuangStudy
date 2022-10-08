import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.pojo.Hello;

public class MyTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Hello hello = context.getBean("hello", Hello.class);
		
		System.out.println(hello.getStr());
		
	}
	
}
