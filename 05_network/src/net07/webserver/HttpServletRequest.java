package net07.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {
	private InputStream in;
	private String method;
	private String uri;
	private String queryString;
	private Map<String, String> map;
	public HttpServletRequest(InputStream in) throws IOException{
		this.in = in;
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
		method = data[0];
		String[] subData = data[1].split("\\?");
		uri = subData[0];
		queryString = subData[1];
		map = new HashMap<>();
		String[] subData2 = subData[1].split("&");
		for (int i = 0; i < subData2.length; i++) {
			String[] subData3 = subData2[i].split("=");
			String key = subData3[0];
			String value = subData3[1];
			map.put(key, value);
		}
	}
	public String getMethod() {
		// TODO Auto-generated method stub
		return method;
	}
	public String getRequestUri() {
		// TODO Auto-generated method stub
		return uri;
	}
	public String getQueryString() {
		// TODO Auto-generated method stub
		return queryString;
	}
	public String getParameter(String key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}
}
