<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.example.demo1.user.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<h1>code : <%= user.getCode() %> 님 안녕하세요.</h1>
<p>Username: <%= user.getUserName() %></p>
<p>First Name: <%= user.getFirstName() %></p>
<p>Email: <%= user.getEmail() %></p>

<a href = "/user/update">회원정보 업데이트</a>
<a href = "/user/delete">회원 탈퇴</a>
<a href = "/user/logout">로그아웃</a>
<a href = "/board/list">게시판</a>

</body>
</html>