package day06.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Exam03 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = Integer.parseInt(sc.nextLine());
		int[] arr = new int[cnt];
		int[] arr2 = new int[cnt];
		int[] tempArr = new int[cnt];
		
		for (int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(sc.next());
		} 
		
		
		arr2[0] = 1;
		for(int i = 1; i < cnt; i++) {
			System.arraycopy(arr2, 0, tempArr, 0, i - arr[i]); 
			tempArr[i - arr[i]] = i + 1;
			System.arraycopy(arr2, i - arr[i] , tempArr, i - arr[i] + 1, arr[i]);
			System.arraycopy(tempArr, 0, arr2, 0, cnt);
			
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		

	}
}
