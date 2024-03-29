<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />	
	<div class="container mt-3">
	<div id= checkpassword >
		<h4>비밀번호를 다시 한번 입력해 주십시오</h4>
		<input class="form-control w-50" id=inputpass type="password"> 
		<button class="mt-3 btn btn-primary" id="check" type="button">비밀번호 확인</button>
		<span id="error"></span>
	</div>
	
	<div id="update" style="display: none">
		<div >
			<form action="./updateinfo" method="post">
				<label>닉네임 수정</label>
				<input class="form-control w-50" name="nickname" value="${info.nickname }">
				<label>이메일 수정</label>
				<input class="form-control w-50" name="email" value="${info.email }"> 	
					
					
		<br>
		
			
				<label>새 비밀번호 </label>
				<input class="form-control w-50" name="newPwd" type="password">
				<label>비밀번호 확인</label>
				<input class="form-control w-50" name="chkNewPwd" type="password"> 	
				<button class="mt-3 w-25 btn btn-lg btn-primary" id="post" type="button">변경</button> 
			</form>
		</div>
	</div>
	</div>
	
</body>
<script type="text/javascript">
	$("#check").on("click",open);
	function open(){
		if("${info.password}" === $("#inputpass").val()){			
			$("#update").css("display","block");
			$("#checkpassword").css("display","none");
		}else{
			$("#error").text("비밀번호가 일치하지 않습니다.");
		}
	}

	
	$("#post").on("click",ensure);
	function ensure() {
	var nickname =$("input[name=nickname]").val();
	var email =$("input[name=email]").val();
	var newPwd =$("input[name=newPwd]").val();
	var chkNewPwd =$("input[name=chkNewPwd]").val();
	
	 $.ajax({
			url :  "updateinfo",
			data :	{nickname:nickname,
					email:email,
					newPwd:newPwd,
					chkNewPwd:chkNewPwd},
			type : "post",
			dataType:"json",
			success: function(data){
				var msg = data.msg
				var error = data.error
				if(msg!=''){					
					if(error==true){
					alert(msg);										
					}else{
						alert(msg);
						location="<%=request.getContextPath()%>/logout";
					}	
				}
				
			},
			error: function(){
				console.log("실패");
			},
			complete:function(){
				console.log("무조건 호출");
				console.log(nickname);
				console.log(email);
				console.log(newPwd);
				console.log(chkNewPwd);

			},
		 });
	}
</script>
</html>