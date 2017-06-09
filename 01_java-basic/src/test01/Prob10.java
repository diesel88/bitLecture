package test01;

import java.util.Scanner;

public class Prob10 {
/*
 * 아래와 같은 배열을 선언 한 후 배열에서 사용자가 입력한 숫자가 몇 개인지 판단하는
프로그램을 작성하시오 (사용자가 -1을 입력 할 때까지 반복실행)
 프로그램에 배열 선언 : int arr = { 6, 8, 3, 9, 7, 4 }
 출력형식 >
 수를 입력 : 3
 배열에 1개가 들어있습니다.
 수를 입력 : 1
 배열에 0개가 들어있습니다.
 수를 입력 : -1
 종료합니다.
 */
	public static void main(String[] args) {
		int[] arr = { 6, 8, 3, 9, 7, 4 };
		Scanner sc = new Scanner(System.in);
		outer : while (true) {
			System.out.print("수를 입력 : ");
			int num = Integer.parseInt(sc.nextLine());
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if(num == -1){
					System.out.println("종료합니다.");
					break outer;
				}
				else if (num == arr[i]) {
					sum++;
				}
			}
			System.out.printf("배열에 %d개가 들어있습니다.\n", sum);
		}
	}
}
