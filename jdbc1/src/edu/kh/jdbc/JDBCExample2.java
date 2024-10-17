package edu.kh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample2 {

	public static void main(String[] args) {
		
		// 입력 받은 급여보다 초과해서 받는 사원의
		// 사번, 이름, 급여 조회
		
		// 1. JDBC 객체 참조용 변수 선언
		Connection conn = null; // DB연결정보 저장 객체
		Statement stmt = null ; // SQL 수행, 결과 반환용 객체
		ResultSet rs = null;	// SELECT 수행 결과 저장 객체
		
		Scanner sc = new Scanner(System.in);
		
		
		try {
			// 2. DriverManager 객체를 이용해서 Connection 객체 생성
			// 2-1) Oracle JDBC Driver 객체 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2-2) DB 연결 정보 작성
			String type = "jdbc:oracle:thin:@";
			String host = "localhost";
			String port = ":1521";
			String dbName = ":XE";
			String userName = "kh_lhg";
			String password = "kh1234";
			
			// 2-3) DB 연결 정보와 DriverManager를 이용해서 Connection 객체 생성
			conn = DriverManager.getConnection(type + host + port + dbName, userName, password);
			
			// 3. SQL 작성
			//    입력받은 급여 -> Scanner 필요
			//    int input 여기에 급여 담기
			System.out.print("급여 입력 : ");
			int input = sc.nextInt();
			
			String sql = "SELECT EMP_ID , EMP_NAME , SALARY "
					+ "FROM EMPLOYEE "
					+ "WHERE SALARY > " + input;
			
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기
			// 	  executeQuery() : SELECT 실행, ResultSet 반환
			//    executeUpdate() : DML 실행, 결과 행의 개수 반환(int)
			rs = stmt.executeQuery(sql);
			
			/* 6. 조회 결과가 담겨있는 ResultSet을
			 * 	  커서(Cursor)를 이용해 
			 *    한 행 씩 접근해 각행에 작성된 컬럼 값 얻어오기
			 *    -> while 안에서 꺼낸 데이터 출력
			 *    
			 *    201 / 송종기 / 6000000원
			 * */
			
			System.out.println("\n<급여가 " +input+ "원 넘는 사원 명단>");
			System.out.println("==================================\n EMP_ID | EMP_NAME |   SALARY\n==================================");
			while(rs.next()) {
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				System.out.printf("   %s  |  %s  |  %s원 \n", empId, empName, salary);
				System.out.println("----------------------------------");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// 7. 사용 완료된 JDBC 객체 자원 반환(close)
				// 	  -> 생성된 역순으로 close
				if( rs != null ) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
