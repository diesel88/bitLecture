package day08.quiz;

import java.util.Arrays;

public class Quiz04 {
	/*
	 *  split 사용 금지
	 */
	private String[] split(String data, String comp) {
		/*
		String[] arr = null;
		int cnt = 0;
		int len = data.length();
		int idx = data.indexOf(comp);
		for (int i = 0; i != -1 ; i = data.indexOf(comp)){
			if (idx > 0) {
				String[] tArr = new String[++cnt];
				if(arr != null){ System.arraycopy(arr, 0, tArr, 0, arr.length);
				System.out.println(arr.toString());
				}
				arr = new String[cnt];
				System.out.println(i+" "+idx);
				tArr[cnt-1] = data.substring(i, idx);
				arr = tArr;
				
			}
		}
		return arr;
		*/
		String[] temp = new String[data.length()];
		int pos = 0;
		while (true) {
			int sIndex = data.indexOf(comp);
			if (sIndex == -1) {
				temp[pos++] = data.substring(0);
				break;
			}
			temp[pos++] = data.substring(0, sIndex);
			data = data.substring(sIndex + 1);
		}
		
		return Arrays.copyOfRange(temp, 0, pos);
		
		/*
		String[] result = new String[pos];
		System.arraycopy(temp, 0, result, 0, pos);
		return result;
		*/
	}
	
	public static void main(String[] args) {
		Quiz04 quiz = new Quiz04();
		String[] arr = quiz.split("33:홍길동:서울:a@a.com", ":");
		// 출력결과 : [33, 홍길동, 서울, a@a.com]
		System.out.println(Arrays.toString(arr));
	}
}
