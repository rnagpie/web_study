<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Test Result</title>
</head>
<body>

	<h1>List Output</h1>
	
	<c:choose>
	    <c:when test="${listType eq 'string'}">
	        <h2>스트링 리스트 출력 (${fn:length(resultList)} 줄)</h2>
	        <c:forEach var="item" items="${resultList}">
	            <p>${item}</p>
	        </c:forEach>
	    </c:when>
	    <c:when test="${listType eq 'member'}">
	        <h2>회원 리스트 출력 (${fn:length(resultList)} 줄)</h2>
	        <c:forEach var="member" items="${resultList}">
	            <p>${member.id} ${member.pw} ${member.name}</p>
	        </c:forEach>
	    </c:when>
	    <c:otherwise>
	        <p>${message}</p>
	    </c:otherwise>
	</c:choose>

    <%-- JSTL fn 라이브러리 추가를 위한 선언 (필요한 경우) --%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

</body>
</html>