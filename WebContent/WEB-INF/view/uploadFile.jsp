<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./uploadfile" enctype="multipart/form-data" method="post">
		<input name="postId" type="hidden" value="${param.postId }" >
		
		<input type="file" name="uploadFile"><br>
		
		<button>업로드</button>
	</form>
	<c:set  value="${param.postId }" var = "name"/>

<%session.setAttribute("postId", pageContext.getAttribute("name").toString()); %>	
</body>
</html>