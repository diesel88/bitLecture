package net06.appserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest04 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.0.12", 10001);
			System.out.println("서버 접속 성공");
			OutputStream out = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			InputStream in = s.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print("입력: ");
				String data = sc.nextLine();
				dos.writeUTF(data);
				if(data.equalsIgnoreCase("quit")) break;
				String data2 = dis.readUTF();
				System.out.println("서버 전송: " + data2);
			}
			dis.close();
			in.close();
			dos.close();
			out.close();
			System.out.println("접속 종료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
