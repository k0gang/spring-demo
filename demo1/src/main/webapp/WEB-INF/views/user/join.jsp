<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Join page</h1>
<form action="/user/join" method="post">
        <!-- 입력 필드 예시 -->
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br>
        <label for="id">Id:</label>
        <input type="text" id="id" name="id"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Join">
    </form>
</body>
</html>