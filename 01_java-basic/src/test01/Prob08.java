package test01;

import java.util.Arrays;
import java.util.Scanner;

public class Prob08 {
/*
 * 아래와 같은 배열을 선언 한 후 배열의 특정 요소를 바꾸는 프로그램을 작성하시오
 프로그램에 배열 선언 : int arr = { 6, 8, 3, 9, 7, 4 }
 출력형식 >
 바꿀 인덱스 : 2
 바꿀 인덱스 : 4
 변경된 배열 : [6, 8, 7, 9, 3, 4]

 */
	public static void main(String[] args) {
		int[] arr = { 6, 8, 3, 9, 7, 4 };
		Scanner sc = new Scanner(System.in);
		System.out.print(" 바꿀 인덱스 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print(" 바꿀 인덱스 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int temp = arr[num2];
		arr[num2] = arr[num1];
		arr[num1] = temp;
		System.out.println(Arrays.toString(arr));
	}
}
