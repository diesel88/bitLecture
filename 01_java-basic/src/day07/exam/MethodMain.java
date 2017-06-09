package day07.exam;

public class MethodMain {
	public static void main(String[] args) {
		
		MethodUtil mu = new MethodUtil();
		boolean result = mu.isLowerChar('a');
		System.out.println(result);     //  true ���
		result = mu.isLowerChar('A');
		System.out.println(result);     //  false ���
		result = mu.isUpperChar('a');
		System.out.println(result);     //  false ���
		result = mu.isUpperChar('A');
		System.out.println(result);     //  true  ���
		int val = mu.max(100, 10);
		System.out.println(val);        //  100 ��� 
		val = mu.min(100, 10);
		System.out.println(val);        //  10 ��� 
		String revStr = mu.reverseString("Hello World");
		System.out.println(revStr);                 // dlroW olleH ���
		revStr = mu.toUpperString("Hello World");
		System.out.println(revStr);                 // HELLO WORLD ���
		revStr = mu.toLowerString("Hello World");
		System.out.println(revStr);                 // hello world ���
		
	}
}

class MethodUtil {
	public boolean isUpperChar( char c) {
		boolean bool = false;
		if ( c >= 'A' && c <= 'Z') {
			bool = true;
		}
		return bool;
	}
	public boolean isLowerChar(char c) {
		boolean bool = false;
		if ( c >= 'a' && c <= 'z') {
			bool = true;
		}
		return bool;
	}
	public int max( int i, int j) {
		if (i > j) {
			return i;
		}
		else {
			return j;
		}
	}
	public static int min(int i, int j) {
		if (i > j) {
			return j;
		}
		else {
			return i;
		}
	}
	public String reverseString(String str) {
		String str2 = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			str2 += str.charAt(i);
		}
		
		return str2;
	}
	public String toUpperString( String str ) {
		String str2 = "";
		for (int i=0; i < str.length() ; i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c = (char) (c - ('a' - 'A'));
			}
			str2 += c;
		}
		return str2;
	}
	public String toLowerString(String str) {
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
}
