package edu.kh.todoList.dao;

import java.sql.Connection;
import java.util.List;

import edu.kh.todoList.dto.Todo;

public interface TodoListDAO {

	/** 할 일 목록 전체 조회
	 * @param conn
	 * @return todoList
	 */
	List<Todo> todoListFullView(Connection conn) throws Exception;

	
	/** 완료된 할 일 개수 조회
	 * @param conn
	 * @return 완료된 개수
	 */
	int getCompleteCount(Connection conn) throws Exception;


	/** 할 일 추가
	 * @param conn
	 * @param title
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	int todoAdd(Connection conn, String title, String detail) throws Exception;


	/** 할 일 상세 조회
	 * @param conn
	 * @param todoNo
	 * @return todo 객체 or null
	 * @throws Exception
	 */
	Todo todoDetailView(Connection conn, int todoNo) throws Exception;


	/** 완료 여부 변경 DAO
	 * @param conn
	 * @param todoNo
	 * @return 완료된 행의 개수, int
	 * @throws Exception
	 */
	int todoComplete(Connection conn, int todoNo) throws Exception;


	int todoDelete(Connection conn, int todoNo) throws Exception;


	/** 할 일 수정 DAO
	 * @param conn
	 * @param title
	 * @param detail
	 * @param todoNo
	 * @return
	 * @throws Exception
	 */
	int todoUpdate(Connection conn, String title, String detail, int todoNo) throws Exception;

}
