package aop.O4schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext container = new ClassPathXmlApplicationContext(
				"aop/schema/test.xml"
			);
		// class $proxy implements Controller -> BoardController
		// class $proxy extends BoardController -> BoardController
		// 실제 구현 클래스 형태(BoardController)로 aop:config 태그에 
		// 속성을 추가 해야 한다.(proxy-target-class="true")
//		Controller controller = container.getBean("board", Controller.class);
		Controller controller = container.getBean("board", BoardController.class);
		controller.service();
		
		controller = container.getBean("member", Controller.class);
		controller.service();
		
		
	}
}
