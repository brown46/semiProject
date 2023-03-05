<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
</head>
<body>
<c:choose>
	<c:when test="${nickCount eq 0 && idCount eq 0 }"><h1>사용가능한 아이디와 닉네임입니다.</h1></c:when>
	<c:when test="${nickCount eq 0 && idCount ne 0 }"><h1>중복된 아이디가 존재합니다.</h1></c:when>
	<c:when test="${nickCount ne 0 && idCount eq 0 }"><h1>중복된 닉네임이 존재합니다.</h1></c:when>
	<c:when test="${nickCount ne 0 && idCount ne 0 }"><h1>중복된 아이디와 닉네임이 존재합니다.</h1></c:when>
</c:choose>

</body>
</html>