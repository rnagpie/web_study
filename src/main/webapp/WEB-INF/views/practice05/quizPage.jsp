<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퀴즈 페이지 - ${quizPageId}</title>
</head>
<body>
    <h1>퀴즈 페이지: ${quizPageId}</h1>
    <p><strong>${productInfo}</strong></p>

    <h2>다른 페이지로 이동:</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/practice05/pathA">퀴즈 페이지 A (직접 경로)</a></li>
        <li><a href="${pageContext.request.contextPath}/practice05/pathB">퀴즈 페이지 B (직접 경로)</a></li>
        <li><a href="${pageContext.request.contextPath}/practice05/pathCommon/A">퀴즈 페이지 A (공통 경로)</a></li>
        <li><a href="${pageContext.request.contextPath}/practice05/pathCommon/B">퀴즈 페이지 B (공통 경로)</a></li>
        <li><a href="${pageContext.request.contextPath}/practice05/pathCommon/C">퀴즈 페이지 C (공통 경로 - 존재하지 않음)</a></li>
    </ul>
</body>
</html>