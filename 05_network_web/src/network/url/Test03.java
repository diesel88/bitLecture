package network.url;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test03
 */
@WebServlet("/url/Test03")
public class Test03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Map<String, String> data = new HashMap<>();
    public Test03() {
    	data.put("hong", "1234");
    	data.put("kim", "1234");
    	data.put("lee", "1234");
    	data.put("kang", "1234");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디를 받아서 아이디에 해당하는 사용자의 정보를 제공
		response.setContentType("text/plain; charset=utf-8");
		System.out.println("아이디 서비스 제공 페이지 접근");
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		String pass = request.getParameter("pass");
		System.out.println("pass : " + pass);
		
		String result = "실패";
		String pw = data.get(id);
		if (pw != null && pw.equals(pass)) {
			result = "성공";
		}
		
		System.out.println("로그인 " + result);
		
		//클라이언트로 데이터 전송하기
		PrintWriter out = response.getWriter();
		out.println("로그인 " + result);
		out.close();
	}

}
