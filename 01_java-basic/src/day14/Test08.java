package day14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test08 {
	public static void main(String[] args) {
		/*
		 *   파일 복사하는 프로그램 작성
		 *   a.txt 파일의 내용을 읽어서
		 *   acopy.txt 파일로 복사합니다.
		 */
		FileInputStream fr = null;
		FileOutputStream fw = null;
		try {
			fr = new FileInputStream("iodata/day14/Kalimba.mp3");
			fw = new FileOutputStream("iodata/day14/Kalimba1.mp3");
			
			System.out.println("복사 시작");
			long s = System.currentTimeMillis();
			// 데이터를 한꺼번에 담기위한 버퍼 준비(카트)
			byte[] buffer = new byte[1024 * 32];
			while (true) {
				// buffer 배열에 읽은 내용을 입력
				// 실제 배열에 읽은 데이터의 크기를 반환
				int ch = fr.read(buffer);
				if (ch == -1)
					break;
				fw.write(buffer, 0, ch);
			}
			long e = System.currentTimeMillis();
			System.out.println("복사 완료");
			
			System.out.println((e - s) / 1000d);

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
