package kr.co.mlec.board.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/download")
public class DownloadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		
		String path = request.getParameter("path");
		String sName = request.getParameter("sName");
		String dName = request.getParameter("dName");
		
		File f = new File(uploadPath + path + sName);
		response.setHeader("Content-Type", "application/octet-stream");
		// 한글이름으로 다운로드 처리
		dName = new String(dName.getBytes("utf-8"), "8859_1");
		response.setHeader("Content-Disposition", "attachment;filename=" + dName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Length", String.valueOf(f.length()));
		
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		while (true) {
			int ch = bis.read();
			if (ch== -1) break;
			
			bos.write(ch);
		}
		bis.close();
		fis.close();
		
		bos.close();
		out.close();
	}

}
