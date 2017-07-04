package di.OBcomponentscan;

import org.springframework.stereotype.Component;

@Component
public class EggSand implements ISand{

	public EggSand() {
		System.out.println("계란 샌드위치 생성자 호출");
	}
	@Override
	public void info() {
		System.out.println("계란 샌드위치 정보 입니다.");
	}

}
