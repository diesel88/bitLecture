/*
 *   exam02.txt
 *   ------------------------------
 *   김기수:98:66:78
 *   이지수:88:56:88
 *   박수리:78:86:58
 *   ------------------------------
 * 
 *   파일의 내용을 읽어서 아래와 같은 형식으로 출력
 *   파일형식 : 이름:자바:SQL:Jdbc
 *   수료 기준 
 *   - 자바 : 70점 이상
 *   - SQL  : 80점 이상
 *   - Jdbc : 80점 이상
 *   단, 출력결과는 exam02-result.txt에 출력
 *   
 *   실행시의 결과 출력 형식
 *   
 *   김기수 : 자바(수료), SQL(미수료), Jdbc(미수료)
 *   이기수 : 자바(수료), SQL(미수료), Jdbc(수료)
 *   박수리 : 자바(수료), SQL(수료), Jdbc(미수료)
 */
package day14.exam;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Student {
	private String name;
	private int java;
	private int sql;
	private int jdbc;
	
	public Student(String name, int java, int sql, int jdbc) {
		this.name = name;
		this.java = java;
		this.sql = sql;
		this.jdbc = jdbc;
	}

	public String getName() {
		return name;
	}

	public int getJava() {
		return java;
	}

	public int getSql() {
		return sql;
	}

	public int getJdbc() {
		return jdbc;
	}
	
	
}

public class Exam02 {
	public static void main(String[] args) {
		String str = "";
		List<Student> list = new ArrayList<>();
		try (
		FileReader fr = new FileReader("src/day14/exam/exam02.txt");
				) {
			while (true) {
				char[] buffer = new char[1024];
				int len = fr.read(buffer);
				if (len == -1) {
					break;
				}
				str += String.valueOf(buffer);
			}
			String[] data = str.split("\r\n");
			for (int i = 0; i < data.length; i++) {
				String[] sub = data[i].split(":");
				Student s = new Student(sub[0].trim(), Integer.valueOf(sub[1].trim()), Integer.valueOf(sub[2].trim()), Integer.valueOf(sub[3].trim()));
				//김기수 : 자바(수료), SQL(미수료), Jdbc(미수료)
				System.out.printf("%s : 자바(%s), SQL(%s), jdbc(%s)\n",
						s.getName(), 
						s.getJava() >= 70 ? "수료" : "미수료",
						s.getSql() >= 80 ? "수료" : "미수료",
						s.getJdbc() >= 80 ? "수료" : "미수료");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}














