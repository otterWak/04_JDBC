package edu.kh.todoList.service;

import java.util.Map;

import edu.kh.todoList.dto.Todo;

public interface TodoListService {

	/** 할 일 목록 반환 서비스
	 * @return todoList + 완료된 개수
	 */
	Map<String, Object> todoListFullView() throws Exception;

	
	/** 할 일 추가 서비스
	 * @param title
	 * @param detail
	 * @return int 성공 시 추가된 행의 개수 / 실패 시 0 반환
	 * @throws Exception
	 */
	int todoAdd(String title, String detail) throws Exception;


	/** 할 일 상세 조회 서비스
	 * @param todoNo
	 * @return null 또는 todo 객체
	 * @throws Exception
	 */
	Todo todoDetailView(int todoNo) throws Exception;


	/** 완료 여부 변경 서비스
	 * @param todoNo
	 * @return 완료된 행의 개수, int
	 * @throws Exception
	 */
	int todoComplete(int todoNo) throws Exception;


	int todoDelete(int todoNo) throws Exception;


	/** 할 일 수정 서비스
	 * @param title
	 * @param detail
	 * @param todoNo
	 * @return
	 * @throws Exception
	 */
	int todoUpdate(String title, String detail, int todoNo) throws Exception;

}
