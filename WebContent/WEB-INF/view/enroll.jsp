<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.3.js" charset="UTF-8"></script>
<script src="./resource/js/myJavascript.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />	
	<div class="container">
	<form action="./dupChk" method="post">
		<div>
			<label class="mt-3">아이디 :</label>		
			<input class="form-control w-50" type="text" name=id  >
			
		</div>

		<div>
			<label class="mt-3">닉네임 :</label>		
			<input class="form-control w-50" type="text" name=nickname >
		</div>
			<button class="mt-3 w-25 btn btn-lg btn-primary" id="dupChk" type="button" >아이디/닉네임 중복 체크</button>
	</form>	
	<form action="./enroll" method="post">
		<div>
			<label class="mt-3">이메일 :</label> 
			<input class="form-control w-50" type="text" name=email>		
		</div>
		<div>
			<label class="mt-3">비밀번호 :</label> 
			<input class="form-control w-50" type="password" name=password>
		</div>
		<div>
			<label class="mt-3">비밀번호 확인 :	</label> 		
			<input class="form-control w-50" type="password" name=passwordChk>
		</div>
		
		
		<button class="mt-3 w-25 btn btn-lg btn-primary" type="submit">회원 가입</button>
		
	</form>
	</div>
<script type="text/javascript">
$("#dupChk").on("click",handlerClickBtnDupChk);
function handlerClickBtnDupChk(){
    var form = document.forms[0];
    var id = form.id.value;
    var nickname= form.nickname.value;
    if(id.length!==0&&nickname.length!==0){
        window.open("${contextPath}/myProject/dupChk?id="+id+"&nickname="+nickname,"","width=500,height=300");
    }else{
        if( $("#dupChk").next()!==null){
            $("#dupChk").next().remove();
        }
        var error= createErrormessage("아이디와 닉네임을 모두 입력해 주세요");
        $("#dupChk").after(error);
    }
	console.log("btnEnroll눌림");

}
</script>

</body>
</html>


