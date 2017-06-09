package day04.exam;

import java.util.Scanner;

public class LoopTest07 {
/*
 화면에서 2 - 9사이의 숫자 2개를 입력 받아 두 숫자 사이의 구구단을 출력하는 프로그램을
작성하시오
 예를 들어 화면에서 4 와 8을 입력 받았다면 4단부터 8단까지 화면에 출력한다.
 구구단 출력시 각 단별로 줄넘김 처리한다.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("숫자 입력 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.println("\t:\t1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("---------------------------------------------------------------------------------------");
		
		for (int i = num1; i <= num2; i++) {
			System.out.print("\t" + i + "단\t");
			for (int j = 1; j < 10; j++) {
				System.out.print((i * j)+"\t");
				
			}
			System.out.println();
		}
	}
}
