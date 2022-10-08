import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.werner.config.MyConfig;
import com.werner.pojo.User;

//通過純註解實現
public class MyTest {
	public static void main(String[] args) {
		//如果完全使用配置類的方式去做，我們就只能通過 AnnotationConfig 上下文來獲取容器，通過配置類的 class對象加載
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		User getUser = context.getBean("getUser", User.class);
//		User getUser = context.getBean("user", User.class);  //在User裡設置的方法為getUser，所以用user會找不到
		System.out.println(getUser.getName());
	}
	
}
