package di.O5constructor;

public class HamSand implements ISand{

	public HamSand() {
		System.out.println("햄 샌드위치 생성자 호출");
	}
	@Override
	public void info() {
		System.out.println("햄 샌드위치 정보 입니다.");
	}

}
