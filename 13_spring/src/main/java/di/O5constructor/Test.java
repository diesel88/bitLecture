package di.O5constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		System.out.println("컨테이너 로딩 시작");
		// test.xml 파일의 내용을 컨테이너가 읽도록 처리
		ApplicationContext container = new ClassPathXmlApplicationContext(
					"di/constructor/test.xml"
				);
		System.out.println("컨테이너 로딩 종료");
		
//		ISand sand = (ISand)container.getBean("ham");
		Menu menu1 = (Menu)container.getBean("menu1", Menu.class);
		Menu menu2 = (Menu)container.getBean("menu2", Menu.class);
		Menu menu3 = (Menu)container.getBean("menu3", Menu.class);
	}
}

