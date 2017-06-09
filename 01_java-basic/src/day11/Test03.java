package day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		// 예외의 직접 처리
		try {
			File f = new File("a.txt");
			// 예외가 발생할 수 있는 코드
			Scanner sc = new Scanner(f);
			
//			FileNotFoundException fnfe = new FileNotFoundException();
//			IOException ie = new FileNotFoundException();
//			Exception e = new FileNotFoundException();
//			Throwable t = new FileNotFoundException();
//			Object o = new FileNotFoundException();
		} 
		catch (FileNotFoundException fnfe) {
			System.out.println("파일이 없음..");
			String errMsg = fnfe.getMessage();
			System.out.println(errMsg);
			
			fnfe.printStackTrace();
//		catch (FileNotFoundException fnfe) {
//		catch (IOException e) {
//		catch (Exception e) {
//		catch (Throwable e) {
		// Throwable 타입만올 수 있다.
//		catch (Object e) {
			
		}
	}
}
