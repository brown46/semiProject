<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<meta charset="UTF-8">
<title>게시글 상세</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
<br>
<div>
	게시글 이름 ${post.postName }
</div>
<div>
닉네임  ${post.nickname }
</div>
<div>
게임 이름 ${post.gameName }
</div>
<div>
게임 장르 ${genreList }
</div>
<div>
작성일  ${post.nowDate }
</div>
<div>
게임 스크린샷
<img alt="" src="">
</div>

<div>
내용
${post.contents }
</div>


<div>
댓글 내용
</div>
<div>
댓글창
<input size="100px">
</div>




</body>
</html>