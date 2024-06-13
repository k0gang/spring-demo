<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board detail</title>
</head>
<body>
	<h1>Board detail</h1>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Date</th>
				<th>content</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${board.title}</td>
				<td>${board.author}</td>
				<td><fmt:formatDate value="${board.regDate}"
						pattern="yyyy-MM-dd" /></td>
				<td>${board.content}</td>
			</tr>
		</tbody>
	</table>
	<c:if test="${sessionScope.log eq board.author}">
		<a href="/board/delete?code=${board.code }">글 삭제</a>
		<a href="/board/update?code=${board.code }">글 수정</a>
	</c:if>
</body>
</html>