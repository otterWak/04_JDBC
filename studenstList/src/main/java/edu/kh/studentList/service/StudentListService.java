package edu.kh.studentList.service;

import java.util.List;

import edu.kh.studentList.dto.Student;

public interface StudentListService {

	List<Student> studentListView() throws Exception;

	Student studentInfoView(int stdNo) throws Exception;

	int stdUpdate(String stdName, int stdAge, String stdGen, String stdScore, int stdNo) throws Exception;

	int stdDelete(int stdNo) throws Exception;

	int stdAdd(String stdName, int stdAge, String stdGen, String stdScore) throws Exception;





}
