package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam01 {
	public static void main(String[] args) {
		System.out.println("=======================================");
		printEmployee("cisco", 100);
		System.out.println("=======================================");
		printEmployee("attle", 15000);
		System.out.println("=======================================");
	}

	private static void printEmployee(String cityName, int salary) {
		Connection con= null;
		PreparedStatement pstmt= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String sql = "select l.city, e.first_name, e.salary "
						+ "from employees e "
						+ "inner join departments d "
						+ "on e.department_id = d.department_id "
						+ "inner join locations l "
						+ "on d.location_id = l.location_id "
						+ "where l.city like ? and e.salary >= ?";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+cityName+"%");
			pstmt.setInt(2, salary);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("city") + "\t" +
									rs.getString("first_name") + "\t" +
									rs.getInt("salary"));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
