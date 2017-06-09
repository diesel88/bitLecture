package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class Test09 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			String sql = "insert into tb_board( "
					+ "no, title, writer,content, reg_date "
					+ ") values ( "
					+ " s_board_no.nextval, ? ,? , ?, ? "
					+ ")";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "동적인 값 입력");
			pstmt.setString(2, "whitelove");
			pstmt.setString(3, "자바에서 입력");
			pstmt.setDate(4, new Date(new java.util.Date().getTime()));
			int cnt = pstmt.executeUpdate();

			System.out.println(cnt + "개의 행이 처리됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
