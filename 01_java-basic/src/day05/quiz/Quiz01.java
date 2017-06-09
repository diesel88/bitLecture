package day05.quiz;

public class Quiz01 {
	public static void main(String[] args) {
		int[] arr = {6, 8, 3, 9, 7, 4};
		
		/*
		 * 출력형식>
		 * 최댓값 : 9
		 * 최소값 : 3
		 */
		int min = arr[0], max = arr[0];
		for (int i = 1; i < arr.length ; i++) {
			
			if( arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
		
		
	}
}
