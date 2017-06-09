package net07.webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// 요청 정보 확인하기 : 시작라인 + 헤더 + 바디(POST 방식일 경우)
public class Test03 {
	
	public static Map<String, String> getMap(String data) {
		Map<String, String> map = new HashMap<>();
		String[] subData = data.split("&");
		for (int i = 0; i < subData.length; i++) {
			String[] subData2 = subData[i].split("=");
			String key = subData2[0];
			String value = subData2[1];
			map.put(key, value);
		}
		return map;
	}
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10001);
			
			while (true) {
				Socket s = ss.accept();
				System.out.println("접속 : " + s);
				InputStream in = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				// 요청 시작라인
				String reqStartLine = br.readLine();
				
				// http://localhost:10001/05_network/test03?id=a&pass=b
				/*
				 * GET /05_network_web/Test01?id=aaa&pass=1111 HTTP/1.1
				 * 출력 데이터가 아래와 같이 출력되도록 코딩 작성
				 * 요청 메서드 : GET
				 * 요청 URI : /05_network/Test03
				 * 요청 파라미터
				 * id : a
				 * pass : b
				 * 
				 */
				String[] data = reqStartLine.split(" ");
				String method = data[0];
				String[] subData = data[1].split("\\?");
				String path = subData[0];
				
				Map<String, String> map = getMap(subData[1]);
				
				
				System.out.println("요청 메서드 : " + method);
				System.out.println("요청 uri : " + path);
				System.out.println("요청 파라미터 : " + method);
				Set<Entry<String, String>> set = map.entrySet();
				for(Entry e : set) {
					System.out.println(e.getKey() + " : " + e.getValue());
				}
				
				String time =  "<html>"
						+ " <head><title>시간표시</title>"
						+ " <style>"
						+ "   div {"
						+ "		font-size: 25px; "
						+ "		background: tomato;"
						+ "		color: white;"
						+ "		text-align: left;"
						+ "		margin: 100px;"
						+ "		padding: 50px;"
						+ "		border: 10px solid black;"
						+ "		transition: 1s"
						+ "	  }"
						+ "    div:hover {"
						+ "		 background: black; "
						+ "		 border-radius: 50px 50px 50px 50px;"
						+ "		}"
						+ " </style>"
						+ "</head>"
						+ " <body>"
						+ "		<div>"
						+ "     시작라인 : " + reqStartLine + "<br>"
						+ "		</div>"
						+ " </body>"
						+ "</html>";	
				
				String startLine = "HTTP/1.1 200 OK\r\n";
				String headers = "Cache-Control: no-cache\r\n"
							   + "Content-Type: text/html; charset=utf-8\r\n"
							   + "Content-Length: "+time.getBytes().length + "\r\n\r\n";
				
				String body = time;
				
				String data2 = startLine + headers + body;
				System.out.println(data2);
				
				OutputStream out = s.getOutputStream();
				out.write(data2.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
