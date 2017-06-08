package kr.co.mlec.board.file.mapper;

import kr.co.mlec.board.file.vo.BoardFileVO;

public interface BoardFileMapper {
	public int insertBoardFile(BoardFileVO boardFileVO);
	public BoardFileVO selectBoardFile(int no);
}
