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

@WebServlet("/student/delete")
public class deleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			
			StudentListService service = new StudentListServiceImpl();
			
			int result = service.stdDelete(stdNo);
			
			HttpSession session = req.getSession();
			
			if(result>0) {
				session.setAttribute("message", "삭제 완료");
				resp.sendRedirect("/");
				return;
			}
			

			session.setAttribute("message", "삭제 실패");
			resp.sendRedirect("/");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
