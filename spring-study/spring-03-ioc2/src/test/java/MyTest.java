import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.pojo.User;
import com.werner.pojo.UserT;

public class MyTest {
	public static void main(String[] args) {
		
		//Spring容器，裡面的所有Bean，在一註冊進來時，就全部被Spring實體化，要用的時候get就可以
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		User user = (User)context.getBean("user");
		user.show();
		
		User user1 = (User)context.getBean("user1");
		user1.show();
		
		User user2 = (User)context.getBean("user2");
		user2.show();
		
		User user3 = (User)context.getBean("user3");
		user3.show();		
		
		User userT = (User)context.getBean("user");
		System.out.println(user==userT);  //true，代表記憶體中只有一份實例
		
		System.out.println("======================");
		
		//別名 alias
		User user4 = (User)context.getBean("user");
		User user4new = (User)context.getBean("userNew");
		user.show();
		user4new.show();
		
		System.out.println("======================");
		
		//別名 name
		UserT userT1 = (UserT)context.getBean("userT");
		userT1.show();
		UserT userT2 = (UserT)context.getBean("u2");
		userT2.show();		
		
		System.out.println("======================");
		
		ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserT userT3 = (UserT)context1.getBean("u5");
		userT3.show();
	} 
}
