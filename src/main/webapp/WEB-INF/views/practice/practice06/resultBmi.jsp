<%-- src/main/webapp/WEB-INF/views/practice/practice06/askBmi.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI 계산기</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    form { border: 1px solid #ccc; padding: 20px; border-radius: 8px; max-width: 400px; margin: 0 auto; }
    div { margin-bottom: 10px; }
    label { display: inline-block; width: 80px; font-weight: bold; }
    input[type="text"], input[type="number"] { width: 200px; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
    button { padding: 10px 15px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
    button:hover { background-color: #0056b3; }
</style>
</head>
<body>
    <h1>BMI 계산</h1>
    <form action="${pageContext.request.contextPath}/practice06/result-bmi" method="post">
        <div>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="height">키 (cm):</label>
            <input type="number" id="height" name="height" step="0.1" min="1" required>
        </div>
        <div>
            <label for="weight">몸무게 (kg):</label>
            <input type="number" id="weight" name="weight" step="0.1" min="1" required>
        </div>
        <div>
            <button type="submit">확인하기</button>
        </div>
    </form>
</body>
</html>