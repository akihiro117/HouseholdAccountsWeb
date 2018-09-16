<!--
LoginForm.jsp
Created by Akihiro Yamada on 2018/08/22.
Copyright (c) 2018. All Rights Reserved.
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインページ</title>
</head>
<body>
残金総額:${member.balance }<br>
<table border="1" width="80%">
<tr><th>日付</th><th>内容</th><th>支出</th><th>収入</th></tr>
<c:forEach var="l" items="${log }">
<c:choose>
<c:when test="${l.isIncome == false }">
<tr><td><c:out value="${l.exchangeDateStr }"/></td><td><c:out value="${l.detail }"/></td><td><c:out value="${l.amount }"/></td><td></td></tr>
</c:when>
<c:otherwise>
<tr><td><c:out value="${l.exchangeDateStr }"/></td><td><c:out value="${l.detail }"/></td><td></td><td><c:out value="${l.amount }"/></td></tr>
</c:otherwise>
</c:choose>
</c:forEach>
</table>


</body>
</html>