package net02.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test02 {
	public static void exam01() {
		try{
			// url에 지정된 경로를 호출하고 데이터를 얻기
			URL url = new URL("http://localhost:8000/05_network_web/url/Test02");
			// 지정된 path에 접근하기
			InputStream in = url.openStream();
			byte[] buffer = new byte[1024 * 16];
			while (true) {
				int ch = in.read(buffer);
				if (ch == -1) break;
				String data = new String(buffer, 0, ch, "utf-8");
				System.out.print(data);
			}
			
		} catch (Exception e) {
			
		}
		
	}
	
	public static void exam02() {
		try{
			// url에 지정된 경로를 호출하고 데이터를 얻기
			URL url = new URL("http://localhost:8000/05_network_web/url/Test02");
			// 지정된 path에 접근하기
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				String line = br.readLine();
				
				if (line == null) break;
				System.out.print(line);
			}
			
		} catch (Exception e) {
			
		}
		
	}
	public static void main(String[] args) {
//		exam01();  // byte 배열을 이용해서 한글 처리
		exam02();  // 스트림을 이용한 한글 처리
	}
}
