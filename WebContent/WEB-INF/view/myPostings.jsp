<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />	
	<h2>내 게시물 목록</h2>
	<c:url var="mypostingUrl" value="/myposting" />

	
	<form action="${mypostingUrl }">
		<div>
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
	
	
	
	<ul>
		<c:forEach var="data" items="${requestScope.dataList }">
			
			<fmt:formatDate type="both" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" var="date" value="${data.nowDate }"/>
			<li>${data.nickname } |${data.contents } | ${date } |${data.gameName }</li>
		</c:forEach>
	</ul>
	<div>
		<c:set var="pageNumber" value="${empty param.p ? 1 : param.p }" />
		<c:choose>
			<c:when test="${pageNumber eq 1 }">
				<a>prev</a>
			</c:when>
			<c:otherwise>
				<a href="${mypostingUrl }?p=${pageNumber-1}">prev</a>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${requestScope.pageStart }" end ="${requestScope.pageEnd}">
			<a href="${mypostingUrl }?p=${i } ">${i }</a>
		</c:forEach>
		<c:choose>
			<c:when test="${pageNumber eq pageEnd }">
				<a>next</a>
			</c:when>
		
			<c:otherwise>
				<a href="${mypostingUrl }?p=${pageNumber+1}">next</a>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>