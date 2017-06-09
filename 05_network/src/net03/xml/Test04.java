package net03.xml;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test04 {
	public static void test01(){
		try {
		// 서버에 접근하기 위해서 url 활용
					String path = "http://192.168.0.20:8000/05_network_web/xml/Test04?name=김용재";
					URL url = new URL(path);
					InputStream in = url.openStream();
					InputStreamReader isr = new InputStreamReader(in, "utf-8");
					BufferedReader br = new BufferedReader(isr);
					while (true) {
						String line = br.readLine();
						if (line == null) break;
						
						System.out.println(line);
					}
					
					System.out.println("클라이언트 종료");
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	public static void test02(){
		try {
			// 서버에 접근하기 위해서 url 활용
			String path = "http://192.168.0.20:8000/05_network_web/xml/Test04";
//			String path = "http://localhost:8000/05_network_web/xml/Test04";
			URL url = new URL(path);
			// POST 방식의 사용과 부가적인 기능을 제공하는
			// HttpURLConnection 을 활용
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 파라미터를 보내기 위해서 출력이 가능하도록 설정
			// 만약, true로 설정하지 않을 경우 출력시 에러발생
			conn.setDoOutput(true);
			
			// POST 방식			
			OutputStream out = conn.getOutputStream();
			out.write("name=김용재".getBytes("utf-8"));
			out.close();
			
			InputStream in = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				System.out.println(line);
			}
			
			System.out.println("클라이언트 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test03(){
		try {
			// 서버에 접근하기 위해서 url 활용
//			String path = "http://192.168.0.20:8000/05_network_web/xml/Test04";
			String path = "http://localhost:8000/05_network_web/xml/Test04";
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			
			// POST 방식			
			OutputStream out = conn.getOutputStream();
			out.write("name=김용재".getBytes("utf-8"));
			out.close();
			
			InputStream in = conn.getInputStream();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(in);
			NodeList list = doc.getElementsByTagName("name");
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println(node.getTextContent());
			}
			System.out.println("클라이언트 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		test01();
//		test02();
		test03();
	}
}
