package net06.appserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTest02 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",10001);
			InputStream in = s.getInputStream();
//			byte[] buffer = new byte[1024];
//			int count = in.read(buffer);
//			String msg = new String(buffer, 0, count);
//			System.out.println("서버에서 전송된 데이터 : " + msg);
			InputStreamReader isr = new InputStreamReader(in,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer result = new StringBuffer("");
			System.out.println("접속성공");
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				result.append(line);
			}
			System.out.println(result.toString());
			System.out.println("서버에서 전송된 데이터 : " + result.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
