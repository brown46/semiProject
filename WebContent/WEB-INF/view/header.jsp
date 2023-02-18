  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${not empty sessionScope.lgnss }">		
		<a href="./">홈</a>		
		<a href="./logout">로그아웃</a>
		<a href="./mypage">마이페이지</a>		
	</c:when>
	<c:otherwise>
		<a href="./">홈</a>		
		<a href="./login">로그인</a>
		<a href="./enroll">회원가입</a>
	</c:otherwise>
</c:choose>