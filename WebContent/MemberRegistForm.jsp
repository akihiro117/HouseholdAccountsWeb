<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>

<div align="center">
<c:if test="${errMsgs != null }">
<c:forEach var="errMsg" items="${errMsgs }">
<c:out value="${errMsg }" /><br>
</c:forEach>
</c:if>
<form action="ManagementServlet" method="post">
<table>
<tr><td>氏名*:</td>
<td><input type="text" name="name" value="${name }"></td></tr>
<tr><td>初期残高*:</td>
<c:choose>
<c:when test="${balance == null }">
<td><input type="text" name="balance" value="0"></td></c:when>
<c:otherwise>
<td><input type="text" name="balance" value="${balance }"></td></c:otherwise>
</c:choose>
</tr>
<tr><td>メールアドレス*:</td>
<td><input type="text" name="email" value="${email }"></td></tr>
<tr><td>パスワード(半角英数字8文字以上)*:</td>
<td><input type="password" name="password1"></td></tr>
<tr><td>パスワード(確認)*:</td>
<td><input type="password" name="password2"></td></tr>
</table>
<input type="hidden" name="command" value="MemberRegistConfirm">
<input type="submit" value="新規登録">
</form>
</div>

</body>
</html>