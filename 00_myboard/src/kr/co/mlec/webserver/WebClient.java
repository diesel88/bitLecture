package kr.co.mlec.webserver;

import java.net.Socket;

import kr.co.mlec.board.servlet.DetailServlet;
import kr.co.mlec.board.servlet.ListServlet;

public class WebClient {
	private Socket s;
	public WebClient(Socket s) {
		this.s = s;
	}
	
	public void service() throws Exception {
		// 요청에 대한 처리 파싱
		HttpServletRequest request  = new HttpServletRequest(s.getInputStream());
		
		// 응답에 대한 처리 진행
		HttpServletResponse response = new HttpServletResponse(s.getOutputStream());
		
		String uri = request.getRequestUri();
		System.out.println("uri : " + uri);
		if ( uri == null ) return;
		
//		HttpServlet servlet = null;
//		switch (uri) {
//		case "/board/list":
//			servlet = new ListServlet();
//			break;
//		case "/board/detail":
//			servlet = new DetailServlet();
//			break;
//		default :
//			return;
//		}
		// 각 작업 클래스에게 작업지시
//		servlet.service(request, response);
		// 사용자에게 데이터 응답
		response.send();
	}
	
}
