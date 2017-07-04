package ajaxfile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ajaxfile/test01")
public class Test01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upload = "C:/git/bitLecture/11_jquery/WebContent/upload";
		
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				upload,
				1024 * 10 * 10,
				"utf-8",
				new DefaultFileRenamePolicy()
		);
		
		String msg = mRequest.getParameter("msg");
		String oriName = mRequest.getOriginalFileName("attachFile");
		String systemName = mRequest.getFilesystemName("attachFile");
		System.out.println("msg : " + msg);
		System.out.println("oriName : " + oriName);
		System.out.println("systemName : " + systemName);
	}
	
}
