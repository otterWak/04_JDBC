<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 목록</title>
    <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
	<h1>학생 관리 시스템</h1>
	<div class="container">
		<table id="studentList">
			<thead>
				<tr class="student-tr">
					<th class="student-th">학생 목록</th>
				</tr>
			</thead>
			
			<tbody>
			    <c:forEach items = "${studentList}" varStatus="vs" var="student">
			    	<tr class="student-tr">
			    		<td class="student-th">
			    			<a href="/student/info?stdNo=${student.stdNo}">${student.stdName}</a>
			    		</td>
			    	</tr>
			    </c:forEach>
			</tbody>
		</table>
	    
	    <button class="add-button">
	        학생 추가
	    </button>
	    
	</div>

	<c:if test="${not empty sessionScope.message}">
	  	<script>
	  		alert("${message}")
	  	</script>
 	
		<c:remove var = "message" scope="session"/>
	</c:if>


	<script src="/resources/js/main.js"></script>

</body>
</html>