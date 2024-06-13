<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update board</title>
</head>
<body>
	<h1>Board update</h1>
	<form action="update/action" id="updateForm">
        <!-- 입력 필드 예시 -->
        <input type="hidden" id="code" name="code" value="${board.code }">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" placeholder="${board.title }" ><br>
        <label for="content">Content:</label>
        <input type="text" id="content" name="content" placeholder="${board.content } "><br>

        <input type="submit" value="Update">
    </form>
</body>
</html>