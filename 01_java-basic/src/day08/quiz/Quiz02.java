package day08.quiz;

public class Quiz02 {
	/*
	 *  startsWith 사용 금지
	 */
	private boolean startsWith(String str1, String str2) {

		if (str2.length() > str1.length()) return false;
		for (int i=0; i < str2.length() - 1; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Quiz02 quiz = new Quiz02();
		boolean result = quiz.startsWith("hello world", "hel");
		System.out.println(result);
	}
}
