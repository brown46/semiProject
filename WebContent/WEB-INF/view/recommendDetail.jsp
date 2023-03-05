<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />

	<div class="container mt-5">
		<div class="mt-3">
			<h2>중복되는 상위 3개 장르를 가지고 있는 게임들입니다.</h2>
		</div>
		<div  class="mt-3" >
			<h5>장르 ${top3[0]}을/를 포함하는 게임들 ${list0 }</h5>
		</div>
		<div  class="mt-3">
			<h5>장르 ${top3[1]}을/를 포함하는 게임들 ${list1 }</h5>
		</div>
		<div  class="mt-3">
			<h5>장르 ${top3[2]}을/를 포함하는 게임들 ${list2 }</h5>
		</div>

	</div>
</body>
</html>