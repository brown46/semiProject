<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
	<form action="./login" method="post">
		<div>
			<label>아이디 :</label>		
			<input type="text" name=id  >	
		</div>
		<div>
			<label>비밀번호 :</label>		
			<input type="password" name=password >
		</div>
			<button >로그인</button>
	</form>	
	<c:if test="${not empty error }">
		${error }
	</c:if>
	<script type="text/javascript">
	
	</script>
</body>
</html>