package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test03 {
	public static void main(String[] args) {
		// TB_BOARD 테이블에 행 추가하는 프로그램 작성
		// 입력할 때 시퀀스(S_BOARD_NO) 활용
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String sql = "insert into tb_board(no, title, writer, content) "
					+ "values(s_board_no.nextval, 'test', '홍길동2','하하하')";
			PreparedStatement pstmt = con.prepareStatement(sql);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt+"개의 행이 추가되었습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
