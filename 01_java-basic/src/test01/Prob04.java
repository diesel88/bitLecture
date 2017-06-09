package test01;

import java.util.Scanner;

public class Prob04 {
/*
 * 하나의 수를 입력받은 다음 입력받은 수까지의 짝수와 홀수, 전체 합을 구하는 프로그램을
작성하시오
 출력예시 >
 수 입력 : 10
 홀수 합 : 25
 짝수 합 : 30
 전체 합 : 55
 */
	public static void main(String[] args) {
		System.out.print("수 입력 : ");
		int num = Integer.parseInt(new Scanner(System.in).nextLine());
		int odd = 0, even = 0;
		for (int i = 1; i < num + 1; i++) {
			if (i % 2 == 0){
				even += i;
			}
			else {
				odd += i;
			}
		}
		System.out.println("홀수 합 : " + odd);
		System.out.println("짝수 합 : " + even);
		System.out.println("전체 합 : " + (even + odd));
	}
}
