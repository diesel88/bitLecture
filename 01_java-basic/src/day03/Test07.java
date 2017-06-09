package day03;

public class Test07 {
	public static void main(String[] args) {
		int a = 2;
		/*
		if (a > 3){
			System.out.println("a는 3보다 크다");
			System.out.println("a = " + a);
		}
		*/
		/*
		if (a > 3){
			System.out.println("a는 3보다 크다");
			System.out.println("a = " + a);
		}else{
			System.out.println("a는 3보다 크지 않다.");
		}
		//a가 3보다 크다
		//a는 3이다
		//a는 3보다 작다
		a = 2;
		if (a > 3){
			System.out.println("a는 3보다 크다");
			System.out.println("a = " + a);
		}else{
			if(a == 3){
				System.out.println("a는 3이다");
				
			}else{
				System.out.println("a는 3보다 작다.");
			}
		}
		*/
		//a가 3보다 크다
		//a는 3이다
		//a는 3보다 작다
		a = 2;
		if (a > 3){
			System.out.println("a는 3보다 크다");
			System.out.println("a = " + a);
		}else if(a == 3){
				System.out.println("a는 3이다");
		}	
		else{
				System.out.println("a는 3보다 작다.");
			
		}
		System.out.println("프로그램 종료...");
	}
}
