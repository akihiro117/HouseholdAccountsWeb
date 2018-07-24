<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿アプリケーション-ログイン画面</title>
</head>
<body>
<form action="ManagementServlet" method="post">
<div align="center">
ユーザー名:<input type="text" name="userName"><br>
パスワード:<input type="password" name="password"><br>
<input type="submit" value="ログイン"><br>
<a href="RegistUser.jsp">新規登録</a>
</div>
</form>
</body>
</html>