<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <h1>Login page</h1>
    <form id="loginForm">
        <!-- 입력 필드 예시 -->
        <label for="userName">Username:</label>
        <input type="text" id="userName" name="userName"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Login">
    </form>

    <script src="/resources/script/loginForm.js"></script>
</body>
</html>
