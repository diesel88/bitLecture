package kr.co.mlec.board.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.vo.PageVO;

public class BoardMapper {
	private static SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	// 전체 게시글 조회
	public List<BoardVO> selectBoard(PageVO search) {
		List<BoardVO> boardList = sqlMapper.selectList("kr.co.mlec.board.dao.BoardMapper.selectBoard", search);
		return boardList;
	}
	
	// 전체 게시글 카운트 조회
	public int selectBoardCount(PageVO search) {
		return sqlMapper.selectOne("kr.co.mlec.board.dao.BoardMapper.selectBoardCount", search);
	}
}














