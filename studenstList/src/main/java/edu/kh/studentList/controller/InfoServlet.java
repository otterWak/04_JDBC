package edu.kh.studentList.controller;

import java.io.IOException;

import edu.kh.studentList.dto.Student;
import edu.kh.studentList.service.StudentListService;
import edu.kh.studentList.service.StudentListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/info")
public class InfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int stdNo = Integer.parseInt( req.getParameter("stdNo") );
			
			StudentListService service = new StudentListServiceImpl();
			
			Student student = service.studentInfoView(stdNo);
			
			if(student == null) {
				HttpSession session = req.getSession();
				session.setAttribute("message", "학생이 존재하지 않습니다");
				
				resp.sendRedirect("/");
				return;
			}
			
			req.setAttribute("student", student);
			
			String path = "/WEB-INF/views/info.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
