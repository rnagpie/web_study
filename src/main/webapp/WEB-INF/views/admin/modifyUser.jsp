<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="/admin/users/add" method="post">


		<input type="hidden" name="id" value="${user.id }"> 사용자 아이디 :<input
			type="text" name="id" value="${user.id}" disabled><br>
		사용자 비번 <input type="password" name="pw" value="${user.pw}"><br>
		사용자 이름 <input type="text" name="name" value="${user.name}"><br>


		사용자 계정 타입 구분<br> <label>고객(사용자)<input type="radio"
			name="userType" value="CUS">
		<c:if test="${user.userType == 'CUS'}">checked</c:if></label> <label>관리자
			<input type="radio" name="userType" value="ADM">
		<c:if test="${user.userType == 'ADM'}">checked</c:if>
		</label> <br>
		<br>
		<button type="submit">수정하기</button>
		<button type="button" onClick="location.href='/admin/user/${user.id}'">취소</button>
	</form>
</body>
</html>