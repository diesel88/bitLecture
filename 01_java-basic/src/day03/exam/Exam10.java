package day03.exam;

import java.util.Random;

public class Exam10 {
/*
 * 1- 100사이의 랜덤숫자를 생성하여 생성된 숫자를 이용하여 아래와 같이 출력하시오
 60점 미만일 경우 재수강
 60 - 90점 일 경우 잘했어요
 91 - 100점일 경우 당신은 장학생
 */
	public static void main(String[] args) {
		int num = new Random().nextInt(100) + 1;
		String result = "당신은 장학생";
		if(num < 60){
			result = "재수강";
		}else if(num < 91){
			result = "잘했어요";
		}
		System.out.printf("%d점 %s", num, result);
	}
}
