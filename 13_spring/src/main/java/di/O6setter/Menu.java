package di.O6setter;

public class Menu {
	
	public Menu() {
		System.out.println("매개변수 없는 Menu 생성자");
	}
	public void setDesc(String desc) {
		System.out.println("문자열 받는 setDesc 메서드");
		System.out.println("넘어온 값 : " + desc);
	}
	public void setSand(ISand sand) {
		System.out.println("객체 받는 setSand 메서드");
		sand.info();
	}
}






