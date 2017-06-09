package test01;

import java.util.Random;

public class Prob05 {
/*
 * 1 - 100사이의 랜덤 숫자 5개를 생성하여 생성된 숫자의 합계와 평균을 구하시오
 */
	public static void main(String[] args) {
		int[] arr = new int[5];
		Random r = new Random();
		int sum = 0;
		double avg = 0;
		for (int i=0; i < 5; i++) {
			arr[i] = r.nextInt(100) + 1;
			sum += arr[i];
			System.out.print(arr[i] + " ");
		}
		avg = (double)sum / 5;
		
		System.out.println("\n합계 : " + sum);
		System.out.printf("평균 : %.1f", avg);
	}
}
