package edu.kh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDCBExample4 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";
			String host = "localhost";
			String port = ":1521";
			String dbName = ":XE";
			String userName = "kh_lhg";
			String password = "kh1234";
			
			conn = DriverManager.getConnection(type + host + port + dbName, userName, password);
			

			Scanner sc = new Scanner(System.in);
			System.out.print("부서명 입력 : ");
			String input = sc.nextLine();
			
			
			String sql = "SELECT EMP_ID , EMP_NAME , NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME "
					+ "FROM EMPLOYEE "
					+ "JOIN JOB USING(JOB_CODE) "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) "
					+ "WHERE DEPT_TITLE = '"+input+"'";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			

			boolean flag = true;
			// 조회 결과 있다면 false, 없으면 true
			
			while(rs.next()) {
				flag = false;
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("%s / %s / %s / %s\n", empId, empName, deptTitle, jobName);

			}
			
			if(flag) { // flag == true == while문이 수행된 적 없음
				System.out.println("일치하는 부서가 없습니다!");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
