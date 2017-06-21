package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;

public class DetailController implements Controller {

	private SqlSession session = null;
	private BoardMapper mapper = null;
	public DetailController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	@Override
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		ModelAndView mav = new ModelAndView("/view/board/detail.jsp");
		int no = Integer.parseInt(request.getParameter("no"));
		
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
}