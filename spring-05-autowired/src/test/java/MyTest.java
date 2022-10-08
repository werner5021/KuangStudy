import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.pojo.People;

public class MyTest {
//	@Test
//	public void test1() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		People people = context.getBean("people", People.class);
//		people.getDog().shout();
//		people.getCat().shout();
//	}
	@Test
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans_autowired.xml");
		People people = context.getBean("people", People.class);
		people.getDog().shout();
		people.getCat().shout();
	}	
	
}
