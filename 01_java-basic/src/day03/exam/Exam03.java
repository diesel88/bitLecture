package day03.exam;

import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) {
		/*
		 * 반지름을 화면에서 입력 받고 면적을 구해서 출력하시오
			참고 : 원주율 – 3.141592
			원의 반지름을 입력하세요 : 10
			반지름이 10인 원의 면적은 314.1592입니다.

		 */
		final double pi = 3.141592;
		System.out.print("원의 반지름을 입력하세요 : ");
		int radius = Integer.parseInt(new Scanner(System.in).nextLine());
		System.out.printf("반지름이 %d인 원의 면적은 %.4f입니다.", radius, pi*radius*radius);
	}
}
