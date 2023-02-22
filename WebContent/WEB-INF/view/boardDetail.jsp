<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<meta charset="UTF-8">
<title>게시글 상세</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
<fmt:formatDate type="both" pattern="yyyy/MM/dd/HH:mm" var="pdate" value="${post.nowDate }"/>



<div class="container my-3">
    <!-- 질문 -->
    <div class="border-bottom py-2"><h5 class="card-title">게시글 제목: ${post.postName }</h5> <span class="card-subtitle"  >게임이름: ${post.gameName }</span></div>
    	<br>
    	<div style="float: right">
 		   	닉네임: ${post.nickname }
    	</div>
 		   	<br>
 		 <div>장르: ${genreList } <span style="float: right">${pdate}</span> </div>
 		 
 		 <img alt="" src="${imgPath }">
    <div class="card my-3 ">
        <div class="card-body" >
            <div class="card-text" style="white-space: pre-line;"> ${post.contents } </div>
            <div class="d-flex justify-content-end">
                <div class="badge bg-light text-dark p-2">
                    
                </div>
            </div>
        </div>
    </div>
    
    <br>
    <br>
    <br>
    <br>
    <br>
    
   
    <!-- 답변 목록 -->
    <h5 class="border-bottom my-3 py-2" style="margin-top:200px">댓글 목록</h5>
    <c:forEach items="${cList }" var="cl">
    <fmt:formatDate type="both" pattern="yyyy/MM/dd/HH:mm" var="date" value="${cl.nowdate }"/>
    ${cl.nickname}
    <div class="card my-3">
        <div class="card-body">
            <div class="card-text" style="white-space: pre-line;">${cl.cmt}</div>
            <div class="d-flex justify-content-end">
                <div class="badge bg-light text-dark p-2">
                    ${date}
                </div>
            </div>
        </div>
    </div>

    </c:forEach>
    

    

    <!-- 댓글 등록 -->
  <c:choose>
<c:when test="${! empty lgnss}"> 
    <form action="./detail" method="post" class="my-3">
        <div class="mb-3">
        	<input  name="postid" type="hidden" value="${post.postId }">
       		 <input class="form-control" rows="10" id="input" name="comment" size="100px">
			<button class="btn btn-primary" disabled id="submit">작성</button>	

        </div>
    </form>
    </c:when>
<c:otherwise>
    <input name="postid" type="hidden" value="${post.postId }">
	<label>댓글작성</label>
	<input class="form-control"  rows="10" id="textarea" name="comment">
	<button class="btn btn-primary" id="dummy" type="button">작성</button>	
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