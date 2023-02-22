<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />	
	<c:url var="boardUrl" value="/board" />
	<div class="container">
		<h2>게시글 목록</h2>
	</div>
	
	<form action="${boardUrl }">
		<div class="container">
			<select name="cnt" onchange="submit();">
				<option value="2"${requestScope.cnt eq 2 ? "selected" : "" }>2개</option>
				<option value="10"${requestScope.cnt eq 10 ? "selected" : "" }>10개</option>
				<option value="15"${requestScope.cnt eq 15 ? "selected" : "" }>15개</option>
				<option value="20"${requestScope.cnt eq 20 ? "selected" : "" }>20개</option>
				<option value="25"${requestScope.cnt eq 25 ? "selected" : "" }>25개</option>
				<option value="30"${requestScope.cnt eq 30 ? "selected" : "" }>30개</option>
			</select>
		</div>	
	</form>	
	
	<div class="container">
	
	<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th class="col-1" >글 번호</th>
					<th>게임 이름</th>
					<th class="col-6">게시글 제목</th>
					<th>닉네임</th>
					<th class="col-1">날짜</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach var="data" items="${requestScope.dataList }">
					<fmt:formatDate type="both" pattern="yyyy/MM/dd/HH:mm" var="date" value="${data.nowDate }"/>
				<tr>
					<td>${data.postId }</td>
					<td>${data.gameName }</td>
					<td><a style="text-decoration:none" href="<%=request.getContextPath()%>/detail?postId=${data.postId}">${data.postName }</a> </th>
					<td>${data.nickname }</td>
					<td>${date }</td>
				</tr>
					</c:forEach>
			
			</tbody>
		
		</table>
	
	
	
	<div >
	
	
	<div>
	<ul class="pagination"> 
		<c:set var="pageNumber" value="${empty param.p ? 1 : param.p }" />
		<c:choose>
			<c:when test="${pageNumber eq 1 }">
			<li class="page-item">
				<a class="page-link">prev</a>
			</li>
			</c:when>
			<c:otherwise>
			<li class="page-item">
				<a class="page-link"  href="${boardUrl }?p=${pageNumber-1}">prev</a>
			</li>	
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${requestScope.pageStart }" end ="${requestScope.pageEnd}">
			<li class="page-item ${i eq pageNumber ? 'active':'' }">
				<a class="page-link" href="${boardUrl }?p=${i } ">${i }</a>
			</li>
		</c:forEach>
		<c:choose>
			<c:when test="${pageNumber eq pageEnd }">
			<li class="page-item">
				<a class="page-link">next</a>
			</li>	
			</c:when>
		
			<c:otherwise>
			<li class="page-item">
				<a class="page-link" href="${boardUrl }?p=${pageNumber+1}">next</a>
			</li>
			</c:otherwise>
		</c:choose>
	</ul>
	</div>
</body>
</html>