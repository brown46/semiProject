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
	<div class="container">
	<form action="./login" method="post">
		<div>
			<label class="mt-3">아이디 :</label>		
			<input class="form-control w-50" type="text" name=id  >	
		</div>
		<div>
			<label class="mt-3">비밀번호 :</label>		
			<input class="form-control w-50" type="password" name=password >
		</div>
		<div>
			<button class="mt-3 w-25 btn btn-lg btn-primary" >로그인</button>
		</div>
	</form>	
	<c:if test="${not empty error }">
		${error }
	</c:if>
	</div>
	<script type="text/javascript">
	
	</script>
</body>
</html>