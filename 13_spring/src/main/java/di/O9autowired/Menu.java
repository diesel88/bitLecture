package di.O9autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Menu {
	
//	@Autowired
//	@Qualifier("h")
	private ISand egg;
	
	public Menu() {
		System.out.println("매개변수 없는 Menu 생성자");
	}
	
//	@Autowired
	public Menu(ISand sand) {
		System.out.println("매개변수 없는 Menu 생성자");
	}
	
	@Autowired
	public void setSand(ISand sand) {
		System.out.println("객체 받는 setSand 메서드");
		sand.info();
	}
	
	public void call() {
		egg.info();
	}
}






