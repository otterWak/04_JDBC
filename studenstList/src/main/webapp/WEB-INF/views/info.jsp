<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${student.stdName} 학생 정보</title>
    <link rel="stylesheet" href="/resources/css/info.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>${student.stdNo}.${student.stdName}</h1>
        </div>
        
        <div class="student-info">
            <div class="info-item">
                <div class="info-label">나이</div>
                <div class="info-value">${student.stdAge}세</div>
            </div>
            
            <div class="info-item">
                <div class="info-label">성별</div>
                <div class="info-value">${student.stdGen}</div>
            </div>
            
            <div class="info-item">
                <div class="info-label">학점</div>
                <div class="info-value">${student.stdScore}</div>
            </div>
        </div>
        
        <div class="button-container">
            <button class="btn btn-list" id="goToList">목록으로</button>
            <button class="btn btn-edit" id="updateBtn">수정</button>
            <button class="btn btn-delete" id="deleteBtn">삭제</button>
        </div>
    </div>
</body>
</html>