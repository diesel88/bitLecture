package day07.exam;

public class Exam05 {
//문자열을 입력받아 꺼꾸로 변경하는 reverseString( String str ) 메소드를 작성하시오
	public static String reverseString(String str) {
		String str2 = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			str2 += str.charAt(i);
		}
		
		return str2;
	}
	public static void main(String[] args) {
		String str = "abcde";
		
		System.out.println(reverseString(str));
	}
}
