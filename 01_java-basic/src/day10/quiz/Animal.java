package day10.quiz;

public abstract class Animal {
	protected String name;
	public void eat() {
		System.out.println(name+": 먹습니다.");
	}
	public abstract void cry();
}
