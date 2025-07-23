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
	<h1>관리자 페이지</h1>
	<h2> 호실 정보 수정</h2>
	
		<form action="/admin/modifyRoom" method="post">
		
		<input type= "hidden" name ="roomId" value="${room.roomId}"><br>
		
		<label>건물/동 이름<input type="text" name="buildingName" value="${room.building.Name}"></label><br>
		<label>호실번호<input type="text" name="roomNumber" value="${room.roomNumber}"></label><br>
		<label>층수<input type="text" name="floor" value="${room.floor}"></label><br>
		<label>최대숙박인원<input type="text" name="maxGuestCount" value="${room.maxGuestCount}"></label><br>
		
		<h4>뷰타입</h4>
		<select name="viewType">
			<option value="OCN" <c:if test="${room.viewType == 'OCN'}">selected</c:if> >오션뷰</option>
			<option value="CTY" <c:if test="${room.viewType == 'CTY'}">selected>시티뷰</c:if> ></option>
			<option value="MOT" <c:if test="${room.viewType == 'MOT'}">selected>마운틴뷰</c:if> ></option>
		</select>
			<br>
		<button type="submit">객실추가</button>
	<div>
		<button type="butoon " onClick="location.href='/admin/rooms'">객실 목록보기</button>
	</div>
	</form>
</body>
</html>