package quiz;

import java.net.ServerSocket;
import java.net.Socket;

import net07.webserver.HttpServletRequest;

public class Quiz04 {
	public static void main(String[] args) {
		// http://localhost:10002/test?msg=test&count=10
		
		/*
		 * 화면 결과
		 * 
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 * test
		 */
		try {
			ServerSocket ss = new ServerSocket(10001);
			while (true) {
				Socket s = ss.accept();
				HttpServletRequest hq = new HttpServletRequest(s.getInputStream());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
