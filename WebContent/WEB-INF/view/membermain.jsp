<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<meta charset="UTF-8">
<style>
.bd-navbar {
  position: sticky;
  top: 0;
  z-index: 1071;
  min-height: 4rem;
  box-shadow: 0 0.5rem 1rem rgba(0,0,0,.05), inset 0 -1px 0 rgba(0,0,0,.1);
}
.bd-sidebar {
  position: sticky;
  top: 4rem;
  z-index: 1000;
  height: calc(100vh - 4rem);
  background: #eee;
  border-right: 1px solid rgba(0,0,0,.1);
  overflow-y: auto;
  min-width: 160px;
  max-width: 220px;
}
.bd-sidebar .nav {
  display: block;
}
.bd-sidebar .nav>li>a {
  display: block;
  padding: .25rem 1.5rem;
  font-size: 90%;
}
</style>
<title>메인페이지</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
<div class="container-fluid">
  <div class="row flex-nowrap">
    <div class="col-2 bd-sidebar">
      <ul class="nav">
        <li><a style="text-decoration:none; font-size: larger " href="./board">게시글 목록보기 </a> </li>
        <li><a style="text-decoration:none; font-size: larger " href="./posting">게시글 작성 </a> </li>
        <li><a style="text-decoration:none; font-size: larger " href="./recommend">추천 받기 </a> </li>
        <li><a style="text-decoration:none; font-size: larger " href="./#">장르 추가 요청 </a> </li>
      </ul>

    </div>
    <main class="col-9 py-md-3 pl-md-5 bd-content" role="main">
      <h1>회원 메인페이지</h1>
        <form action="./search" class="form-inline my-2 my-lg-0">
        	<select class="form-select form-select-sm w-25" aria-label=".form-select-sm example" name="kinds">
        		<option value="name" selected> 이름으로 검색
        		<option value="genre"> 장르로 검색 
			</select>	
        
          	검색<input id="search" class="form-control mr-sm-2 w-50"  type="text"  name="keyword" placeholder="검색어를 입력해 주세요" aria-label="Search">
          
        
          	<button id="searchbutton"  class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
          
        </form>
      
    </main>
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
