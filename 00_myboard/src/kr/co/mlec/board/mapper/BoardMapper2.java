package kr.co.mlec.board.mapper;

import java.util.List;

import kr.co.mlec.board.vo.BoardVO;

public interface BoardMapper2 {
	List<BoardVO> selectBoard() throws Exception;
	BoardVO selectOneBoard(int no) throws Exception;
	int insertBoard(BoardVO param) throws Exception;
	int updateBoard(BoardVO param) throws Exception;
	int deleteBoard(int no) throws Exception;
}
