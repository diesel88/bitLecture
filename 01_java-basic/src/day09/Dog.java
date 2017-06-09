package day09;

public class Dog {
	private String name;
	private int age;
	
	// 	기본생성자
//	public Dog() {}
//	//오버로딩
	Dog() {
		this("이름없음", -1);
//		this.name = "이름없음";
//		this.age = -1;
	}
	
	Dog(int age) {
		this("이름없음", age);
//		this.name = "이름없음";
//		this.age = age;
	}
	public Dog(String name, int age) {
//		setName(name);
//		setAge(age);
		this.name = name;
		this.age = age;
	}
	
//	Dog(String text) {
//		System.out.println(text);
//	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
