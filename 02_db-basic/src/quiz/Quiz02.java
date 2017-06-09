package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Quiz02 {
	public static void main(String[] args) {
		System.out.println("===========================================");
		view("employees");
		System.out.println("===========================================");
		view("tb_board");
	}
	
	public static void view(String tbName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			String sql = "select * from " + tbName;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// result의 결과 컬럼 수를 반환
			int count = rsmd.getColumnCount();
			System.out.println("컬럼 수 : " + count);
			for (int i = 1; i <= count; i++) {
				String cName = rsmd.getColumnName(i);
				System.out.print(cName + (i == count ? "\n" : "\t"));
			}
			System.out.print("\n");
			while(rs.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs.getString(i) + (i == count ? "\n" : "\t"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}
