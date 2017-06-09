package day03.exam;

import java.util.Scanner;

public class Exam06 {
	/*
	 * 하이마트에서 할인 행사를 진행합니다. 물건값에 따라서 각각의 할인율이 적용됩니다. .

물건값 10만원 이하 	20만원 이하 	30만원 이하      100만원 초과
할인율  3%         5%       	8% 			10%
 화면에서 물건값을 입력 받아 할인된 금액을 계산하여 출력하는 프로그램을 작성하시오
 출력예시>
 물건값을 입력하세요(만원) : 10
 할인된 금액은 97000 원입니다.
 물건값을 입력하세요(만원) : 20
 할인된 금액은 190000 입니다.

	 * 
	 */
	public static void main(String[] args) {
		for(;;){
			double discount = 0.1;
			System.out.print("물건값을 입력하세요(만원) : ");
			int money = Integer.parseInt(new Scanner(System.in).nextLine())*10000;
			if(money <= 100000){
				discount = 0.03;
			}else if(money <= 200000){
				discount = 0.05;
			}else if(money <= 300000){
				discount = 0.09;
			}
			System.out.printf("할인된 금액은 %d 입니다.\n", money - (int)(money*discount));
		}
	}
}
