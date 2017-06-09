package day09.quiz;

public class Dog {
	private String name;
	private int age;
	
	Dog() {
		this("이름모름", 0);
	}
	
	Dog(String name) {
		this(name, 0);
	}
	
	Dog(int age) {
		this("이름모름", age);
	}
	
	Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void info() {
		System.out.printf("강이지의 이름은 %s이고 나이는 %d입니다.\n", name, age);
	}
	
}
