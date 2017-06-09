package day07.exam;

public class Exam07 {
//문자열을 입력받아 소문자로 변경하는 toLowerString( String str ) 메소드를 작성하시오
	public static String toLowerString(String str) {
		String str2 = "";
		for (int i=0; i < str.length() ; i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				c = (char) (c + ('a' - 'A'));
			}
			str2 += c;
		}
		return str2;
	}
	public static void main(String[] args) {
		String str = "abcdeABcde";
		System.out.println(toLowerString(str));
	}
}
