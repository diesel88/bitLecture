package kr.co.mlec.board.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.ConnectionPool;

import java.util.ArrayList;

/**
 * 게시물에 대한 데이터를 처리하는 DAO 클래스
 * @author Administrator
 */
public class BoardDAO {
	
	private static SqlSession sqlMapper;
	private static final String NS = "kr.co.mlec.board.mapper.BoardMapper";
	
	static {
		try {
			String resource = "config/mybatis/sqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlMapper = sqlFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}
	/**
	 *  문서화 주석문
	 *  클래스, 메서드, 멤버변수에 대한 설명을 할 경우 사용
	 *  전체 게시물을 조회하는 기능의 메서드 
	 */
	public List<BoardVO> selectBoard() {
		return sqlMapper.selectList(NS + ".selectBoard");
		
	}
	
	public BoardVO selectOneBoard(int no) {
		return sqlMapper.selectOne(NS + ".selectOneBoard", no);
	}

	public void insertBoard(BoardVO board) {
		sqlMapper.insert(NS + ".insertBoard", board);
	}
	public boolean updateBoard(BoardVO board) {
		return sqlMapper.update(NS + ".updateBoard", board) == 1;
	}
	public boolean deleteBoard(int no) {
		return sqlMapper.delete(NS + ".deleteBoard", no) == 1;
	}
	
}









