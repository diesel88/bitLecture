package day04.quiz;

import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		/*
		 
		  	화면에서 숫자를 입력받아서 입력받은 숫자와 연ㄴ관된
		  	별을 출력
		  	
		  	출력형식 >
		  	수 입력 : 5
		  	
		  	*
		  	**
		  	***
		  	****
		  	*****
		  	
		  	
		 */
		System.out.print("수 입력 : ");
		Scanner sc = new Scanner(System.in);sc.close();
		int val = new Scanner(System.in).nextInt();
		String star = "";
		for(int i = 0; i < val; i++){
			System.out.println(star += "*");
			
		}
		
//		for(int i = 0; i < val; i++){
//			for(int j=0; j <= i; j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
	}
}
