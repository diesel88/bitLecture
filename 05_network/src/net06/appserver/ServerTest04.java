package net06.appserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest04 {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10001);
			System.out.println("클라이언트 접속 대기중...");
			while (true) {
				Socket s = ss.accept();
				InputStream in = s.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				OutputStream out = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				while (true) {
					String data = dis.readUTF();
					if(data.equalsIgnoreCase("quit")) break;
					dos.writeUTF(data);
				}
				dos.close();
				out.close();
				dis.close();
				in.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
