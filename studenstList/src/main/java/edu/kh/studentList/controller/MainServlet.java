package edu.kh.studentList.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.studentList.dto.Student;
import edu.kh.studentList.service.StudentListService;
import edu.kh.studentList.service.StudentListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/main")
public class MainServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			StudentListService service = new StudentListServiceImpl();
			
			List<Student> studentList = service.studentListView();
			
			req.setAttribute("studentList", studentList);
			
			String path = "WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
