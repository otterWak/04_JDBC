<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${student.stdName} 학생 정보 수정</title>
    <link rel="stylesheet" href="/resources/css/update.css">
</head>
<body>
    <div class="container">
        <h2>학생 정보 입력</h2>
        <form action="/student/update" method="post">
        <input type="hidden" name="stdNo" value="${param.stdNo}">
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" id="name" name="stdName" value="${student.stdName}" required>
            </div>

            <div class="form-group">
                <label for="age">나이</label>
                <input type="number" id="age" name="stdAge" values="${student.stdAge}" required>
            </div>

            <div class="form-group">
                <label>성별</label>
                <div class="radio-group">
                    <div class="radio-item">
                        <input type="radio" id="male" name="stdGen" value="M" required>
                        <label for="male">남자</label>
                    </div>
                    <div class="radio-item">
                        <input type="radio" id="female" name="stdGen" value="F" required>
                        <label for="female">여자</label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label>성적</label>
                <div class="radio-group">
                    <div class="radio-item">
                        <input type="radio" id="gradeA" name="stdScore" value="A" required>
                        <label for="gradeA">A</label>
                    </div>
                    <div class="radio-item">
                        <input type="radio" id="gradeB" name="stdScore" value="B" required>
                        <label for="gradeB">B</label>
                    </div>
                    <div class="radio-item">
                        <input type="radio" id="gradeC" name="stdScore" value="C" required>
                        <label for="gradeC">C</label>
                    </div>
                    <div class="radio-item">
                        <input type="radio" id="gradeD" name="stdScore" value="D" required>
                        <label for="gradeD">D</label>
                    </div>
                    <div class="radio-item">
                        <input type="radio" id="gradeF" name="stdScore" value="F" required>
                        <label for="gradeF">F</label>
                    </div>
                </div>
            </div>

            <div class="button-group">
                <input type="submit" value="제출">
            </div>
            
        </form>
    </div>
    
            
	<c:if test="${not empty sessionScope.message}">
	  	<script>
	  		alert("${message}")
	  	</script>
 	
		<c:remove var = "message" scope="session" />
	</c:if>

    
</body>
</html>