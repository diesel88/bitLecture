package di.OAresource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

public class Menu {
	
//	@Resource(name="ham")	// 이름 검색 주입
	@Resource				// 타입 검색 주입
	@Qualifier("h")
	private ISand sand;
	
	public Menu() {
		System.out.println("매개변수 없는 Menu 생성자");
	}
//	@Resource(name="ham")	// 생성자 사용 불가능
	public Menu(ISand sand) {
		System.out.println("매개변수 있는 Menu 생성자");
	}
	
//	@Resource(name="ham")
	public void setSand(ISand sand) {
		System.out.println("객체 받는 setSand 메서드");
		sand.info();
	}
	
	public void call() {
		sand.info();
	}
}






