package day07.exam;

public class Exam01 {
	//하나의 문자를 입력받아 해당 문자가 대문자이면 true 를 반환하는 isUpperChar( char c )
//	메소드를 작성하시오
	public static boolean isUpperChar( char c) {
		boolean bool = false;
		if ( c >= 'A' && c <= 'Z') {
			bool = true;
		}
		return bool;
	}
	public static void main(String[] args) {
		System.out.println(isUpperChar('B'));
		System.out.println(isUpperChar('b'));
	}
}
