package kr.co.mlec.board.ui;

import kr.co.mlec.board.mapper.BoardMapper2;

public class DeleteUI extends GenericUI {

//	private BoardDAO dao;
	private BoardMapper2 dao;
	
	public DeleteUI(BoardMapper2 dao) {
		this.dao = dao;
	}

	@Override
	public void service() throws Exception {
		System.out.print("삭제할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		// 삭제 요청
		// flag : true(삭제 성공), false(삭제 실패)
		boolean flag = (dao.deleteBoard(no) == 1);
		if (flag == false) {
			System.out.println(
					no + "번에 해당하는 게시글이 존재하지 않습니다.");
		} else {
			System.out.println("게시글이 삭제되었습니다.");
		}
	}

}
