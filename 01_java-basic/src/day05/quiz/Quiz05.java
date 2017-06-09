package day05.quiz;

import java.util.Arrays;

public class Quiz05 {
/*
 * 
 */
	public static void main(String[] args) {
//		int[] arr = {1, 2, 3, 4, 5};
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		
		if( arr.length % 2 == 0) {
			int num = arr.length / 2;
			for (int i = 0; i < arr.length / 2; i++) {
				int temp = arr[num +i];
				arr[num + i] = arr[num - i-1];
				arr[num - i-1] = temp;
			}
		} else {
			int num = arr.length / 2;
			for (int i = 1; i <= arr.length / 2; i++) {
				int temp = arr[num + i];
				arr[num + i] = arr[num - i];
				arr[num - i] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
