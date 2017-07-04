package di.O5constructor;

public class Menu {
	public Menu() {
		System.out.println("매개변수 없는 Menu 생성자");
	}
	public Menu(String desc) {
		System.out.println("문자열 생성자 Menu 생성자");
		System.out.println("넘어온 값 : " + desc);
	}
	public Menu(ISand sand) {
		System.out.println("객체 받는 Menu 생성자");
		sand.info();
	}
}
