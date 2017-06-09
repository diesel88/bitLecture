/*
 *   exam01.txt 파일의 내용을 읽어서
 *   exam01-result.txt 파일에 아래의 형식으로 저장하는 프로그램 작성
 *   
     89
	 19
	 77
	 90
	 총점 : ...
	 평균 : ...
	 최고점 : ...
	 최저점 : ...
 */
package day14.exam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam01 {
	public static void main(String[] args) {
		try(
				FileReader fr = new FileReader("src/day14/exam/exam01.txt");
				FileWriter fw = new FileWriter("src/day14/exam/exam01-result.txt");
				) {
			String str="";
			while (true) {
				char[] buffer = new char[1024];
				int len = fr.read(buffer);
				if(len == -1) break;
				str += String.valueOf(buffer);
			}
			String[] data = str.split("\r\n");
			List<Integer> arr = new ArrayList<>();
			int tot = 0, max = 0, min = 0;
			double avg = 0;
			for (int i=0; i < data.length; i++) {
				arr.add(new Integer(String.valueOf(data[i].trim())));
				tot += arr.get(i).intValue();
			}
			avg = tot / arr.size();
			Collections.sort(arr);
			str+= String.format("\r\n총점 : %d", tot);
			str+= String.format("\r\n평균 : %.1f", avg);
			str+= String.format("\r\n최고점 : %d", arr.get(arr.size() - 1));
			str+= String.format("\r\n최저점 : %d", arr.get(0));
			
			fw.write(str);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}











