package day07.exam;

public class Exam02 {
//하나의 문자를 입력받아 해당 문자가 소문자이면 true를 반환하는 isLowerChar(char c) 메
//	소드를 작성하시오
	public static boolean isLowerChar(char c) {
		boolean bool = false;
		if ( c >= 'a' && c <= 'z') {
			bool = true;
		}
		return bool;
	}
	public static void main(String[] args) {
		System.out.println(isLowerChar('B'));
		System.out.println(isLowerChar('b'));
	}

}
