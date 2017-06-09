package day03.exam;

import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		/*
		 화면에서 초를 입력 받고 몇 시간 몇 분 몇 초인지 환산해서 출력하시오
		초를 입력하세요 : 3661
		3661초는 1시간 1분 1초입니다.

		 */
		System.out.print("초를 입력하세요 : ");
		int seconds = Integer.parseInt(new Scanner(System.in).nextLine());
//		int minutes = seconds/60;
//		int second = seconds%60;
//		int hour = minutes/60;
//		int minute = minutes%60;
		int hour = seconds/3600;
		int minute = (seconds-hour*3600)/60;
		int second = seconds%60;
		System.out.printf("\n%d초는 %d시간 %d분 %d초입니다.", seconds, hour, minute, second);
		
	}
}
