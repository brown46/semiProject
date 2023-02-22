  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
   <header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <!-- 타이틀 -->
      <a style="margin-left:20px" class="navbar-brand" href="./">사이트 이름</a>
      <!-- 모바일의 경우 토클 메뉴 버튼 -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <!-- 메뉴 -->

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <c:choose>
			<c:when test="${not empty sessionScope.lgnss }">	
          <li class="nav-item">
            <a class="nav-link" href="./logout">로그아웃</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="./mypage">마이페이지</a>
          </li>
          </c:when>
		<c:otherwise>

          <li class="nav-item">
            <a class="nav-link" href="./login">로그인</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="./enroll">회원가입</a>
          </li>
         </c:otherwise>
		</c:choose> 
         
        </ul>
       
      </div>
    </nav>
  </header>
