<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<script src="./resource/js/myJavascript.js" type="text/javascript" 	></script>
</head>
<body>
	
	<form action="./enroll" method="post">
		<div>
			<label>아이디 :</label>		
			<input type="text" name=id>
		<button type="button">아이디 중복 체크</button>
		</div>
		<div>
			<label>닉네임 :</label>		
			<input type="text" name=nickname>
		<button type="button">닉네임 중복 체크</button>
		</div>
		<div>
			<label>이메일 :</label> 
			<input type="text" name=email>		
		</div>
		<div>
			<label>비밀번호 :</label> 
			<input type="password" name=password>		
		</div>
		<div>
			<label>비밀번호 확인 :	</label> 		
			<input type="password" name=passwordChk>
		</div>
		
		<button type="submit">회원 가입</button>
		
		<c:if test=""></c:if>
		
	</form>
	
	
</body>
</html>