package edu.kh.studentList.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.studentList.dao.StudentListDAO;
import edu.kh.studentList.dao.StudentListDAOImpl;
import edu.kh.studentList.dto.Student;
import static edu.kh.studentList.common.JDBCTemplate.*;

public class StudentListServiceImpl implements StudentListService{

	private StudentListDAO dao = new StudentListDAOImpl();
	
	@Override
	public List<Student> studentListView() throws Exception {
		
		
		Connection conn = getConnection();
		List<Student> studentList = dao.studentListView(conn);
		close(conn);
		return studentList;
	}

	
	@Override
	public Student studentInfoView(int stdNo) throws Exception {
		
		Connection conn = getConnection();
		Student student = dao.studentInfoView(conn, stdNo);
		close(conn);
		return student;
	}


	@Override
	public int stdUpdate(String stdName, int stdAge, String stdGen, String stdScore, int stdNo) throws Exception {

		Connection conn = getConnection();
		int result = dao.stdUpdate(conn ,stdName, stdAge, stdGen, stdScore, stdNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}


	@Override
	public int stdDelete(int stdNo) throws Exception {

		Connection conn = getConnection();
		int result = dao.stdDelete(conn, stdNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}


	@Override
	public int stdAdd(String stdName, int stdAge, String stdGen, String stdScore) throws Exception {
		Connection conn = getConnection();
		int result = dao.stdAdd(conn, stdName, stdAge, stdGen, stdScore);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}







	
	
	
	
	
	

}
