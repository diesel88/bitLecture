package day06.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		int  tail = 0, cnt = 0;
		
		outer : while (true) {
			System.out.println("------------------");
			System.out.println("1. 입력");
			System.out.println("2. 꺼내기");
			System.out.println("3. 전체데이터 확인");
			System.out.println("0. 종료");
			System.out.println("------------------");
			System.out.print("메뉴 : ");
			
			int num = Integer.parseInt(sc.nextLine());
			
			switch (num){
			case 1:
				if (cnt == 10) {
					System.out.println("비어있는 공간이 없습니다.");
					break;
				}
				System.out.print("입력 값 : ");
				int val = Integer.parseInt(sc.nextLine());
				
				arr[tail] = val;
				if (tail < 9)tail++;
				cnt++;
				break;
			case 2:
				if (cnt == 0) {
					System.out.println("입력된 데이터가 없습니다.");
					break;
				}
				System.out.println("꺼낸 값 : " + arr[tail]);
				arr[tail] = 0;
				tail--;
				cnt--;
				break;
			case 3:
				System.out.println(Arrays.toString(arr));
				break;
			case 0:
				break outer;
			}
		
		}
	}
}
