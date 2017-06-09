package day10.quiz;

public class Dog extends Animal{
	
	public Dog(String name) {
		this.name = name;
	}

	

	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println(name+": 멍멍 짖습니다.");
	}
	
	
}
