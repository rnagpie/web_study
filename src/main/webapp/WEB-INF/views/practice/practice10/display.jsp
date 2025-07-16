<%-- /WEB-INF/views/practice/practice10/display.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Practice 10 Result</h1>

    <p>${message}</p>

    <%-- OriginalX 부분을 명확하게 처리 --%>
    <c:choose>
        <c:when test="${message == 'FromA'}">
            <p>OriginalA</p>
        </c:when>
        <c:when test="${message == 'FromB'}">
            <p>OriginalB</p>
        </c:when>
        <c:otherwise>
            <%-- FromA, FromB가 아닌 다른 메시지가 올 경우의 처리 (선택 사항) --%>
            <p>Original${message}</p>
        </c:otherwise>
    </c:choose>


    <%-- messageFromB가 세션에 존재하고 현재 message와 다를 경우에만 출력 --%>
    <c:if test="${not empty messageFromB && messageFromB ne message}">
        <p>${messageFromB}</p>
    </c:if>

    <hr>
    <p><a href="/practice10/A">Go to /practice10/A</a></p>
    <p><a href="/practice10/B">Go to /practice10/B</a></p>
    <p><a href="/practice10/resetSession">Reset Session (Clear FromB)</a></p>
</body> 
</html>