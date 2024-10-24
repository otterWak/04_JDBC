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

	
	
	
	
	
	

}
