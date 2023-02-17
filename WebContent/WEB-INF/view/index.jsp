<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
메인페이지
<c:choose>
	<c:when test="${not empty sessionScope.lgnss }">		
		<a href="./logout">로그아웃</a>
		
		
		
		
	</c:when>
	<c:otherwise>
		<a href="./login">로그인</a>
		<a href="./enroll">회원가입</a>
	</c:otherwise>
</c:choose>

</body>
</html>