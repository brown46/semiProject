<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<meta charset="UTF-8">
<title>추천 페이지</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />


<div class="container mt-5">
<h2>선호하는 게임들을 선택해 주세요</h2>
</div>

<div class="container mt-3">
	<c:forEach var="g" items="${games }">
		<a style="text-decoration:none" name="gname" href="#">${g }</a>/ 
	</c:forEach>
</div>
<div class="container mt-3" id="selected" style="display:block">
</div>	
<div class="container  mt-3">
<button class="btn btn-primary" id="select">선택 완료</button>
</div>









</body>

<script type="text/javascript">

$("a[name=gname]").on("click",selectGame);
function selectGame() {
	$(this).remove();
	console.log($(this).text());

	var span= document.createElement("span");
	span.innerText=$(this).text()+' ';
	$("#selected").append(span);
}

$("#select").on("click",select);
function select() {
var input =$("#selected").text();
 $.ajax({
		url :  "recommend",
		data : {input:input},
		type : "post",
		success: function(){
			console.log("ajax 성공");
			location.href="<%=request.getContextPath()%>/recommendDetail";
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