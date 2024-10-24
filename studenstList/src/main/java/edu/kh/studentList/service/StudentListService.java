package edu.kh.studentList.service;

import java.util.List;

import edu.kh.studentList.dto.Student;

public interface StudentListService {

	List<Student> studentListView() throws Exception;

	Student studentInfoView(int stdNo) throws Exception;


}
