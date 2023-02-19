<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<meta charset="UTF-8">

<title>마이페이지</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
<h2>마이페이지</h2>
${sessionScope.lgnss.nickname }님 
<br>
이메일: ${sessionScope.lgnss.email }

<h1><a href="<%=request.getContextPath()%>/myposting">내 게시물 확인 </a> </h1>
<h1> <a href="<%=request.getContextPath()%>/updateinfo">회원 정보 수정</a> </h1>
<h1> <a href="<%=request.getContextPath()%>/withdrawal">회원 탈퇴</a> </h1>



</body>
</html>