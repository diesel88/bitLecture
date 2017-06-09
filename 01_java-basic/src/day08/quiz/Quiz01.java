package day08.quiz;

public class Quiz01 {
	//replace 사용금지
	private String remove(String data, char del) {
		
		if (data.length() > 0) {
			int idx = data.indexOf(del);
			StringBuffer buffer = new StringBuffer();
			buffer.append(data.substring(0, idx));
			buffer.append(data.substring(idx +1));
			return buffer.toString();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Quiz01 quiz = new Quiz01();
		String result = quiz.remove("hello world", 'o');
		System.out.println(result);
	}
}
