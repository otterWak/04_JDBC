package edu.kh.studentList.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.studentList.dto.Student;

public interface StudentListDAO {

	List<Student> studentListView(Connection conn) throws Exception;
	
	Student studentInfoView(Connection conn, int stdNo) throws Exception;

}
