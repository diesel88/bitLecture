package network.url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test02
 */
//	http://localhost:8000/05_network_web/url/Test02
@WebServlet("/url/Test02")
public class Test02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Test02() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("클라이언트 접속함");
		
		// 보내려는 데이터가 일반 텍스트이고 utf-8로 해석해야 한다.
		response.setContentType("text/plain; charset=utf-8");
		//접속한 클라이언트로 데어터를 보내기 위한 출력객체
		PrintWriter out = response.getWriter();
		// 클라이언트로 보낼 데이터
		out.println("success 성공");
		out.close();
	}

}
