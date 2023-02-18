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
	<c:when test="${nickCount eq 0 && idCount eq 0 }"><h1>중복 아님</h1></c:when>
	<c:when test="${nickCount eq 0 && idCount ne 0 }"><h1>아이디 중복</h1></c:when>
	<c:when test="${nickCount ne 0 && idCount eq 0 }"><h1>닉네임 중복</h1></c:when>
	<c:when test="${nickCount ne 0 && idCount ne 0 }"><h1>둘다 중복</h1></c:when>
</c:choose>

</body>
</html>