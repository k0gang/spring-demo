<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardwrite</title>
</head>
<body>
	<h1>Board Write</h1>
	<form action="write/action" id="writeForm">
        <!-- 입력 필드 예시 -->
        <label for="title">Title:</label>
        <input type="text" id="title" name="title"><br>
        <label for="content">Content:</label>
        <input type="text" id="content" name="content"><br>

        <input type="submit" value="Write">
    </form>
	
</body>
</html>