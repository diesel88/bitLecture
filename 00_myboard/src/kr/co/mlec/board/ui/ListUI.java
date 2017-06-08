package kr.co.mlec.board.ui;

import java.util.List;

import kr.co.mlec.board.mapper.BoardMapper2;
import kr.co.mlec.board.vo.BoardVO;

public class ListUI extends GenericUI{
//	private BoardDAO dao;
	private BoardMapper2 dao;
	public ListUI(BoardMapper2 dao) {
		this.dao = dao;
	}
	public void service() throws Exception {
		List<BoardVO> list = dao.selectBoard();
		
		System.out.println("---------------------------");
		System.out.println("번호\t제목\t글쓴이");
		System.out.println("---------------------------");
		for (BoardVO b : list) {
			System.out.printf(
					"%d\t%s\t%s\n", b.getNo(), b.getTitle(), b.getWriter());
		}
		if (list.size() == 0) {
			System.out.println("게시물이 존재하지 않습니다.");
		}
		System.out.println("---------------------------");
	}
}
