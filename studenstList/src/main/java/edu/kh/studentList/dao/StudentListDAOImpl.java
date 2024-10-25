package edu.kh.studentList.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.studentList.dto.Student;
import edu.kh.studentList.dto.Student;
import static edu.kh.studentList.common.JDBCTemplate.*;

public class StudentListDAOImpl implements StudentListDAO{
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public StudentListDAOImpl() {
		
		try {
			
			String filePath 
			= StudentListDAOImpl.class.getResource("/xml/sql.xml").getPath();
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			System.out.println("sql.xml 로드 중 예외발생");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Student> studentListView(Connection conn) throws Exception {
		
		List<Student> studentList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("studentListView");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Student student = Student.builder()
								  .stdNo(rs.getInt("STD_NO"))
								  .stdName(rs.getString("STD_NAME"))
								  .stdAge(rs.getInt("STD_AGE"))
								  .stdGen(rs.getString("STD_GENDER"))
								  .stdScore(rs.getString("STD_SCORE"))
								  .build();
				
				studentList.add(student);
			}
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		return studentList;
	}

	
	@Override
	public Student studentInfoView(Connection conn, int stdNo) throws Exception {
		Student student = null;
		
		try {
			String sql = prop.getProperty("studentInfoView");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = Student.builder()
						  .stdNo(rs.getInt("STD_NO"))
						  .stdName(rs.getString("STD_NAME"))
						  .stdAge(rs.getInt("STD_AGE"))
						  .stdGen(rs.getString("STD_GENDER"))
						  .stdScore(rs.getString("STD_SCORE"))
						  .build();
			}
		}finally{
			close(rs);
			close(pstmt);
		}
		
		
		return student;
	}

	@Override
	public int stdUpdate(Connection conn, String stdName, int stdAge, String stdGen, String stdScore, int stdNo)
			throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("stdUpdate");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stdName);
			pstmt.setInt(2, stdAge);
			pstmt.setString(3, stdGen);
			pstmt.setString(4, stdScore);
			pstmt.setInt(5, stdNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	@Override
	public int stdDelete(Connection conn, int stdNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("stdDelete");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	@Override
	public int stdAdd(Connection conn, String stdName, int stdAge, String stdGen, String stdScore) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("stdAdd");
			
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, stdName);
			pstmt.setInt(2, stdAge);
			pstmt.setString(3, stdGen);
			pstmt.setString(4, stdScore);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

}
