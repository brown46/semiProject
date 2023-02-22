<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp"%>
<meta charset="UTF-8">
<title>게시글 작성</title>


</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
	<h2>게시글 작성 페이지입니다.</h2>
	<form action="./posting" method="post">
		<label>게시글 제목</label> <input name="postTitle" type="text"> <label>게임
			이름</label> <input name="gameTitle" type="text">
		<div id="genreList" style="display: none">
			<ul id="list">
				<c:forEach items="${genreList }" var="genre">
					<li><a name="select" href="#">${genre } </a></li>
				</c:forEach>
			</ul>
			<button id="ensure" type="button">선택 완료</button>
			<div>
				<button id="close" type="button">닫기</button>
			</div>
		</div>
		<div>
			<button id="open" type="button">장르 선택</button>
		</div>

		<div id="selected"></div>
<br>
<br>
		
		<div>
			<label>내용</label>
			<textarea name="contents" cols="50" rows="10"></textarea>
		</div>
		<input type="text" name="img" value="">
		<br>
		<button id="postbtn" type="submit">작성하기</button>
	</form>
	
<form id="uploadForm" action="./uploadfile" enctype="multipart/form-data" method="post">
		<input  type="file" name="uploadFile"><br>
		<button id="filebtn" type="button">파일 업로드</button>
</form>	
	
	
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

$("#filebtn").on("click", fileUpload);
function fileUpload() {
    var form = $("form")[1];
	var formData = new FormData(form);

	$.ajax({
		url : "uploadfile",
		processData: false,
        contentType: false,
		type : "post",
		data : formData,
		success : function() {
			console.log("ajax 성공");
			console.log($("input[name=uploadFile]").val());
			$("input[name=img]").attr('value',$("input[name=uploadFile]").val());
		},
		error : function() {
			console.log("실패");
		},
		complete : function() {
			console.log("무조건 호출");
		},
	});
}





	$("a[name=select]").on("click", selectGenre);

	function selectGenre() {
		$(this).closest("li").remove();
		console.log($(this).text());
		var span = document.createElement("span");
		span.innerText = $(this).text();
		$("#selected").append(span);

	}

	$("#ensure").on("click", ensure);
	function ensure() {
		var input = $("#selected").text();
		$.ajax({
			url : "posting",
			data : {
				input : input
			},
			type : "get",
			success : function() {
				console.log("ajax 성공");
			},
			error : function() {
				console.log("실패");
			},
			complete : function() {
				console.log("무조건 호출");
			},
		});
	}

	$("#open").on("click", divOpen);
	function divOpen() {
		$("#genreList").css("display", "block");
		$("#open").css("display", "none");
		
	}

	$("#close").on("click", divClose);
	function divClose() {
		$("#genreList").css("display", "none");
		$("#open").css("display", "block");
	}


$("#upload").on("click",handlerClickBtnupload);
function handlerClickBtnupload() {
	console.log('??');
	window.open("${contextPath}/myProject/uploadfile?postId=${postId }", "width=500,height=300" )
	console.log(this);
}

</script>


</html>

