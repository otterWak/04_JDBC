package edu.kh.studentList.controller;

import java.io.IOException;

import edu.kh.studentList.service.StudentListService;
import edu.kh.studentList.service.StudentListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/add")
public class AddServlet extends HttpServlet{

	// 페이지 띄우기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String path = "/WEB-INF/views/add.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String stdName = req.getParameter("stdName");
			int stdAge = Integer.parseInt(req.getParameter("stdAge"));
			String stdGen = req.getParameter("stdGen");
			String stdScore = req.getParameter("stdScore");
			
			StudentListService service = new StudentListServiceImpl();
			int result = service.stdAdd(stdName, stdAge, stdGen, stdScore);
			
			
			HttpSession session = req.getSession();
			
			if(result>0) {
				session.setAttribute("message", "추가 완료");
				resp.sendRedirect("/");
				return;
			}
			

			session.setAttribute("message", "추가 실패");
			resp.sendRedirect("/student/add");

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
