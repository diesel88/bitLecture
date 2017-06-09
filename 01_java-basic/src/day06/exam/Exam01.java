package day06.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Exam01 {
	/*
	 * 실행결과 화면
------------------
1. 입력
2. 꺼내기
3. 전체데이터 확인
0. 종료
------------------
메뉴 : 3

	 */
	public static void main(String[] args) {
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		int head = 0, tail = -1, cnt = 0;
		
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
				if (++tail >= 10) {
					tail -= 10;
				}
				arr[tail] = val;
				cnt++;
				break;
			case 2:
				if (cnt == 0) {
					System.out.println("입력된 데이터가 없습니다.");
					break;
				}
				System.out.println("꺼낸 값 : " + arr[head]);
				arr[head] = 0;
				if (++head >= 10) {
					head -= 10;
				}
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
