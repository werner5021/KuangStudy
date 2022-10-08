import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.pojo.People;

public class MyTest {
	public static void main(String[] args) {
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		People hani = context.getBean("people", People.class);
//		hani.getDog().shout();
//		People lisa = context.getBean("people2", People.class);
//		lisa.getCat().shout();
		
		System.out.println("====================");
		
		ApplicationContext context_anno = new ClassPathXmlApplicationContext("beans_autowired.xml");
		People rose = context_anno.getBean("people", People.class);
		rose.getDog().shout();
		
	}
}
