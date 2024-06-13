<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardlist</title>
</head>
<body>
    <h1>Board List</h1>
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
            <c:forEach var="board" items="${boardList}">
                <tr>
                    <td><a href="/board/detail?code=${board.code }">${board.title}</a></td>
                    <td>${board.author}</td>
                    <td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd"/></td>
                    <td>${board.content}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <c:if test="${not empty sessionScope.log}">
        <a href="/board/write">글 작성</a>
    </c:if>
</body>
</html>