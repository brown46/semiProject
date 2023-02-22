<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>마이페이지</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />

<div class="container-fluid">
  <div class="row flex-nowrap">
    <div class="col-3 bd-sidebar">
      <ul class="nav">
        <li><a style="text-decoration:none; font-size: larger " href="<%=request.getContextPath()%>/myposting">내 게시물 확인 </a> </li>
        <li><a style="text-decoration:none; font-size: larger " href="<%=request.getContextPath()%>/updateinfo">회원 정보 수정</a></li>
        <li><a style="text-decoration:none; font-size: larger " href="<%=request.getContextPath()%>/withdrawal">회원 탈퇴</a></li>

      </ul>

    </div>
    <main class="col-9 py-md-3 pl-md-5 bd-content" role="main">
      <h1>마이페이지</h1>
      <h3>${sessionScope.lgnss.nickname }님 안녕하세요</h3>
      <h3>이메일: ${sessionScope.lgnss.email }</h3>
    </main>
  </div>
</div>
<h1><a href="<%=request.getContextPath()%>/myposting">내 게시물 확인 </a> </h1>
<h1> <a href="<%=request.getContextPath()%>/updateinfo">회원 정보 수정</a> </h1>
<h1> <a href="<%=request.getContextPath()%>/withdrawal">회원 탈퇴</a> </h1>


</body>
</html>