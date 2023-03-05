<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp"%>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
	
	<c:url var="searchUrl" value="/search" />
	

<div class="container">
      <div class="row">
        <div class="col-12">
          <h2>검색된 목록(장르별)</h2>
          <form action="${searchUrl }">
		<input type="hidden" name="kinds" value="${kinds }"> <input
			type="hidden" name="keyword" value="${keyword }">
		<div>
			<select name="cnt" onchange="submit();">
				<option value="2" ${requestScope.cnt eq 2 ? "selected" : "" }>2개</option>
				<option value="10" ${requestScope.cnt eq 10 ? "selected" : "" }>10개</option>
				<option value="15" ${requestScope.cnt eq 15 ? "selected" : "" }>15개</option>
				<option value="20" ${requestScope.cnt eq 20 ? "selected" : "" }>20개</option>
				<option value="25" ${requestScope.cnt eq 25 ? "selected" : "" }>25개</option>
				<option value="30" ${requestScope.cnt eq 30 ? "selected" : "" }>30개</option>
			</select>
		</div>
	</form>
          <ul class="list-group">
            <c:forEach var="data" items="${requestScope.dataList }">
			<li class="list-group-item"><a style="text-decoration:none" href="<%=request.getContextPath()%>/search?kinds=name&keyword=${data }">${data }</a></li>
			</c:forEach>
          </ul>
          
          <ul class="pagination">
			<c:set var="pageNumber" value="${empty param.p ? 1 : param.p }" />
			<c:choose>
				<c:when test="${pageNumber eq 1 }">
					<li class="page-item"><a class="page-link">prev</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="${searchUrl }?p=${pageNumber-1}">prev</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${requestScope.pageStart }"
				end="${requestScope.pageEnd}">
				<li class="page-item ${i eq pageNumber ? 'active':'' }"><a
					class="page-link"
					href="${searchUrl }?p=${i }&kinds=${kinds}&keyword=${keyword } ">${i }</a>
				</li>
			</c:forEach>
			<c:choose>
				<c:when test="${pageNumber eq pageEnd }">
					<li class="page-item"><a class="page-link">next</a></li>
				</c:when>
				<c:when test="${pageEnd eq 0 }">
					<li class="page-item"><a class="page-link">next</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="${searchUrl }?p=${pageNumber+1}">next</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
        </div>
      </div>
    </div>
    
	<div >
	<ul >
		
	</ul>
	</div>
	<div>
		
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>