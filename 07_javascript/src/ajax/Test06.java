package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/08_ajax/test06")
public class Test06 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		String json = "";
		json += "[";
		json += "	{";
		json += "		\"name\":\"윤균상\",";
		json += "		\"age\":33";
		json += "	},";
		json += "	{";
		json += "		\"name\":\"김상중\",";
		json += "		\"age\":44";
		json += "	}";
		json += "]";
		System.out.println(json);
		out.print(json);
		out.close();
	}
	
}
