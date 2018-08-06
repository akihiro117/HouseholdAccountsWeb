<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<div align="center">
<form action="ManagementServlet">
<table>
<tr><td>ユーザー名*:</td>
<td><input type="text" name="userName"></td></tr>
<tr><td>現在の残高:</td>
<td><input type="text" name="initBalance"></td></tr>
<tr><td>パスワード(半角英数字8文字以上)*:</td>
<td><input type="password" name="password"></td></tr>
<tr><td>パスワード(確認)*:</td>
<td><input type="password" name="confirmPassword"></td></tr>
</table>
<input type="submit" value="新規登録">
</form>
</div>
</body>
</html>