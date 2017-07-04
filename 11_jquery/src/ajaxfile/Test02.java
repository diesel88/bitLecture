package ajaxfile;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ajaxfile/test02")
public class Test02 extends HttpServlet {

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
		Enumeration<String> fileNames = mRequest.getFileNames();
		while (fileNames.hasMoreElements()) {
			String fileName = fileNames.nextElement();
			System.out.println(fileName);
			String oriName = mRequest.getOriginalFileName(fileName);
			String systemName = mRequest.getFilesystemName(fileName);
			System.out.println("msg : " + msg);
			System.out.println("oriName : " + oriName);
			System.out.println("systemName : " + systemName);
		}
		/*
		String oriName = mRequest.getOriginalFileName("attachFile");
		String systemName = mRequest.getFilesystemName("attachFile");
		String oriName2 = mRequest.getOriginalFileName("attachFile1");
		String systemName2 = mRequest.getFilesystemName("attachFile1");
		System.out.println("msg : " + msg);
		System.out.println("oriName : " + oriName);
		System.out.println("systemName : " + systemName);
		System.out.println("oriName2 : " + oriName2);
		System.out.println("systemName2 : " + systemName2);
		*/
	}
	
}
