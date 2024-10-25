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

@WebServlet("/student/update")
public class updateServlet extends HttpServlet{

	// 업데이트 화면 전환 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
		try {
			StudentListService service = new StudentListServiceImpl();
			
			Student student = service.studentInfoView(Integer.parseInt(req.getParameter("stdNo")));
			
			req.setAttribute("student",student);
			
			String path = "/WEB-INF/views/update.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	// 내용 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String stdName = req.getParameter("stdName");
			int stdAge = Integer.parseInt(req.getParameter("stdAge"));
			String stdGen = req.getParameter("stdGen");
			String stdScore = req.getParameter("stdScore");
			int stdNo = Integer.parseInt(req.getParameter("stdNo"));
			
			StudentListService service = new StudentListServiceImpl();
			int result = service.stdUpdate(stdName, stdAge, stdGen, stdScore, stdNo);
			
			String url = null;
			String message = null;
			
			if(result>0) {
				url = "/student/info?stdNo=" + stdNo;
				message = "수정 완료";
			} else {
				url = "/student/update?stdNo=" +stdNo;
				message = "수정 실패";
			}
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(url);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
