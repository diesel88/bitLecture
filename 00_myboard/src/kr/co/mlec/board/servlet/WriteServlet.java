package kr.co.mlec.board.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.file.BitFileRenamePolicy;
import kr.co.mlec.board.file.mapper.BoardFileMapper;
import kr.co.mlec.board.file.vo.BoardFileVO;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	private BoardFileMapper fileMapper = null;
	public WriteServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
		fileMapper = session.getMapper(BoardFileMapper.class);
	}
	
	public MultipartRequest uploadFile(HttpServletRequest request, BoardFileVO vo) throws IOException {
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		uploadPath += datePath;
		
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024 * 1024 * 10, "utf-8", new BitFileRenamePolicy());
		Enumeration<String> fNames = multi.getFileNames();
		while (fNames.hasMoreElements()) {
			String fileName = fNames.nextElement();
			File file = multi.getFile(fileName);
			
			if(file != null) {
				long size = file.length();
				
				String orgName = multi.getOriginalFileName(fileName);
				String systemName = multi.getFilesystemName(fileName);
				
				vo.setFilePath(datePath+"/");
				vo.setOriName(orgName);
				vo.setSystemName(systemName);
				vo.setFileSize(size);
				
				
			}
		}
		return multi;
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		BoardFileVO fileVO = new BoardFileVO();
		MultipartRequest multi = uploadFile(request, fileVO);
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(multi.getParameter("title"));
		boardVO.setWriter(multi.getParameter("writer"));
		boardVO.setContent(multi.getParameter("content"));
//		boardVO.setTitle(request.getParameter("title"));
//		boardVO.setWriter(request.getParameter("writer"));
//		boardVO.setContent(request.getParameter("content"));
		try {
			mapper.insertBoard(boardVO);
			fileVO.setNo(boardVO.getNo());
			fileMapper.insertBoardFile(fileVO);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			new ServletException(e);
		}
		
		// 화면 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/board/write.jsp"
		);
		rd.forward(request, response);
	}
}














