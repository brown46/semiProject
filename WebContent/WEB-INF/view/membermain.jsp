<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
<div>
회원 메인페이지
<form action="./search">
<select name="kinds">
        <option value="name" selected> 이름으로 검색
        <option value="genre"> 장르로 검색 
</select>
<div>
	검색 <input id="search" type="text" name="keyword">
	<button disabled="true" id="searchbutton"  type="submit">검색 </button>
</div>
</form>

<div>
	<a href="./board">게시글 목록 보기</a>
</div>

<div>
	<a href="./posting">게시글 작성</a>
</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$('#search').on('input' ,function(){
		if($('#search').val()=='')
			$ ('#searchbutton').attr('disabled', true);
		else
			$('#searchbutton').attr('disabled', false);
	});
})
</script>
</html>
