package di.OBcomponentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {
	
	@Autowired
	private ISand ham;
	
	public Menu() {
		System.out.println("매개변수 없는 Menu 생성자");
	}
	
	public void call() {
		ham.info();
	}
}






