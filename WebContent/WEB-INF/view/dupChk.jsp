<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${nickCount eq 0 && idCount eq 0 }"><h1>�ߺ� �ƴ�</h1></c:when>
	<c:when test="${nickCount eq 0 && idCount ne 0 }"><h1>���̵� �ߺ�</h1></c:when>
	<c:when test="${nickCount ne 0 && idCount eq 0 }"><h1>�г��� �ߺ�</h1></c:when>
	<c:when test="${nickCount ne 0 && idCount ne 0 }"><h1>�Ѵ� �ߺ�</h1></c:when>
</c:choose>

</body>
</html>