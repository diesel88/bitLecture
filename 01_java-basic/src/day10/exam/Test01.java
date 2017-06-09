package day10.exam;

import java.util.Random;

/*
 * 조건 :
- 메인 메소드를 구현합니다. 메인 메소드의 역할은 아래와 같습니다.
- 면적을 구할 도형의 종류를 표현할 랜덤한 숫자를 생성합니다.(1 ~ 4)
예> 1-정사각형, 2-직사각형, 3-삼각형, 4-원
- 생성된 숫자에 따라서
1, 4번일 경우는 도형의 면적을 구할 랜덤 숫자를 1개 생성합니다.
2, 3번일 경우는 도형의 면적을 구할 랜덤 숫자를 2개 생성합니다.
- 면적을 구할 랜덤 숫자까지 생성되었다면 각각의 도형의 면적을 구하는 클래스를 호출합
니다.
- 출력결과는 아래와 같이 출력됩니다.
정사각형일 경우 : 정사각형의 면적은 9 입니다
직사각형일 경우 : 직사각형의 면적은 12 입니다
삼각형일 경우 : 삼각형의 면적은 6 입니다
원일 경우 : 원의 면적은 6 입니다
- 도형의 면적을 출력하는 부분은 도형의 area() 메서드에서 처리합니다.
추상클래스 작성
클래스명 : Shape
조건 :
- public void area( ) 메소드 선언 : 추상메서드로 선언
일반클래스 작성
작성 클래스명 : Rectangle (직사각형), Triangle (삼각형), Circle (원)
조건 :
- Shape 클래스를 상속
- 필요한 값들은 자유롭게 구현
작성 클래스명 : Square(정사각형)
조건 :
- Rectangle 클래스를 상속
- 필요한 값들은 자유롭게 구현
 */

abstract class Shape {
	Random r = new Random();
	int num1;
	public abstract void area();
}
class Rectangle extends Shape {
	int num2;
	public void area() {
		num1 = r.nextInt(10) + 1;
		num2 = r.nextInt(10) + 1;
		System.out.printf("직사각형의 면적은 %d 입니다.\n", num1 * num2);
	}
}
class Triangle extends Shape {
	int num2;
	public void area() {
		num1 = r.nextInt(10) + 1;
		num2 = r.nextInt(10) + 1;
		System.out.printf("삼각형의 면적은 %d 입니다.\n", num1 * num2 / 2);
	}
}

class Square extends Rectangle {
	public void area() {
		num1 = r.nextInt(10) + 1;
		System.out.printf("정사각형의 면적은 %d 입니다.\n", num1 * num1);
	}
}
class Circle extends Shape {
	public void area() {
		num1 = r.nextInt(10) + 1;
		System.out.printf("원의 면적은 %.1f 입니다.\n", num1 * num1 * 3.14);
	}
}
public class Test01 {
	public static void main(String[] args) {
		Random r = new Random();
		Shape s = null;
		for(int i = 0; i < 5; i++) {
			int num = r.nextInt(5) + 1;
			switch (num) {
			case 1:
				s = new Square();
				break;
			case 2:
				s = new Rectangle();
				break;
			case 3:
				s = new Triangle();
				break;
			case 4:
				s = new Circle();
				break;
			}
			s.area();
		}
	}
}
