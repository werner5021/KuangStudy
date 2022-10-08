import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.pojo.Student;
import com.werner.pojo.User;

public class MyTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student studwnt = (Student)context.getBean("student");
//		String name = studwnt.getName();
//		System.out.println(studwnt.getName());
		
		System.out.println(studwnt.toString());
		
		/* 
		 * Student [
		 * 		name=亞特魯, 
		 * 		address=Address [address=伊蘇國], 
		 * 		books=[菲爾佳娜之誓, 怪人之夜, 丹娜的殞泣日, 賽爾賽塔的樹海], 
		 * 		hobbies=[冒險, 打怪, 升級], 
		 * 		card={
		 * 			模式一=火劍, 
		 * 			模式二=風劍, 
		 * 			模式三=雷劍
		 * 		}, 
		 * 		games=[破解謎題, 打聽消息, 尋找寶藏], 
		 * 		info={
		 * 			特徵=紅髮, 
		 * 			職業=戰士, 
		 * 			等級=60
		 * 		}, 
		 * 		wife=null
		 * ]
		 */
	}

	
	@Test
	public void test_p() {
		ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
		User user = context.getBean("user_p", User.class);  //在第二個參數使用反射的實例定義類別
		System.out.println(user);		
	}
	@Test
	public void test_c() {
		ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
		User user = context.getBean("user_c", User.class);  //在第二個參數使用反射的實例定義類別
		System.out.println(user);		
	}
	
}
