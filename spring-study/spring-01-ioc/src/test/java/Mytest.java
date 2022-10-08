import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.werner.dao.UserDaoOracleImpl;
import com.werner.service.UserService;
import com.werner.service.UserServiceImpl;

public class Mytest {
//	public static void main(String[] args) {		
//		//用戶實際調用業務層，他們不需要接觸Dao層
//		UserService userService = new UserServiceImpl();
//		((UserServiceImpl)userService).setUserDao(new UserDaoOracleImpl());		
//		userService.getUser();	
//	}
	public static void main(String[] args) {
		
		//獲取ApplicationContext: 拿到Spring的容器
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//需要什麼，就直接get
		UserServiceImpl userServiceImpl= (UserServiceImpl)context.getBean("UserServiceImpl");
		userServiceImpl.getUser();
	}
}
