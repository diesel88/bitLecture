package day04.exam;

import java.util.Scanner;

public class LoopTest08 {
/*
 * 1 부터 100사이의 숫자 중에서 소수를 출력하는 프로그램을 작성하시오.
 소수는 그 수 자신과 1을 제외한 다른 정수로는 나누어 떨어지지 않는 정수
 3이 소수인지 판별 :
 3 % 1 == 0 (참)
 3 % 2 == 0 (거짓)
 3 % 3 == 0 (참)
 참인 경우가 2개인 경우 소수
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			String ret = "(거짓)";
			if (num % i ==0) {
				ret = "(참)";
				sum++;
			}
			System.out.print(num +" % " + i + " == 0 " + ret + "\n");
			
		}
		String ret = "소수 아님";
		if (sum == 2) {
			ret = "소수";
		}
		System.out.println(ret);
	}
}
