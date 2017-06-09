package net01.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
	public static void main(String[] args) {
		// 아이피 주소
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local);
			System.out.println(local.getHostName());
			System.out.println(local.getHostAddress());
			
			InetAddress bit = InetAddress.getByName("www.bitjobedu.co.kr");
			System.out.println(bit.getHostName());
			System.out.println(bit.getHostAddress());

			InetAddress bit2 = InetAddress.getByName("www.bitacademy.net");
			System.out.println(bit2.getHostName());
			System.out.println(bit2.getHostAddress());
			
			System.out.println("===============================");
			InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
			
			for (InetAddress inet : navers) {
				
				System.out.println(inet.getHostAddress());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
