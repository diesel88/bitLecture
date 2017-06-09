package day04.exam;

import java.util.Random;

public class LoopTest11 {
/*
 * 
 */
	public static void main(String[] args) {
//		Random r = new Random();
//		for (int i = 1; i < 6; i++) {
//			System.out.print("Set " + i + ": ");
//			for (int j = 1; j < 7 ; j++) {
//				int num = r.nextInt(45) + 1;
//				System.out.printf("%2d ", num);
//			}
//			System.out.println();
//			
//		}
//		작성시 주의사항
//		- 로또번호는 1 - 45 사이의 숫자만 나와야 합니다.
//		- Set 별 중복된 숫자가 없어야 합니다.
		Random r = new Random();
		for(int i=0;i < 100; i++) {
			int val1 = 0;
			int val2 = 0;
			int val3 = 0;
			int val4 = 0;
			int val5 = 0;
			while(true) {
				int rNum = r.nextInt(45) + 1;
				if(val1 == 0) {
					val1 = rNum;
				} else if(val2 == 0) {
					if(rNum != val1) {
						val2 = rNum;	
					}
				} else if(val3 == 0) {
					if(rNum != val1 && rNum != val2) {
						val3 = rNum;	
					}
				} else if(val4 == 0) {
					if(rNum != val1 && rNum != val2 && rNum != val3) {
						val4 = rNum;	
					}
				} else {
					if(rNum != val1 && rNum != val2 && rNum != val3 && rNum != val4) {
						val5 = rNum;	
						break;
					}
				}

			}			
			System.out.printf("Set %d : %d %d %d %d %d \n", (i+1), val1, val2, val3, val4, val5);
		}
	}
}
