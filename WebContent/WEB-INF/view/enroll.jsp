<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>


</head>
<body>
	
	<form action="./dupChk" method="post">
		<div>
			<label>아이디 :</label>		
			<input type="text" name=id  >
			
		</div>

		<div>
			<label>닉네임 :</label>		
			<input type="text" name=nickname >
		</div>
			<button id="dupChk" type="button" >아이디/닉네임 중복 체크</button>
	</form>	
	<form action="./enroll" method="post">
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
		
	</form>


</body>
</html>
<script src="https://code.jquery.com/jquery-3.6.3.js" charset="UTF-8"></script>
<script src="./resource/js/myJavascript.js" type="text/javascript" charset="UTF-8"></script>

