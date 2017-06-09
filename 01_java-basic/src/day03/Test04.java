package day03;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		Random r = new Random();
		
		//랜덤수 2개 1-10
		int a = r.nextInt(10)+1;
		int b = r.nextInt(10)+1;
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		//생성된 두 수 중에서 큰수를 max란 이름의 변수에 저장하시오
		//3항 연산자 이용
		int max=(a>b)?a:b;
		System.out.println("큰수: "+max);
		
		//두수중에 작은수를 min이란 변수에 저장하고 화면에 출력하시오
		int min = ( a<b )?a:b;
		System.out.println("작은수: "+min);
	}
}
