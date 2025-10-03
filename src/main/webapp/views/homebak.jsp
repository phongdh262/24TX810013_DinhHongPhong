<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
<style>
    body { font-family: sans-serif; padding: 20px; }
    .welcome { color: #0056b3; }
    .task-list { list-style-type: square; }
    .logout-btn { 
        background-color: #f44336; 
        color: white; 
        padding: 10px 15px; 
        text-align: center; 
        text-decoration: none; 
        display: inline-block; 
        border-radius: 5px;
    }
</style>
</head>
<body>

    <core:if test="${not empty sessionScope.loggedInUser}">
        <h1 class="welcome">
            Xin chào, <core:out value="${sessionScope.loggedInUser}"/>!
        </h1>
        <p>Chào mừng bạn đã quay trở lại hệ thống.</p>
        
        <a href="logout" class="logout-btn">Đăng xuất</a>
        
        <h3>Danh sách công việc hôm nay:</h3>
        <ul class="task-list">
            <core:forEach var="task" items="${taskList}">
                <li><core:out value="${task}"/></li>
            </core:forEach>
        </ul>
    </core:if>

    <core:if test="${empty sessionScope.loggedInUser}">
        <h2>Đăng nhập thành công!</h2>
        <p>Quay lại trang đăng nhập.</p>
        <a href="logout">Đăng xuất</a>
    </core:if>

</body>
</html>