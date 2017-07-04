package di.O8multi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		System.out.println("컨테이너 로딩 시작");
		// test.xml 파일의 내용을 컨테이너가 읽도록 처리
		ApplicationContext container = new ClassPathXmlApplicationContext(
//					new String[] {"di/multi/test.xml", "di/multi/test2.xml"}
				"di/multi/test3.xml"
				);
		System.out.println("컨테이너 로딩 종료");
	}
}

