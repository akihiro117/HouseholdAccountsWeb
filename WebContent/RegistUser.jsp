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
ユーザー名:
<input type="text" name="userName"><br>
現在の残高:
<input type="text" name="initBalance"><br>
パスワード(半角英数字8文字以上):
<input type="password" name="password"><br>
パスワード(確認)
<input type="password" name="cofirmPassword"><br>
<input type="submit" value="新規登録">
</form>
</div>
</body>
</html>