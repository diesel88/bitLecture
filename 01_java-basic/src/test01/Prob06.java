package test01;

import java.util.Scanner;

public class Prob06 {
/*
 * 임의의 두 수를 입력 받아 두 수 사이의 합을 구하는 프로그램을 작성하시오
 출력형식 >
 수를 입력하세요 : 3
 수를 입력하세요 : 5
 3 부터 5까지의 합은 12 입니다.

 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int num1 = Integer.parseInt(sc.nextLine());

		System.out.print("수를 입력하세요 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		int sum = 0;
		for (int i = num1; i <= num2; i++) {
			sum += i;
		}
		
		System.out.printf("%d 부터 %d까지의 합은 %d 입니다.", num1, num2, sum);
	}
}
