package kr.co.mlec.board.ui;

import kr.co.mlec.board.mapper.BoardMapper2;
import kr.co.mlec.board.vo.BoardVO;

public class WriteUI extends GenericUI{

//	private BoardDAO dao = null;
	private BoardMapper2 dao;
	public WriteUI(BoardMapper2 dao){
		this.dao = dao;
	}
	@Override
	public void service() throws Exception {
		// TODO Auto-generated method stub
		BoardVO board = new BoardVO();
		System.out.print("제목을 입력하세요 : ");
		board.setTitle(sc.nextLine());
		System.out.print("글쓴이를 입력하세요 : ");
		board.setWriter(sc.nextLine());
		System.out.print("내용을 입력하세요 : ");
		board.setContent(sc.nextLine());
		
		dao.insertBoard(board);
		
		System.out.println("게시물이 등록되었습니다.");
	}

}
