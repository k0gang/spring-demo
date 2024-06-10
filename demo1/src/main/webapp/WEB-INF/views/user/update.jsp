<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Update Page</h1>
    <form action="/user/update" method="post">
        <!-- 입력 필드 예시 -->
        <label for="username">New Username:</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">New Password:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>