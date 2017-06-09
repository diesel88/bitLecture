package day10.quiz;

public class Duck extends Animal implements Flyable{

	public Duck(String name) {
		this.name = name;
	}
	

	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println(name+": 꽥꽥 웁니다.");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println(name+": 날개를 퍼덕거리지만 날지 못합니다.");
	}

}
