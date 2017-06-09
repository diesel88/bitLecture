package day14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Test10 {
	public static void main(String[] args) throws IOException {
		// 1.7부터
		// AutoClosable 인터페이스를 상속한 것만
		try (
				FileInputStream fr = new FileInputStream("iodata/day14/Kalimba.mp3");
				FileOutputStream fw = new FileOutputStream("iodata/day14/Kalimba1.mp3");
				
				BufferedInputStream bis = new BufferedInputStream(fr);
				BufferedOutputStream bos = new BufferedOutputStream(fw);
			) {
			
			
			System.out.println("복사 시작");
			long s = System.currentTimeMillis();
			// 데이터를 한꺼번에 담기위한 버퍼 준비(카트)
			while(true) {
				int ch = bis.read();
				if (ch == -1) break;
				bos.write((char)ch);
			}
			long e = System.currentTimeMillis();
			System.out.println("복사 완료");
			
			System.out.println((e - s) / 1000d);

		} catch (Exception e) {
			e.getStackTrace();
		} 
		
	}
}
