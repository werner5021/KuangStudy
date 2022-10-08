import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.pojo.Hello;

public class MyTest {
	public static void main(String[] args) {
		//用xml加載必須使用new ClassPathXmlApplicationContext(一個或多個配置文件的地址)
		//獲取Spring 的上下文對象
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//我們的對象都在Spring中管理，要使用對象直接去spring中取出來就可以了
		Hello hello = (Hello) context.getBean("hello");
		System.out.println(hello.toString());
	}
}
