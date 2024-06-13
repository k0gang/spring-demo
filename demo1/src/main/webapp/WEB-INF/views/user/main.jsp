<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Main Page</h1>

<c:if test="${not empty data }">
	<p>${data}를 전달 받앗습니다.</p>
</c:if>
<p>${data }</p>
<p>${log }</p>
<p></p>
</body>
</html>