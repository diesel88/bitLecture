package day09.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 
 *  출력형식>
 *  txt 파일
 *  --------------------
 *  c.txt
 *  --------------------
 *  java파일
 *  --------------------
 *  a.java
 *  b.java
 *  --------------------
 *  xls 파일
 *  --------------------
 *  존재하지 않습니다.
 *  --------------------
 */
public class Quiz02 {
	public static void showFileByExt(String ext) throws FileNotFoundException {
		File file = new File("iodata/day09/quiz02.txt");
		Scanner sc = new Scanner(file);
		System.out.println(ext+" 파일");
		System.out.println("--------------------");
		boolean flag = true;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.endsWith("."+ext)) {
				flag = false;
				System.out.println(line);
			}
		}
		if (flag) System.out.println("존재하지 않습니다.");
		System.out.println("--------------------");
	}
	
	public static void main(String[] args) {
		
		try {
			showFileByExt("txt");
			showFileByExt("java");
			showFileByExt("xls");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
