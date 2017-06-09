package day05.quiz;

import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		/*
		 * 	수를 입력 : 3
		 *  배열에 1개가 들어있습니다.
		 *  
		 *  수를 입력 : 1
		 *  배열에 0개가 들어있습니다.
		 *  
		 *  수를 입력 : -1
		 *  종료합니다.
		 */
		int[] arr = {6, 8, 3, 9, 7, 4};
		
		while (true) {
			System.out.print("수를 입력 : ");
			int num = Integer.parseInt(new Scanner(System.in).nextLine());
			if (num == -1) {
				System.out.println("종료합니다.");
				break;
			}
			int sum = 0;
			for (int i=0; i < arr.length; i++) {
				if (num == arr[i]) {
					sum++;
				}
			}
			System.out.println("배열에 " + sum + "개가 들어있습니다.");
			System.out.println();
		}
	}
}
