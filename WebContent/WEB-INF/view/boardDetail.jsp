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
댓글
<br>
<ul>
닉네임 | 작성일 | 댓글 내용	
<c:forEach items="${cList }" var="cl">
<li>${cl.nickname} | ${cl.nowdate} | ${cl.cmt}</li> 
</c:forEach>
</ul>
</div>
<div>
<c:choose>
<c:when test="${! empty lgnss}">
	<form action="./detail" method="post">
		<input  name="postid" type="hidden" value="${post.postId }">
		<label>댓글작성</label>
		<input id="input" name="comment" size="100px">
			<button disabled id="submit">작성</button>	
	</form>
</c:when>
<c:otherwise>
	<input name="postid" type="hidden" value="${post.postId }">
	<label>댓글작성</label>
	<input id="textarea" name="comment" size="100px">
	<button id="dummy" type="button">작성</button>	
</c:otherwise>
</c:choose>

</div>


<script type="text/javascript">
	$("#dummy").on("click",toLogin);
	function toLogin(){
		alert("로그인 후 작성 가능합니다.");
		location.href="<%=request.getContextPath()%>/login";
	}
	$('#textarea').keypress(function(event){
	     if ( event.which == 13 ) {
	         $('#dummy').click();
	         return false;
	     }
	});

	$(function(){
		$('#input').on('input' ,function(){
			if($('#input').val()=='')
				$ ('#submit').attr('disabled', true);
			else
				$('#submit').attr('disabled', false);
		});
	})


</script>

</body>
</html>