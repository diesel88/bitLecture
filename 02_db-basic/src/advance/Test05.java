package advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test05 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String tbName = "employees";
			String sql = "select * from " + tbName;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// result의 결과 컬럼 수를 반환
			int count = rsmd.getColumnCount();
			System.out.println("컬럼 수 : " + count);
			for (int i = 1; i <= count; i++) {
				String cName = rsmd.getColumnName(i);
				System.out.println(cName);
				String tName = rsmd.getColumnTypeName(i);
				System.out.println(cName + "\t" + tName);
			}
			String cName = rsmd.getColumnName(2);
			System.out.println(cName);
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}
