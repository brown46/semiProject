<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
<h4>정말로 탈퇴하시겠습니까?</h4>
작성했던 게시물들이 삭제됩니다.
<form action="./withdrawal" method="post">
	<button id="withdrawal" type="button">탈퇴</button>
</form>
</body>
<script type="text/javascript">

$("#withdrawal").on("click",withdrawal);
function withdrawal() {
 $.ajax({
		url :  "withdrawal",
		type : "post",
		success: function(){
			alert("탈퇴처리 되었습니다.");
			location.href="<%=request.getContextPath()%>/logout"
		},
		error: function(){
			console.log("실패");
		},
		complete:function(){
			console.log("무조건 호출");

		},
	 });
}
</script>
</html>