package day03.exam;

public class Exam01 {
	public static void main(String[] args) {
		/*
		 *
영문자 모음의 아스키 코드 값을 아래의 출력형식에 맞추어 화면에 출력하시오
 - 힌트 : 형변환을 활용합니다.
 결과출력 >
 -----------------------------------
 영문자 모음의 아스키 코드 값
 -----------------------------------
 A = 65
 E = 69
 I = 73
 O = 79
 U = 85
 -----------------------------------
 
		 */
		
		char [] alphabet = {'A','E','I','O','U'};
		System.out.println("-----------------------------------");
		System.out.println("영문자 모음의 아스키 코드 값");
		System.out.println("-----------------------------------");
		for(int i = 0;i < alphabet.length;i++){
			System.out.printf("%s = %d\n", alphabet[i], (int)alphabet[i]);
		}
		System.out.println("-----------------------------------");
	}
}
