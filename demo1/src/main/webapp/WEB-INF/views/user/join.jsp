<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
</head>
<body>
    <h1>Join page</h1>
    <form id="joinForm">
        <!-- 입력 필드 예시 -->
        <label for="userName">Username:</label>
        <input type="text" id="userName" name="userName"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName"><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br>
        <input type="submit" value="Join">
    </form>

    <script src="/resources/script/joinForm.js"></script>
</body>
</html>
