package day04.quiz;

import java.util.Random;
import java.util.Scanner;

/*
 1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)
 1회. 숫자를 입력하세요(1 - 1000) : 3
 3보다 큰 값입니다.
 2회. 숫자를 입력하세요(1 - 1000) : 500
 500보다 작은 값 입니다.
 3회. 숫자를 입력하세요(1 - 1000) : 250
 정답입니다.
 
 1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)
 1회. 숫자를 입력하세요(1 - 1000) : 3
 3보다 큰 값입니다.
 생략.....
 10회. 숫자를 입력하세요(1 - 1000) : 3
 3보다 큰 값 입니다.
 10회안에 맞추기 게임에 실패하였습니다.
 정답은 85입니다.
 
 
 */
public class Quiz04 {
	public static void main(String[] args) {
		outer : while(true){
			
			System.out.println("1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)");
			int num = 0;
			int answer = new Random().nextInt(1000) + 1;
			System.out.println(answer);
			String result ="";
			boolean bool = false;
			for( int cnt =1; cnt < 11; cnt++) {
				System.out.print(cnt+"회. 숫자를 입력하세요(1 - 1000) : ");
				num = Integer.parseInt(new Scanner(System.in).nextLine());
				if (num == -1) {
					break outer;
				}
				else if (num == answer) {
					bool = true;
					System.out.println("정답입니다.");
					break;
				}
				else if (num > answer) {
					result = "보다 작은 값 입니다.";
				}
				else {
					result = "보다 큰 값입니다.";
				}
				System.out.printf("%d%s\n", num, result);
			}
			if(!bool){
				System.out.println("10회안에 맞추기 게임에 실패하였습니다.");
				System.out.printf("정답은 %d 입니다.\n\n", answer);
			}
		}
		
	}
}
