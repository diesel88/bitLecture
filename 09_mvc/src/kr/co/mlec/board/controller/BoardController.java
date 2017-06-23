package kr.co.mlec.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.ModelAndView;
import org.springframework.web.RequestMapping;
import org.springframework.web.RequestParam;
import org.springframework.web.WebUtil;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.common.file.BitFileRenamePolicy;

public class BoardController {
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public BoardController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	// "/board/commentDelete.do"
	@RequestMapping("/board/commentDelete.do")
	public String commentDeleteAjax(BoardCommentVO comment) throws Exception {
		mapper.deleteBoardComment(comment.getCommentNo());
		session.commit();
		
//		return new ModelAndView("redirect:detail.do?no=" + no);
		List<BoardCommentVO> commentList = mapper.selectBoardCommentByNo(comment.getNo());
		
		
		return "ajax:" + new Gson().toJson(commentList);
	
	}
	
	@RequestMapping("/board/commentList.do")
	public String commentListAjax(int no) throws Exception {
		List<BoardCommentVO> commentList = mapper.selectBoardCommentByNo(no);
		
		
		return "ajax:" + new Gson().toJson(commentList);
	}
	@RequestMapping("/board/commentRegist.do")
	public String commentRegistAjax(BoardCommentVO comment) throws Exception {
		
//		
//		// 게시판과 파일 테이블에 저장할 글번호를 조회
////		BoardCommentVO comment = new BoardCommentVO();
//		comment.setNo(no);
//		comment.setContent(request.getParameter("content"));
//		comment.setUserId(request.getParameter("userId"));
		
		// 게시물 저장 처리 부탁..
		mapper.insertBoardComment(comment);
		session.commit();
		
		List<BoardCommentVO> commentList = mapper.selectBoardCommentByNo(comment.getNo());
		
		return "ajax:" + new Gson().toJson(commentList);
	}
	@RequestMapping("/board/commentUpdate.do")
	public String commentUpdateAjax(BoardCommentVO comment) throws Exception {
		
		
		
		mapper.updateBoardComment(comment);
		session.commit();
		
		List<BoardCommentVO> commentList = mapper.selectBoardCommentByNo(comment.getNo());
		
		
		return "ajax:" + new Gson().toJson(commentList);
	}
	
	@RequestMapping("/board/detail.do")
	public ModelAndView detail(int no) 
					throws Exception {
		ModelAndView mav = new ModelAndView("/board/detail");
		
		BoardVO board = mapper.selectBoardByNo(no);
		mav.addObject("board", board);
		// 게시물과 연관된 파일 정보 추출
		BoardFileVO fileVO = mapper.selectBoardFileByNo(no);
		mav.addObject("file", fileVO);
		
		
		// 댓글 목록 정보 공유
		/*
		List<BoardCommentVO> commentList = mapper.selectBoardCommentByNo(no);
		mav.addObject("commentList", commentList);
		*/
		
		// 공유
		// 화면 페이지 이동
		return mav;
	}
	@RequestMapping("/board/delete.do")
	public void delete(int no) 
					throws Exception {
		mapper.deleteBoard(no);
		session.commit();
		
	}
	
	@RequestMapping("/board/list.do")
	public ModelAndView list(@RequestParam(value="pageNo", defaultValue="1") int pageNo) throws Exception {
		System.out.println("pageNo="+pageNo);
		List<BoardVO> list = mapper.selectBoard();
		
		ModelAndView mav = new ModelAndView("/board/list");
		
		// 공유
		mav.addObject("list", list);
		// 화면 페이지 이동
		return	mav;
	}
	@RequestMapping("/board/update.do")
	public void update(BoardVO boardVO) 
					throws Exception {

		mapper.updateBoard(boardVO);
		session.commit();
		
	}
	
	@RequestMapping("/board/updateForm.do")
	public ModelAndView updateForm(int no) 
					throws Exception {
		ModelAndView mav = new ModelAndView("/board/updateForm");
		BoardVO board = mapper.selectBoardByNo(no);
		
		// 공유
//		request.setAttribute("board", board);
		mav.addObject("board", board);
		// 화면 페이지 이동
		return mav;
	}
	
	@RequestMapping("/board/write.do")
	public void write(
			HttpServletRequest request) 
					throws Exception {
		
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		
		// upload 하위에 모듈별 날짜 형태의 디렉토리 생성후 저장
		SimpleDateFormat sdf = new SimpleDateFormat(
			"/yyyy/MM/dd"	
		);
		String datePath = sdf.format(new Date());
		
		uploadPath += datePath;
		
		File f = new File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		// 파일 처리를 위한 API 클래스 호출
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				uploadPath, 
				1024 * 1024 * 10, 
				"UTF-8",
				new BitFileRenamePolicy()
		);
		
		BoardVO boardVO = (BoardVO)WebUtil.toVO(mRequest, BoardVO.class);
		mapper.insertBoard(boardVO);

		File file = mRequest.getFile("attachFile");
		if (file != null) {
			String oriName = mRequest.getOriginalFileName("attachFile");
			String systemName = mRequest.getFilesystemName("attachFile");
			long fileSize = file.length();
			
			BoardFileVO boardFile = new BoardFileVO();
			boardFile.setNo(boardVO.getNo());
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
			boardFile.setFilePath(datePath);
			boardFile.setFileSize(fileSize);
			
			mapper.insertBoardFile(boardFile);
		}
			
	}
	
	@RequestMapping("/board/writeForm.do")
	public void writeForm() 
					throws Exception {
		
	}
}
