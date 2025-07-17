<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Practice 12 - Count Page</title>
</head>
<body>
    <h1>Count Page</h1>
    
    
    <c:choose>
    	<c:when test ="${empty loginId || login == ''}">
    		<p>익명의 사용자 환영합니다</p>
    		<p>로그인한 사용자 환영합니다</p>
    	</c:when>
    	<c:otherwise>
    		<p>${loginId} 님 환영합니다.</p>
    	</c:otherwise>
    </c:choose>
    
    
    
    
    
    
    <p>${loginId}</p>
    <p>접속횟수 : ${count}</p>
     
    
    <p>환영합니다, <strong>${loggedInId}</strong>님!</p>
    <p>이 페이지에 <strong><span style="font-size: 2em; color: blue;">${accessCount}</span></strong>번 접속하셨습니다.</p>
    <p>이 페이지는 로그인한 사용자만 접근할 수 있습니다.</p>
    <hr>
    <p><a href="/practice12/logout">로그아웃</a></p>
    <p><a href="/practice12/login">로그인 페이지로 돌아가기</a></p>
</body>
</html>