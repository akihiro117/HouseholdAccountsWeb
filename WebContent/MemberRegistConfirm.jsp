<!--
MemberRegistConfirm.jsp
Created by Akihiro Yamada on 2018/08/10.
Copyright (c) 2018. All Rights Reserved.
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録確認</title>
</head>
<body>
<div align="center">
<p>以下の内容で登録します</p>
</div>
<div align="center">
<table>
<tr><td>氏名:</td><td>${member.name }</td></tr>
<tr><td>初期残高:</td><td>${member.balance }</td></tr>
<tr><td>メールアドレス:</td>
<c:choose>
<c:when test="${member.email != null }">
<td><c:out value="${member.email }"></c:out></td>
</c:when>
<c:otherwise>
<td></td>
</c:otherwise>
</c:choose>
</tr>
<tr><td>パスワード:</td><td>セキュリティのため表示しません</td></tr>
<tr><td></td>
<td>
<form action="ManagementServlet" method="post">
<input type="hidden" name="command" value="RegistMember">
<input type="submit" formaction="" value="登録">
<a href="MemberRegistForm.jsp">戻る</a>
</form>
</table>
</div>

</body>
</html>