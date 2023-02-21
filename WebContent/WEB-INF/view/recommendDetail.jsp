<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/module/css_js_import.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />

<div>
중복되는 상위 3개 장르를 가지고 있는 게임들입니다.
</div>
<div>
장르가 ${top3[0]}인 게임들 ${list0 }
</div>
<div>
장르가 ${top3[1]}인 게임들 ${list1 }
</div>
<div>
장르가 ${top3[2]}인 게임들 ${list2 }
</div>
</body>
</html>