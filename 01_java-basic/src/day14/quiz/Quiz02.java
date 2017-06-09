package day14.quiz;

import java.io.File;

public class Quiz02 {
	/*
	 * 디렉토리임..

file : a.txt
file : b.txt
directory : lec01
file : Test.java
	 */
	public static void main(String[] args) {
		String path = "iodata/day14";
		File f = new File(path);
		if (f.exists()) {
			if (f.isDirectory()) {
				System.out.println("디렉토리임..");
				String[] arr = f.list();
				for (String name : arr) {
					File file2 = new File(path + "/" + name);
					String kind = "";
					if(file2.isDirectory()) {
						kind = "directory : ";
						
					}else if(file2.isFile()) {
						kind = "file : ";
					}
					System.out.println(kind + name);
				}
			}
			else if (f.isFile()) {
				System.out.println("파일..");
			}
		}
	}
}
