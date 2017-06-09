package day04.exam;

import java.util.Random;

public class LoopTest03 {
	/*
	 1 - 100사이의 랜덤 숫자 5개를 생성하여 생성된 숫자의 합계와 평균을 구하시오
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int sum = 0;
		double avg = 0;
		for (int i=0; i < 5; i++) {
			int num1 = r.nextInt (100) + 1;
			System.out.print (num1 + " ");	
			sum += num1;
		}
		avg = sum / 5;
		System.out.println();
		System.out.printf("합 : %d 평균 : %.1f", sum, avg);
	}
}
