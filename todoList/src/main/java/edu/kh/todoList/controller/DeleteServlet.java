package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.service.TodoListService;
import edu.kh.todoList.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int todoNo = Integer.parseInt(req.getParameter("todoNo") );
			
			TodoListService service = new TodoListServiceImpl();
			
			int result = service.todoDelete(todoNo);

			
			HttpSession session = req.getSession();
					
			// 삭제 성공 시
			// -> 메인 페이지로 redirect
			// -> message로 "완료 여부가 변경되었습니다!"
			if(result>0) {
				session.setAttribute("message", "할 일이 삭제 되었습니다");
				resp.sendRedirect("/");
				return;
			}
			
			// 삭제 실패 시
			// -> 메인 페이지로 redirect
			// -> message로 "todo가 존재하지 않습니다"
			session.setAttribute("message", "todo가 존재하지 않습니다");
			resp.sendRedirect("/");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
