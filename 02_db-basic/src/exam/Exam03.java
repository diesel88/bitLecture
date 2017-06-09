package exam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

import util.ConnectionPool;

public class Exam03 {
	public static void makeVO() throws Exception {
		Scanner sc = new Scanner(System.in);
		File path = new File("data/");
		if(!path.exists()) {
			path.mkdirs();
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		while (true) {
			System.out.println("VO로 만들 테이블명을 입력하세요.(종료:exit) : ");
			String tbName = sc.nextLine();
			String sql = "select * from " + tbName;
			Connection con = ConnectionPool.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cnt = rsmd.getColumnCount();
		}
	}
	public static void main(String[] args) {
		
	}
}
