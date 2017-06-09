package day04.quiz;

import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		/*
		 * 
		 * 하나의 수를 입력받은 다음 입력받은 수까지의
		 * 짝수와 홀수, 전체 합을 구한다.
		 * 
		 * 출력 형식>
		 * 
		 * 수 입력 : 10
		 * 홀수 합 : 25
		 * 짝수 합 : 30
		 * 전체 합 : 55
		 */
		System.out.print("수 입력 : ");
		
		int num = Integer.parseInt(new Scanner(System.in).nextLine());
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i <= num; i++) {
			if (i % 2 == 1) {
				sum1 += i;
				continue;
			} 
			sum2 += i;
			
		}
		System.out.println("홀수 합 : " + sum1);
		System.out.println("짝수 합 : " + sum2);
		System.out.println("전체 합 : " + (sum1 + sum2));
	}
}
