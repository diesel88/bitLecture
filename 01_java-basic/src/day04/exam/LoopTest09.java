package day04.exam;

import java.util.Random;

public class LoopTest09 {
/*
 * 10부터 20사이의 랜덤한 숫자를 생성한 다음 생성된 숫자 만큼의 소수를 출력하는 프로그
	램을 작성하시오
 */
	public static void main(String[] args) {
		int num = new Random().nextInt(21) + 10;
		System.out.println("숫자 : " + num);
		for (int i=1; i <= num; i++){
			int sum = 0;
			for (int j = 1; j <= num; j++) {
				if (i % j ==0) {
					sum++;
				}
			}
			
			if (sum == 2) {
				System.out.println(i);
			}
		}
	}
}
